package com.scaler.Scaler.Sorting;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class BucketSort<T extends Number & Comparable<T>> {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(42, 32, 63, 82, 37, 17, 51, 21, 22, 75);
        System.out.println(new BucketSort<Integer>().sort(ints, (item, size) -> item / size));

        List<Float> floats = Arrays.asList(0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F);
        System.out.println(new BucketSort<Float>().sort(floats, (item, size) -> (int) (item * size)));

        float[] array = new float[]{0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F};
        new ClassicBucketSort().sort(array);
        System.out.println(Arrays.toString(array));

    }

    public List<T> sort(List<T> list, BiFunction<T, Integer, Integer> function) {
        int nbrOfBuckets = list.size();
        Map<Integer, List<T>> buckets = new HashMap<>();
        IntStream.range(0, nbrOfBuckets).forEach(i -> buckets.put(i, new LinkedList<>()));
        list.forEach(item -> buckets.get(function.apply(item, nbrOfBuckets)).add(item));
        buckets.values().forEach(Collections::sort);
        return buckets.values().stream().flatMap(Collection::stream).toList();
    }

}