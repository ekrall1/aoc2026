# Advent of Code 2026

Solutions for [Advent of Code 2026](https://adventofcode.com/2026), written in Java 25.

## Development

Enter the pinned development environment:

```sh
nix develop
```

Run the tests:

```sh
mvn test
```

Build and run locally:

```sh
mvn package
java -jar target/aoc2026-0.1.0.jar
```

Run the same checks and build used by CI:

```sh
nix flake check
nix build
./result/bin/aoc2026
```
