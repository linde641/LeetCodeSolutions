/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aronlindell
 */
public class LengthOfLongestSubstring {

    public int solutionSlow(String s)
    {
        if (s.isEmpty()) {
            return 0;
        }
        
        String sub;
        int longest = 1;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                sub = s.substring(i, j);                
                if (sub.length() <= longest) {
                    continue;
                }
                Map<Character, Integer> map = new HashMap();
                for (char c : sub.toCharArray()) {
                    if (map.containsKey(c)) {
                        int val = map.get(c);
                        val++;
                        map.put(c, val);
                    }
                    else {
                        map.put(c, 1);
                    }
                }
                boolean broken = false;
                for (int val : map.values()) {
                    if (val > 1) {
                        broken = true;
                        break;
                    }
                }
                if (!broken) {
                    if (sub.length() > longest) {
                        longest = sub.length();
                    }
                }
            }
        }
        
        return longest;
    }
    
    
    public int solution(String s)
    {
        if (s.isEmpty()) {
            return 0;
        }
        
        int longest = 1;
        int subLength = 0;
        int start = 0;
        int oldStart = 0;
        
        HashMap<Character, Integer> map = new HashMap(); // maps char to index in string
                
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                subLength++;
            }
            else {                
                if (subLength > longest) {
                    longest = subLength;
                }
                start = map.get(c);
                map.clear();
                for (int k = start + 1; k <= i; k++) {
                    map.put(s.charAt(k), k);
                }
                subLength = i - start;
                //map.clear();
                map.put(c, i);
                oldStart = start;
            }
        }        
        if (subLength > longest) {
            longest = subLength;
        }           
        return longest;
    }
     
}