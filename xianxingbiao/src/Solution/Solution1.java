package Solution;
//返回中间节点

public class Solution1 {
    public ListNode middleNode(ListNode head) {
          if(head != null) {
              ListNode first = head;
              ListNode second = head;

              while (first != null && second != null && second.next != null) {
                  first = first.next;
                  second = second.next.next;
              }
              return first;
          }
          return null;
    }
}
//快慢指针 second 1 3 5  first 1 2 3     1 2 3 4 5      n/2 + 1