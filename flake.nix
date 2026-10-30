{
  description = "Build and test Advent of Code 2026";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs =
    { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
      jdk = pkgs.jdk25;
      maven = pkgs.maven.override { jdk_headless = pkgs.jdk25_headless; };

      aoc2026 = maven.buildMavenPackage {
        pname = "aoc2026";
        version = "0.1.0";
        src = ./.;

        mvnJdk = jdk;
        mvnHash = "sha256-3ArHnMoZiwzo512yRUifpeqk8atVnAwyh2fc0EFvKvk=";

        nativeBuildInputs = [ pkgs.makeWrapper ];

        installPhase = ''
          runHook preInstall

          mkdir -p "$out/bin" "$out/share/java"
          install -Dm644 target/aoc2026-0.1.0.jar "$out/share/java/aoc2026.jar"
          makeWrapper ${jdk}/bin/java "$out/bin/aoc2026" \
            --add-flags "-jar $out/share/java/aoc2026.jar"

          runHook postInstall
        '';
      };
    in
    {
      packages.${system}.default = aoc2026;

      checks.${system}.aoc2026-test = aoc2026;

      devShells.${system}.default = pkgs.mkShell {
        packages = [
          jdk
          maven
        ];

        shellHook = ''
          export JAVA_HOME=${jdk}
          echo "Entering the Advent of Code 2026 Java shell"
          echo "Java: $(java --version | head -n 1)"
        '';
      };
    };
}

