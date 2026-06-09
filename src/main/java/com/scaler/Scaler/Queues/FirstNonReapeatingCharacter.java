package com.scaler.Scaler.Queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//
//Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".
//
//        Here's a scenario:
//
//        A student says "a". It's the first letter. You write "a".
//        Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
//        A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
//        A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
//        A student says "c". "c" is unique. You add "c". The final is "aab#c".
//        Your task? Given the sequence the students call out A, determine the string on the board.
public class FirstNonReapeatingCharacter {

    public static void main(String[] args) {
        solve("abadbc");
    }

    public static String solve(String A) {
        //create a HashMap to keep the Character and it's freq
        HashMap<Character, Integer> map = new HashMap<>();
        //create a Queue to iterate over the Character and create the first non reapting charatcers
        Queue<Character> q = new LinkedList<>();
        //here string is Immutable we can make change in string so we are taking StringBuilder.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            //iterate over the String and add it to Queue & HashMap
            q.add(A.charAt(i));
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
            //if the freq is greater than 1 then it's reapting charatcers so remove from the Queue
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
            //if the Queue is Empty then we can add # to StringBuilder if not then add the front element of the Queue
            if (q.isEmpty()) {
                sb.append('#');
            } else {
                sb.append(q.peek());
            }
        }
        //return to String toString is used to convert the StringBuilder to string
        return sb.toString();
    }
}
