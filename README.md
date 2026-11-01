# Advent of Code 2026

Solutions for [Advent of Code 2026](https://adventofcode.com/2026), written in Java 25.

## Development

Enter the pinned development environment:

```sh
nix develop
```

Launch the flake-managed VS Code with Java and Nix language support:

```sh
code .
```

Run the tests:

```sh
mvn test
```

Build and run locally:

```sh
mvn package
java -jar target/aoc2026-0.1.0.jar \
  --day 1 \
  --part 1 \
  --inputfile input/day01.txt
```

Run the same checks and build used by CI:

```sh
nix flake check
nix build
./result/bin/aoc2026
```

Run a solution from the Nix build:

```sh
./result/bin/aoc2026 \
  --day 1 \
  --part 1 \
  --inputfile input/day01.txt
```

## Adding a day

Each solution lives in `src/main/java/com/github/ekrall1/aoc2026/days` and
implements the `Day` interface. To add another day:

1. Add `Day02.java` beside `Day01.java`.
2. Add `case 2 -> new Day02();` to `Days.forDay`.
3. Add `Day02Test.java` under the matching test package.
4. Put example input in `src/test/resources/day02.txt` and puzzle input in
   `input/day02.txt`.

Day classes receive the entire input as a string and own their parsing. Shared
utilities can be introduced later if repeated code actually emerges.
