package com.luo.test1;

/**
 * @author luozstart
 * @create 2022-11-16 13:17
 */
public class Test3 {
    public static void main(String[] args) {
        ListNode l1 ;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode x = l1;
        int a=0;    //进位
        for(;;){
            if(l1.next ==null||l2.next==null){
                l1.val = l1.val+l2.val+a;
                if (l1.next ==null){
                    l1.next = l2.next;
                }
                a =0;
                for(;;) {
                    if (l1.next==null){
                        if ((l1.val +a)>= 10) {
                            l1.val = (l1.val+a)%10;
                            ListNode l  = new ListNode();
                            l.val = 1;
                            l1.next=l;
                        }
                        else l1.val = l1.val+a;
                        break;
                    }
                    if ((l1.val +a)>= 10) {
                        l1.val = (l1.val+a)%10;
                        a = 1;
                        l1 = l1.next;
                    }else {
                        l1.val = l1.val+a;
                        break;
                    }
                }
                return x;
            }
            if((l1.val + l2.val)>=10) {
                l1.val = (l1.val + l2.val+a)%10;
                l1 = l1.next;
                l2 = l2.next;
                a=1;
            }else {
                if((l1.val + l2.val+a)>=10) {
                    l1.val = (l1.val + l2.val+a)%10;
                    l1 = l1.next;
                    l2 = l2.next;
                    a=1;
                }
                else{
                    l1.val = l1.val + l2.val+a;
                    l1 = l1.next;
                    l2 = l2.next;
                    a=0;
                }
            }

        }
    }
}