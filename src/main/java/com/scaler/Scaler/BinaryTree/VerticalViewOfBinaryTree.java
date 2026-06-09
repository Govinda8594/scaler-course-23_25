package com.scaler.Scaler.BinaryTree;


import java.util.*;

public class VerticalViewOfBinaryTree {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int max = 0;
        int min = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int c = pair.level;
            max = Math.max(c, max);
            min = Math.min(c, min);
            if (node.left != null) {
                queue.offer(new Pair(node.left, c - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, c + 1));
            }
            //map.computeIfAbsent(c, k -> new ArrayList<>()).add(node.val);
            if (map.containsKey(c)) {
                ArrayList<Integer> list = map.get(c);
                list.add(node.val);
                map.put(c, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(c, list);
            }
        }
        ArrayList<ArrayList<Integer>> verticalView = new ArrayList<>();
        /// vertical view
        for (int i = min; i <= max; i++) {
            verticalView.add(map.get(i));
        }
        /// top view
        ArrayList<Integer> topview = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            topview.add(map.get(i).get(0));
        }
        /// bottom view
        ArrayList<Integer> bottomview = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> list = map.get(i);
            bottomview.add(list.size() - 1);
        }
        return verticalView;
    }

    public int[][] verticalOrderTraversal3(TreeNode A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(A, 0));
        int max = 0, min = 0;

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            max = Math.max(max, level);
            min = Math.min(min, level);
            map.computeIfAbsent(level, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                que.add(new Pair(node.left, level - 1));
            }
            if (node.right != null) {
                que.add(new Pair(node.right, level + 1));
            }
        }

        // collect results in order
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arr.add(map.getOrDefault(i, new ArrayList<>()));
        }

        // convert to int[][]
        int[][] ans = new int[arr.size()][];
        int idx = 0;
        for (List<Integer> col : arr) {
            ans[idx++] = col.stream().mapToInt(Integer::intValue).toArray();
        }
        return ans;
    }

    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode n, int lvl) {
            node = n;
            level = lvl;
        }
    }


}
