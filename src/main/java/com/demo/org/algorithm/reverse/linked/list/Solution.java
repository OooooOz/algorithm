package com.demo.org.algorithm.reverse.linked.list;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

//TODO
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = null;
        return head(head, temp);
    }

    private ListNode head(ListNode node, ListNode next) {
        if (next == null) {
            return node;
        }
        ListNode temp = next.next;
        next.next = node;
        return head(next, temp);
    }

    private String getListFromLinkedList(ListNode node) {
        List<Integer> results = Lists.newArrayList();
        while (node != null) {
            results.add(node.val);
            node = node.next;
        }
        return results.toString().replaceAll(" ", "");
    }

    @Test
    public void testReverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(
                "[1,2,3,4,5]",
                getListFromLinkedList(head));
        ListNode result = reverseList(head);
        Assert.assertEquals("[5,4,3,2,1]", getListFromLinkedList(result));
    }
}
