package com.github.ekrall1.aoc2026;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class MainTest {
    @Test
    void reportsTheEventYear() {
        assertEquals("Advent of Code 2026", Main.greeting());
    }
}

