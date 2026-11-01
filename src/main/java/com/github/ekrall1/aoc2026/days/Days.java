package com.github.ekrall1.aoc2026.days;

public final class Days {
    private Days() {}

    public static Day forDay(int day) {
        return switch (day) {
            case 1 -> new Day01();
            default -> throw new IllegalArgumentException("Day " + day + " is not implemented yet");
        };
    }
}

