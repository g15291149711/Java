package Solution;
/*
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
*/
//}
/*反转一个单链表。
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL*/
/*public class Solution {
    public ListNode reverseList(ListNode head) {
     *//*  ListNode fir = new ListNode(-1);
       for(ListNode temp = head; temp !=null; temp = temp.next){
           ListNode listNode = new ListNode(temp.val);//头插法
           listNode.next = fir.next;//不能反过来 这个是新的listNode 指向 fir的指向
           fir.next = listNode;
       }
       return fir.next;*//*
     ListNode dummyHead = new ListNode(-1);
     dummyHead.next = head;
     if(head ==null || head.next == null){
           return head;
     }
     ListNode f = dummyHead.next;
     ListNode s = f.next;
     while (s !=null){
         //保存第三节点，以便下次反转使用
         f.next = s.next;
         s.next = dummyHead.next;
         dummyHead.next = s;
         s = f.next;//不能反过来 这是赋值
     }
          return dummyHead;
    }
}*///快慢指针找中间位置，找倒数k节点，找是否带环
//d 1 2 3 4 5    d 2 1 3 4 5  d 3 2 1 4 5 逐次换