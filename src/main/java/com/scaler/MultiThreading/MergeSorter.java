package com.scaler.MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> arr;
    ExecutorService executorService;

    MergeSorter(List<Integer> list,ExecutorService service){
        arr = list;
        executorService= service;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(arr.size() <= 1)
                return arr;
        int mid = arr.size() /2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftArray.add(arr.get(i));
        }
        for (int i = mid; i < arr.size(); i++) {
            rightArray.add(arr.get(i));
        }
        MergeSorter leftMerge = new MergeSorter(leftArray,executorService);
        MergeSorter rightMerge = new MergeSorter(rightArray,executorService);

        Future<List<Integer>> fLeftSortedArr = executorService.submit(leftMerge);
        Future<List<Integer>> fRightSortedArr = executorService.submit(rightMerge);

        List<Integer> ans = new ArrayList<>();
        List<Integer> leftSortedArr = fLeftSortedArr.get();
        List<Integer> rightSortedArr = fRightSortedArr.get();

        int i =0,j = 0;
        while(i < leftSortedArr.size() && j < rightSortedArr.size()){
            if(leftSortedArr.get(i) < rightSortedArr.get(j)) {
                ans.add(leftSortedArr.get(i));
                i++;
            }else {
                ans.add(rightSortedArr.get(j));
                j++;
            }
        }

        while(i < leftSortedArr.size()){
                ans.add(leftSortedArr.get(i));
                i++;
        }

        while(j < rightSortedArr.size()){
                ans.add(rightSortedArr.get(j));
                j++;
        }

        return ans;
    }
}
