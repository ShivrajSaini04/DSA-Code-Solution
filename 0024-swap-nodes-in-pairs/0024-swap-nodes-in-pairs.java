
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode fir = head;
        ListNode sec = head.next;
        while (prev.next != null && prev.next.next != null ){
             fir.next = sec.next;
             sec.next = fir;
             prev.next = sec;
             prev = fir;
              fir = fir.next;
             sec = (fir != null) ? fir.next : null ;
        }
        return dummy.next;
    }
}