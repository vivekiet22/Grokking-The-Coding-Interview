// Problem Statement #
// // Given a string, find the length of the longest substring in it with no more than K distinct characters.
// Input: String="araaci", K=2
// Output: 4
// Explanation: The longest substring with no more than '2' distinct characters is "araa".
package Sliding_Window;

import java.util.*;

class LongestSubstringKDistinct{
    public static int findLength(String str,int k){
        int start = 0;
        // int end = 0;
        int ans = 0;
        Map<Character,Integer> distinctStr = new HashMap<>();

        for (int end=0;end<str.length();end++){
            char right = str.charAt(end);
            distinctStr.put(right,distinctStr.getOrDefault(right,0)+1);
            while(distinctStr.size()>k){
                char left = str.charAt(start);
                distinctStr.put(left,distinctStr.get(left)-1);
                if (distinctStr.get(left) == 0){
                    distinctStr.remove(left);

                }
                start+=1;

            }
            ans = Math.max(ans, end-start+1);
        }

        return ans;
    }
    public static void main(String[] args){
        System.out.println(LongestSubstringKDistinct.findLength("cbbebi",3));

    }
}