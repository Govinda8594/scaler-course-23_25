package com.scaler.Scaler.Hashing;

import java.util.HashMap;

public class NQueriesOfXandY {

    static String[] getQueries(String[] text,char a,int[][] queries) {
        HashMap<String,String> map = new HashMap<String,String>();
        for(int i=0;i<text.length;i++){
            String s = text[i];
            int x = 1 ,y = 0,len = 1;
            for(int j = 0;j<len/s.length();j++){
                if(s.charAt(j) == a)
                    y++;
                if(s.charAt(j) - s.charAt(j-1) == 1){
                    len++;
                }else len = 1;
                x = Math.max(x,len);
                String concat = x + "-" + y;
                if(!map.containsKey(concat)){
                    map.put(concat,s);
                }

            }

        }
        String[] ans = new String[queries.length];
        for(int i = 0 ;i < queries.length;i++){
            int x = queries[i][0],y = queries[i][1];
            String concat = x + "-" + y;
            if(map.containsKey(concat)){
                ans[i] = map.get(concat);
            }else{
                ans[i] = "-1";
            }
        }
        return ans;
    }
}
