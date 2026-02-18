package com.scaler.Scaler.Tries;

import java.util.ArrayList;
import java.util.List;

public class CheckPalindrome {
    // Checks if a given string is a palindrome
    static boolean isPalindrome(String key) {
        int i = 0;
        int j = key.length() - 1;
        while (i <= j) {
            if (key.charAt(i) != key.charAt(j))
                return false; // If characters don't match, it's not a palindrome
            i++;
            j--;
        }
        return true; // If all characters matched, it's a palindrome
    }

    // Searches for valid pairs of words that form a palindrome
    static boolean search(Trie root, String key, int id) {
        Trie current = root; // Start at the root of the trie
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a'; // Calculate the index for the current character
            if (current.children[idx] == null) {
                return false; // If the path doesn't exist, it's not a valid pair
            }
            current = current.children[idx]; // Move to the next node (character)
            if (!current.isEnd.isEmpty() && i != key.length() - 1) {
                // Check if there are words ending at the current node and if we're not at the end of the key
                String remainingKey = key.substring(i + 1);
                if (isPalindrome(remainingKey))
                    return true; // Check if the remaining part of the key is a palindrome
            }
        }
        if (!current.isEnd.isEmpty()) {
            // If we've reached the end of the key, check if there are words ending here
            for (int newId : current.isEnd) {
                if (newId != id)
                    return true; // Check if there's another word ending here (excluding the same word)
            }
        }
        for (int i = 0; i < 26; i++) {
            // Recursively explore all possible characters from the current node
            if (current.children[i] != null && search(current.children[i], "" + (char) ('a' + i), id))
                return true; // If a valid pair is found in the subtree, return true
        }
        return false; // No valid pair found
    }

    // Inserts a word into the trie
    void insert(Trie root, String key, int id) {
        Trie current = root;
        for (int i = key.length() - 1; i >= 0; i--) {
            int idx = key.charAt(i) - 'a'; // Calculate the index for the character
            if (current.children[idx] == null)
                current.children[idx] = new Trie(); // Create a new node if it doesn't exist
            current = current.children[idx]; // Move to the next node
        }
        current.isEnd.add(id); // Mark the end of the word with its index
    }

    // Constructs the trie and checks for valid pairs
    boolean palindromepair(int N, String arr[]) {
        Trie root = new Trie();
        if (N <= 1) return false; // Not enough words to form a pair
        for (int i = 0; i < N; i++) {
            insert(root, arr[i], i); // Insert each word into the trie
        }
        for (int i = 0; i < N; i++) {
            boolean ans = search(root, arr[i], i); // Search for valid pairs for each word
            if (ans) return true; // If a valid pair is found, return true
        }
        return false; // No valid pair found
    }

    class Trie {
        Trie[] children; // Array of child nodes (one for each character)
        List<Integer> isEnd; // List of indices where a word ends

        Trie() {
            children = new Trie[26]; // Initialize an array for 26 possible characters ('a' to 'z')
            isEnd = new ArrayList<>(); // Initialize the list of word endings
        }
    }


}


