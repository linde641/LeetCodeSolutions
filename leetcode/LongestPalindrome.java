/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aronlindell
 */
public class LongestPalindrome {
    
    public boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
    
    public boolean isPalindromeScratch(String s)
    {        
        int length = s.length();
        for (int i = s.length(); i > 0; i--) {
            if (s.charAt(i - 1) != s.charAt(length - i)) {
                return false;
            }
        }        
        return true;
    }    

    private boolean permuteChars(StringBuilder sb, StringBuilder s, int start,  int permLength, List<String> perms)
    {        
        if (start > permLength) {
            System.out.println("ERROR: start > permLength");
            return false;
        }              
        if (start == permLength) {              
            if (isPalindrome(sb.toString())) {
                perms.add(sb.toString());
                return true;
            }
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i < start) {
                continue;
            }
            sb.setCharAt(start, s.charAt(i));            
            char temp = s.charAt(i);
            s.delete(i, i + 1);
            s.insert(start, temp);                        
            if (permuteChars(sb, s, start + 1, permLength, perms) ) {
                return true; // collapse call tree and immediately return true because we only care whether or not one exists 
            }
        }
        return false;
    }

    public int longestPalindromeSlow(String s)
    {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
                        
        StringBuilder sb;        
        List<String> perms = new LinkedList();
        
        for (int i = length; i > 1; i--) {
            // find all the permutations of length i and pass them to isPalindrome()
            sb = new StringBuilder(i);
            sb.setLength(i);
            if (permuteChars(sb, new StringBuilder(s), 0, i, perms) ) {
                return i;
            }
        }
        return 1;
    }   

    public int longestPalindrome(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        int total = 0;
        int oddExists = 0;
        for (int value : map.values()) {
            if ((value & 0x01) == 0) {
                total += value;
            }
            else {
                oddExists = 1;
                total += value - 1;
            }
        }
                
        return total + oddExists;
    }    
    
}
