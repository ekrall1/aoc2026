package com.github.ekrall1.aoc2026;

import com.github.ekrall1.aoc2026.days.Day;
import com.github.ekrall1.aoc2026.days.Days;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        int exitCode = run(args, System.out, System.err);
        if (exitCode != 0) {
            System.exit(exitCode);
        }
    }

    static int run(String[] args, PrintStream out, PrintStream err) {
        if (CliArguments.requestsHelp(args)) {
            printUsage(out);
            return 0;
        }

        try {
            CliArguments options = CliArguments.parse(args);
            String input = Files.readString(options.inputFile()).stripTrailing();
            Day day = Days.forDay(options.day());

            out.printf(
                    "Running Day %d, Part %d with input file: %s%n",
                    options.day(), options.part(), options.inputFile());

            String result = switch (options.part()) {
                case 1 -> day.part1(input);
                case 2 -> day.part2(input);
                default -> throw new IllegalStateException("Unexpected part: " + options.part());
            };

            out.println("Result: " + result);
            return 0;
        } catch (IllegalArgumentException | IOException | UnsupportedOperationException exception) {
            err.println("Error: " + exception.getMessage());
            err.println();
            printUsage(err);
            return 1;
        }
    }

    private static void printUsage(PrintStream output) {
        output.println("""
                Usage: aoc2026 --day <day> --part <part> --inputfile <file>

                Arguments:
                  --day       Day number (1-25)
                  --part      Part number (1 or 2)
                  --inputfile Path to the puzzle input
                  -h, --help  Show this help message

                Example:
                  aoc2026 --day 1 --part 1 --inputfile input/day01.txt
                """);
    }
}

