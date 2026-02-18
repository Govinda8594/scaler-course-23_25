package com.scaler.Scaler.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {


    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = Arrays.stream(s)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
        for (String word : s) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

//            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }

        System.out.println(new ArrayList<>(map.values()));
    }
}
