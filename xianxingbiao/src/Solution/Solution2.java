package Solution;
//返回倒数k个节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution2 {
    public ListNode FindKthToTail(ListNode head,int k) {
           if(head != null) {
               ListNode first = head;
               ListNode second = head;
               for (int i = 0; i < k; i++) {
                   if(first != null){
                       first = first.next;
                   }else{
                       return null;
                   }
               }
               while (first != null){
                   first = first.next;
                   second  = second.next;
               }
               return second;
           }
           return null;
    }
}