package com.urise.webapp.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{2, 4, 4, 1, 6, 8, 9}));
        System.out.println(oddOrEven(new ArrayList<>(Arrays.asList(2, 4, 4, 1, 7, 6, 8, 3, 0, 9, 11))));
    }
    private static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(a -> a).sum();
        return integers.stream().mapToInt(a -> a)
                .filter((value) -> value % 2 != integers.stream().mapToInt(a -> a).sum() % 2)
                .filter((value) -> value % 2 != sum % 2)
                .boxed()
                .collect(Collectors.toList());
    }
}
