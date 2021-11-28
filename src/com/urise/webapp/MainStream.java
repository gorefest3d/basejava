package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    public static String minValue(int[] values) {
        return IntStream.of(values)
                .distinct().sorted()
                .mapToObj(Integer::toString).collect(Collectors.joining());
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        return sum % 2 != 0 ? integers.stream().filter(i -> i % 2 != 0)
                .collect(Collectors.toList()) : integers.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 1, 6, 2, 2, 3, 7};

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(minValue(values));
        System.out.println(oddOrEven(list));
    }
}
