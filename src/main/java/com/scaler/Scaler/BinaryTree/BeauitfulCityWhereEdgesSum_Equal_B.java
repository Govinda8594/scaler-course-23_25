package com.scaler.Scaler.BinaryTree;

import java.util.HashMap;

public class BeauitfulCityWhereEdgesSum_Equal_B {

    static int count;
    static void solution1(TreeNode root, int B) {
        preOrder(root, 0, B);
        solution1(root.left, B);
        solution1(root.right, B);
    }

    static void preOrder(TreeNode root, int sumSoFar, int B) {
        sumSoFar += root.val;
        if (sumSoFar == B) {
            count++;
        }
        preOrder(root.left, sumSoFar, B);
        preOrder(root.right, sumSoFar, B);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        solution1(root,6);
        System.out.println(count);
    }

    ////////////////////////////////////////////////////////////////////////////////
    int B;
    void cityWithbeautifulEdges(TreeNode root, int sumSoFar, HashMap<Integer,Integer> map) {
        if(root == null) return;
        sumSoFar += root.val;
        if(map.containsKey(sumSoFar - B)) {
            count += map.get(sumSoFar - B);
        }
       map.put(sumSoFar,map.getOrDefault(sumSoFar,1) + 1);
        cityWithbeautifulEdges(root.left,sumSoFar,map);
        cityWithbeautifulEdges(root.right,sumSoFar,map);
        map.put(sumSoFar,map.get(sumSoFar) - 1);
    }
}
