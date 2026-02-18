package com.scaler.Scaler.BinaryTree;

import java.util.*;

public class CountNoOfPathforGivenSumInBT {

    public List<List<Integer>> sumKWithPath(TreeNode root, int k) {
        List<List<Integer>> pathList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        findPathSum(root, 0, k, map, pathList, new ArrayList<>());
        return pathList;
    }
    void findPathSum(TreeNode root, int sum, int target, HashMap<Integer, Integer> map,
                     List<List<Integer>> pathList, List<Integer> currentPath) {
        if (root == null) {
            return;
        }
        sum += root.val;
        currentPath.add(root.val);
        if (map.containsKey(sum - target)) {
            // Construct the path from hashmap entries
            List<Integer> path = new ArrayList<>();
            for (int i = map.get(sum - target); i < currentPath.size(); i++) {
                path.add(currentPath.get(i));
            }
            pathList.add(path);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        findPathSum(root.left, sum, target, map, pathList, currentPath);
        findPathSum(root.right, sum, target, map, pathList, currentPath);
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
        currentPath.remove(currentPath.size() - 1); // Backtrack
    }


}
