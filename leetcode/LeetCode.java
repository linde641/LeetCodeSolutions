/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aronlindell
 */
public class LeetCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListProbTester listTest = new ListProbTester();
        listTest.addTwoNumbers();
        
        
        /*LengthOfLongestSubstring longSub = new LengthOfLongestSubstring();
        int longest = longSub.solution("abcdcbd");
        System.out.println("Longest: " + longest);
        */
        //ListNodeProbs listTester = new ListNodeProbs();        

        //List<Integer> list = new LinkedList(Arrays.asList(array));
        /*List<Integer> list = new LinkedList();
        list.add(13);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(12);
        list.add(9);
        List<Integer> sorted = listTester.mergeSort(list);
        System.out.println("Sorted: " + sorted.toString());
        
        
        ListNode node1 = new ListNode(0);
        ListNode curr = node1;
        
        for (int i = 1; i < 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        
        ListNode node2 = new ListNode(0);
        curr = node2;
        
        for (int i = 1; i < 10; i++) {
            curr.next = new ListNode(2*i);
            curr = curr.next;
        }
        
        ListNode node3 = new ListNode(0);
        curr = node3;
        
        for (int i = 1; i < 10; i++) {
            curr.next = new ListNode(3*i);
            curr = curr.next;
        }
        
        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        
        ListNode merged = listTester.mergeKLists(lists);
        while(merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
        */
    }
     
                
}

class ListProbTester {
    
    public ListNodeProbs tester = new ListNodeProbs();
    
    public void addTwoNumbers()
    {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(4);
        
        ListNode node = tester.addTwoNumbers(l1, l2);
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}