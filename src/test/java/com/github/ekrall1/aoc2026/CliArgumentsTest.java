package com.github.ekrall1.aoc2026;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

final class CliArgumentsTest {
    @Test
    void parsesSolveCommand() {
        CliArguments arguments = CliArguments.parse(new String[] {
            "--day", "1", "--part", "2", "--inputfile", "input/day01.txt"
        });

        assertEquals(1, arguments.day());
        assertEquals(2, arguments.part());
        assertEquals(Path.of("input/day01.txt"), arguments.inputFile());
    }
}

