package com.scaler.Scaler.Tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PatternMatch {

    class TrieNode4 {
        Map<Character,TrieNode4> map;
        String pattern;
        ArrayList<String> ans;

        TrieNode4(){
            map = new HashMap<>();
            ans = new ArrayList<>();
            pattern = "";
        }
    }

    ArrayList<String> CamelCase(int N, String[] Dictionary, String Pattern){
        //code here
        TrieNode4 root = new TrieNode4();
        for(String word : Dictionary){
            insert(root,word);
        }
        ArrayList<String> ans = new ArrayList<>();
        TrieNode4 curr = root;
        for(char ch : Pattern.toCharArray()){
            if(curr.map.containsKey(ch)){
                curr = curr.map.get(ch);
                if(curr.pattern.equals(Pattern))
                    ans = curr.ans;
            }

        }
        if(ans.isEmpty()){
            ans.add("-1");
        }
        Collections.sort(ans);
        return ans;
    }

    void insert(TrieNode4 root,String word){
        TrieNode4 curr = root;
        String p = "";
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                curr.map.putIfAbsent(ch,new TrieNode4());
                curr = curr.map.get(ch);
                p += ch;
                if(!curr.pattern.equals(p))
                    curr.pattern += p;
                curr.ans.add(word);
            }
        }
    }

    public static void main(String[] args) {
        PatternMatch p = new PatternMatch();
        p.CamelCase(8,new String[] {"Hi", "Hello", "HelloWorld" ,"HiTech", "HiGeek", "HiTechWorld", "HiTechCity" ,"HiTechLab"},"HT");
    }
}
