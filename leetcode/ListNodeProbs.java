/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aronlindell
 */

class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { val = x; }
    }    

public class ListNodeProbs<T extends Comparable> {    

    
    private int anyEmpty(ListNode[] lists)
    {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    
    private boolean twoRemain(ListNode[] lists)
    {
        int count = 0;
        for (ListNode list : lists) {
            if (list != null) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
            
        }
        return false;
    }
    
    private int popIthList(int index, ListNode[] lists)
    {
        int value = lists[index].val;
        lists[index] = lists[index].next;
        return value;
    }
    
    private int minimum(ListNode[] lists)
    {
        //int min = lists[0].val;
        int min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
        }
        return index;
    }
    
    public ListNode mergeKLists(ListNode[] lists)
    {                    

        if (lists.length <= 1) {
            return lists[0];
        }
        List<ListNode> merged = new ArrayList();
        
        while (twoRemain(lists)) {
            int min = minimum(lists);
            merged.add(lists[min]);
            popIthList(min, lists);
        }
        
        int lastList;
        for (lastList = 0; lastList < lists.length; lastList++) {
            if (lists[lastList] != null) {
                break;
            }
        }// lastList is the index of the only non exmpty list at this point
        
        // now actually link nodes together since I have to return a ListNode
        ListNode node;
        ListNode next = null;
        for (int i = 0; i < merged.size() - 1; i++) {
            node = merged.get(i);
            next = merged.get(i + 1);
            node.next = next;
        }
        
        next.next = lists[lastList];
        return merged.get(0);
    }
    
    
    public List<T> mergeSort(List<T> list) 
    {        
        if (list.size() <= 1) {
            return list;
        }
        
        int midIndex = list.size() / 2;
        List<T> a = mergeSort(new ArrayList(list.subList(0, midIndex)));
        List<T> b = mergeSort(new ArrayList(list.subList(midIndex, list.size())));
        List<T> merged = merge(a, b);
        return merged;
    }
    
    private List<T> merge(List<T> a, List<T> b)
    {
        List<T> merged = new ArrayList();
        
        while(a.size() > 0 && b.size() > 0) {
            T valA = a.get(0);
            T valB = b.get(0);
            if (valA.compareTo(valB) <= 0) {
                merged.add(valA);
                a.remove(0);
            }
            else {
                merged.add(valB);
                b.remove(0);
            }                        
        }
        if (a.isEmpty()) {
            merged.addAll(b);
        }
        else { // b is empty
            merged.addAll(a);
        }
        
        return merged;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) { // l2 is not null
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        int sum;        
        ListNode newNode;
        ListNode head = null;
        ListNode current = null;
        
        boolean firstIteration = true;        
        while ((l1 != null) || (l2 != null)) {
            
            if (l1 != null && l2 == null) {
                sum = l1.val + carry;
            }
            else if (l2 != null & l1 == null) {
                sum = l2.val + carry;
            }            
            else { // common case
                sum = l1.val + l2.val + carry;
            }
            
            if (sum >= 10) {
                carry = 1;
                newNode = new ListNode(sum - 10);
            }
            else {
                newNode = new ListNode(sum);
                carry = 0;
            }
            
            if (firstIteration) {
                head = newNode;
                current = head;
                firstIteration = false;
            }
            
            else {
                current.next = newNode;
                current = current.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        if (carry == 1) {
            newNode = new ListNode(1);
            current.next = newNode;
        }
        
        return head;
    }    
}
