package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MorrisTreeTraversal {

    public static void main1(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        getTreeTraversal(tree);
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        inorder = inOrderTraversal(root, inorder);
        preorder = preOrderTraversal(root, preorder);
        postorder = postOrderTraversal(root, postorder);
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;
    }

    static List<Integer> inOrderTraversal(TreeNode root, List<Integer> inorder) {
        TreeNode current = root;
        while (current != null) {
            // case 1: left child of current node is null ,so we move to right child.
            if (current.left == null) {
                inorder.add(current.val);
                current = current.right;
            } else {
                // case 2: left child of current node is not null.
                // create a pointerNode before moving to left node and move to right node
                TreeNode pointerNode = current.left;
                while (pointerNode.right != null && pointerNode.right != current) {
                    pointerNode = pointerNode.right;
                }
                //case 1: create back reference to current node and move to left node
                if (pointerNode.right == null) {
                    pointerNode.right = current;
                    current = current.left;
                } else {
                    // case 2:remove back reference to current node and move to right node
                    pointerNode.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorder;
    }

    static List<Integer> preOrderTraversal(TreeNode root, List<Integer> preorder) {
        TreeNode current = root;
        while (current != null) {
            // case 1: left child of current node is null ,so we move to right child.
            if (current.left == null) {
                preorder.add(current.val);
                current = current.right;
            } else {
                // case 2: left child of current node is not null.
                // create a pointerNode before moving to left node and move to right node
                TreeNode pointerNode = current.left;
                while (pointerNode.right != null && pointerNode.right != current) {
                    pointerNode = pointerNode.right;
                }
                //case 1: create back reference to current node and move to left node
                if (pointerNode.right == null) {
                    pointerNode.right = current;
                    preorder.add(current.val);
                    current = current.left;
                } else {
                    // case 2:remove back reference to current node and move to right node
                    pointerNode.right = null;
                    current = current.right;
                }
            }
        }
        return preorder;
    }

    static List<Integer> postOrderTraversal(TreeNode root, List<Integer> postorder) {
        TreeNode current = root;
        while (current != null) {
            // case 1:  right child of current node is null ,so we move to left child.
            if (current.right == null) {
                postorder.add(current.val);
                current = current.left;
            } else {
                // case 2: right child of current node is not null.
                // create a pointerNode before moving to right node and move to left node
                TreeNode pointerNode = current.right;
                while (pointerNode.left != null && pointerNode.left != current) {
                    pointerNode = pointerNode.left;
                }
                //case 1: create back reference to current node and move to right node
                if (pointerNode.left == null) {
                    postorder.add(current.val);
                    pointerNode.left = current;
                    current = current.right;
                } else {
                    // case 2:remove back reference to current node and move to left node
                    pointerNode.left = null;
                    current = current.left;
                }
            }
        }
        Collections.reverse(postorder);
        return postorder;
    }
    //    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        TreeNode current = root;
//        if (root == null) return null;
//        while (current != null) {
//            if (current.left == null) {
//                // add the current node(L Node)
//                temp.add(current.val);
//                current = current.right;
//            } else {
//                TreeNode ptr = current.left;
//                while (ptr.right != null && ptr.right != current) {
//                    ptr = ptr.right;
//                }
//                if (ptr.right == null) {
//                    ptr.right = current;
//                    current = current.left;
//                } else {
//                    // if(ptr.right == current)
//                    ptr.right = null;
//                    // add the root node
//                    temp.add(current.val);
//                    current = current.right;
//                }
//            }
//        }
//        System.out.println(temp.toString());
//        return temp;
//    }
//
//    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        TreeNode current = root;
//        if (root == null) return null;
//        while (current != null) {
//            if (current.left == null) {
//                // add the root node
//                temp.add(current.val);
//                current = current.right;
//            } else {
//                TreeNode ptr = current.left;
//                while (ptr.right != null && ptr.right != current) {
//                    ptr = ptr.right;
//                }
//                if (ptr.right == null) {
//                    // add the Left node
//                    temp.add(current.val);
//                    ptr.right = current;
//                    current = current.left;
//                } else {
//                    // if(ptr.right == current)
//                    ptr.right = null;
//                    current = current.right;
//                }
//            }
//        }
//        System.out.println(temp.toString());
//        return temp;
//    }
//
//    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        TreeNode current = root;
//        if (root == null) return null;
//        while (current != null) {
//            if (current.right == null) {
//                // add the root node
//                temp.add(current.val);
//                current = current.left;
//            } else {
//                TreeNode ptr = current.right;
//                while (ptr.left != null && ptr.left != current) {
//                    ptr = ptr.left;
//                }
//                if (ptr.left == null) {
//                    temp.add(current.val);
//                    ptr.left = current;
//                    current = current.right;
//                } else {
//                    // if(ptr.right == current)
//                    ptr.left = null;
//                    current = current.left;
//                }
//            }
//        }
//        Collections.reverse(temp);
//        System.out.println(temp.toString());
//        return temp;
//    }
    void printPostOrder(int in[], int pre[], int n) {
        int[] index = {0}; // Use an array to store the index
        solve(in, pre, n, index, 0, n - 1);
    }

    void solve(int in[], int pre[], int n, int[] index, int start, int end) {
        if (index[0] >= n || start > end) {
            return;
        }
        int ele = pre[index[0]];
        int posi = start;
        while (in[posi] != ele) {
            posi++;
        }
        index[0]++;
        solve(in, pre, n, index, start, posi - 1);
        solve(in, pre, n, index, posi + 1, end);
        System.out.print(in[posi] + " ");
    }

    public static void main(String[] args) {
        MorrisTreeTraversal t = new MorrisTreeTraversal();
        t.printPostOrder(new int[]{10, 1, 30, 40, 20}, new int[]{1, 10, 20, 30, 40}, 5);
    }


}











