
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;
        int first = 0;
        int currIdx = 2;
        int prevIdx = 0;
        int maxi = 0 , mini = Integer.MAX_VALUE;

        while(temp.next != null){
            if ((prev.val < temp.val && temp.val > temp.next.val) || (prev.val > temp.val && temp.val < temp.next.val)) {
                if (first == 0) first = currIdx;
                if (prevIdx != 0) mini = Math.min(mini , currIdx - prevIdx );

                prevIdx = currIdx;
            }
            currIdx++;
            prev = temp;
            temp = temp.next;
        }

        if (first != prevIdx) maxi = prevIdx - first;
        else return new int[]{-1,-1};

        return  new int[]{mini,maxi};
    }
}