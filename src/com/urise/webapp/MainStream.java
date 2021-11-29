package com.urise.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 5, 6, 2, 2, 3, 7};

        List<Integer> list = Arrays.asList(4, 5, 2);

        System.out.println(minValue(values));
        System.out.println(oddOrEven(list));
    }

    public static int minValue(int[] values) {
        return IntStream.of(values)
                .distinct()
                .sorted()
                .reduce(0,(x, y) -> (x*10)+y);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(numb -> numb).sum();
        return sum % 2 != 0 ?
                integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList())
                : integers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
    }
}
