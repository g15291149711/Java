package Solution;
//链表的回文
class ListNodew {
      int val;
      ListNode next;
      ListNodew(int x) { val = x; }
  }

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        //找到链表中间位置
        ListNode A = head;
        ListNode B = head;
        while (A != null && B != null && A.next != null){
            A = A.next.next;
            B = B.next;
        }
        //反转后一段链表
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = B;
        if(B.val == head.val){
            return true;
        }else {
            if(B.next == null){
                return false;
            }else {
                ListNode f = dummyHead.next;
                ListNode s = f.next;
                while(s != null){
                    f.next = s.next;
                    s.next = dummyHead.next;
                    dummyHead.next = s;
                    s = f.next;//三指针法反转数组
                }
                head = A;
                while(A != null && dummyHead.next != null){
                    if(A.val != dummyHead.val){
                        return false;
                    }
                    A = A.next;
                    dummyHead.next = dummyHead.next.next;
                }
                return true;
            }
        }
    }
}