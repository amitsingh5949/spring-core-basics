package com.javadwarf.springcore.aop1.aspects;

import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;

public class Test123 {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("HACL", 100);
        map.put("sds", 1040);
        map.put("reHACL", 44);
        map.put("reer", 22);

//      Collection<Map.Entry<String,Integer>> sortedEntries =
        List<String> companyNames = map.entrySet().stream().sorted((b, a) -> {
            if (a.getValue() > b.getValue()) return 1;
            else if (a.getValue() < b.getValue()) return -1;
            else return 0;
        }).map(e -> e.getKey())

                .collect(Collectors.toList());
        System.out.println(Arrays.toString(companyNames.toArray()));

    }
}
