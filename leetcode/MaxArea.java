/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author aronlindell
 */
public class MaxArea {
    
    public int solutionSlow(int[] height)
    {
        int area; // smaller of the two heights * abs(lastList j - lastList i)
        int width;        
        int maxArea = 0;                
        
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > 0; j--) {
                width = Math.abs(j - i);
                if (height[i] <= height[j]) {// i is shorter wall                    
                    area = width * height[i];
                }
                else {
                    area = width * height[j];
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        
        return maxArea;
    }
    
    public int solution(int[] height)
    {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
            
        for (int i = 0; i < height.length; i++) {
            
            
        }
        return 0;
    }
    
 }