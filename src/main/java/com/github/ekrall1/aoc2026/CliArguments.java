package com.github.ekrall1.aoc2026;

import java.nio.file.Path;

record CliArguments(int day, int part, Path inputFile) {
    static CliArguments parse(String[] args) {
        Integer day = null;
        Integer part = null;
        Path inputFile = null;

        for (int index = 0; index < args.length; index++) {
            String argument = args[index];
            switch (argument) {
                case "--day" -> day = parseInteger(argument, valueAfter(args, ++index, argument));
                case "--part" -> part = parseInteger(argument, valueAfter(args, ++index, argument));
                case "--inputfile" -> inputFile = Path.of(valueAfter(args, ++index, argument));
                default -> throw new IllegalArgumentException("Unknown argument: " + argument);
            }
        }

        if (day == null) {
            throw new IllegalArgumentException("Day is required");
        }
        if (day < 1 || day > 25) {
            throw new IllegalArgumentException("Day must be between 1 and 25, got: " + day);
        }
        if (part == null) {
            throw new IllegalArgumentException("Part is required");
        }
        if (part != 1 && part != 2) {
            throw new IllegalArgumentException("Part must be 1 or 2, got: " + part);
        }
        if (inputFile == null) {
            throw new IllegalArgumentException("Input file is required");
        }

        return new CliArguments(day, part, inputFile);
    }

    static boolean requestsHelp(String[] args) {
        for (String argument : args) {
            if (argument.equals("-h") || argument.equals("--help")) {
                return true;
            }
        }
        return false;
    }

    private static String valueAfter(String[] args, int index, String argument) {
        if (index >= args.length) {
            throw new IllegalArgumentException("Missing value for " + argument);
        }
        return args[index];
    }

    private static int parseInteger(String argument, String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(argument + " must be an integer, got: " + value);
        }
    }
}

