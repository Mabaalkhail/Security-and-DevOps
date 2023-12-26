package com.example.demo;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class HelpingMethods {
    public static long getCount(List<String> strings) {
        try {
            return countNonEmptyStrings(strings);
        } catch (Exception e) {
            handleException(e);
        }

        return 0L;
    }

    private static long countNonEmptyStrings(List<String> strings) {
        try {
            return strings != null ? strings.stream().filter(s -> !s.isEmpty()).count() : 0L;
        } catch (Exception e) {
            handleException(e);
        }

        return 0L;
    }

    private static void handleException(Exception e) {
        throw new RuntimeException(e);
    }

    public static IntSummaryStatistics getStats(List<Integer> expYears) {
        try {
            return calculateStatistics(expYears);
        } catch (Exception e) {
            handleException(e);
        }

        return new IntSummaryStatistics();
    }

    private static IntSummaryStatistics calculateStatistics(List<Integer> expYears) {
        return expYears != null ? expYears.stream().mapToInt(Integer::intValue).summaryStatistics() : new IntSummaryStatistics();
    }
    public static long getStringsOfLength3(List<String> empNames) {
        try {
            return countStringsOfLength(empNames, 3);
        } catch (Exception e) {
            handleException(e);
        }

        return 0L;
    }
    private static long countStringsOfLength(List<String> empNames, int length) {
        try {
            return empNames != null ? empNames.stream().mapToInt(String::length).filter(len -> len == length).count() : 0L;
        } catch (Exception e) {
            handleException(e);
        }

        return 0L;
    }

    public static List<Integer> getSquareList(List<Integer> expYears) {
        try {
            return calculateSquareList(expYears);
        } catch (Exception e) {
            handleException(e);
        }

        return Collections.emptyList();
    }

    private static List<Integer> calculateSquareList(List<Integer> expYears) {
        return expYears != null ? expYears.stream().map(i -> i * i).distinct().collect(Collectors.toList()) : Collections.emptyList();
    }

    public static String getMergedList(List<String> empNames) {
        try {
            return mergeNonEmptyStrings(empNames);
        } catch (Exception e) {
            handleException(e);
        }

        return "";
    }

    private static String mergeNonEmptyStrings(List<String> empNames) {
        try {
            return empNames != null ? String.join(", ", empNames.stream().filter(s -> !s.isEmpty()).toArray(String[]::new)) : "";
        } catch (Exception e) {
            handleException(e);
        }

        return "";
    }

    public static List<String> getFilteredList(List<String> empNames) {
        try {
            return filterNonEmptyStrings(empNames);
        } catch (Exception e) {
            handleException(e);
        }

        return Collections.emptyList();
    }

    private static List<String> filterNonEmptyStrings(List<String> empNames) {
        return empNames != null ? empNames.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()) : Collections.emptyList();
    }


}
