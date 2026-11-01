package com.github.ekrall1.aoc2026;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

final class MainTest {
    @Test
    void printsHelp() {
        var output = new ByteArrayOutputStream();

        int exitCode = Main.run(new String[] {"--help"}, new PrintStream(output), System.err);

        assertEquals(0, exitCode);
        assertTrue(output.toString().contains("Usage: aoc2026"));
    }

    @Test
    void reportsInvalidArguments() {
        var errors = new ByteArrayOutputStream();

        int exitCode = Main.run(
                new String[] {"--day", "26", "--part", "1", "--inputfile", "input.txt"},
                System.out,
                new PrintStream(errors));

        assertEquals(1, exitCode);
        assertTrue(errors.toString().contains("Day must be between 1 and 25"));
    }
}

