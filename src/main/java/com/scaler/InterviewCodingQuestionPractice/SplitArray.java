package com.scaler.InterviewCodingQuestionPractice;
import java.util.*;

class SplitArray
{
	public static void main(String[] args) {
		int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int splitSize = 3;
		
		/* expected Output 
		[0, 1, 2]
		[3, 4, 5]
		[6, 7, 8]
		[9]
		*/
	
		List<int[]> list = splitArray(original, splitSize);
		list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
	}
	
	public static List<int[]> splitArray(int[] array, int splitSize) {
	    int len = array.length;
	    int i = 0,j =0;
	    List<int[]> ans = new ArrayList<>();
	    while(j < len){
			if(len - j < splitSize){
				splitSize = len - j;
			}
	        int[] chunks = new int[splitSize];
	        while(i<splitSize && j < len){
				chunks[i] = array[j];
	            i++;
	            j++;
	        }
	        ans.add(chunks);
	        i = 0;
	    }
	  return ans;
	}
}


