package com.scaler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TempJava {

    public static void main(String[] args) throws IOException {
        byte x = 64;
        int i;
        byte y;
        i = x << 2;
        y = (byte) (x << 2);
        System.out.println(i + "" + y);

        Dog dog = new GoldenRetirver();
        dog.makenosie();

        Parent p = new Parent();
        p.print(5);
        p = new Child();
//        p.print(2.3f);
    }
}

abstract class Animal {
    abstract void makenosie();
}

class Dog extends Animal {

    @Override
    void makenosie() {
        System.out.println("Make dog noise,,,,");
    }
}

class GoldenRetirver extends Dog {
    void makenosie() {
        super.makenosie();
        System.out.println("Make retiver noise......");
    }
}

class Parent {
    void print(String text) {
        System.out.println("String " + text);
    }

    void print(int number) {
        System.out.println("Integer " + number);
    }
}

class Child extends Parent {
    int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    void print(int number) {
        System.out.println("I m child " + number);
    }

    void print(float number) {
        System.out.println("float " + number);
    }

    public String[] wordBoggle(char[][] board, String[] dictionary) {
        Node root = new Node();
        for (String word : dictionary) {
            insert(root, word);
        }
        ArrayList<String> words = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, root, i, j, words);
            }
        }

        return words.toArray(new String[words.size()]);
    }

    void dfs(char[][] board, Node curr, int i, int j, ArrayList<String> words) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$' || !curr.map.containsKey(board[i][j]))
            return;

        char ch = board[i][j];
        curr = curr.map.get(ch);

        if (curr.isEnd) {
            words.add(curr.word);
            curr.isEnd = false;
        }
        board[i][j] = '$'; // Mark as visited
        for (int k = 0; k < 8; k++) {
            int m = i + dx[k];
            int n = j + dy[k];
            dfs(board, curr, m, n, words);
        }
        board[i][j] = ch;
    }

    void insert(Node root, String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            curr.map.putIfAbsent(ch, new Node());
            curr = curr.map.get(ch);
        }
        curr.isEnd = true;
        curr.word = word; // Store only the word itself, not the entire path
    }

    class Node {
        Map<Character, Node> map;
        boolean isEnd;
        String word;

        Node() {
            map = new HashMap<>();
            isEnd = false;
            word = "";
        }
    }
}