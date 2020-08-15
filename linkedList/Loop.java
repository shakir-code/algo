package trees;


//1. Run 1x & 2x pointer which will meet at D+K
//2. Move one of the pointers to root node
//3. Move both pointers at 1x speed and they will end up meeting at start of loop as per the derivation
public class Loop {
    public ListNode detectCycleStart(final ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        boolean start=true;
        //below while loop helps detect if there is a loop or not
        while(pointer1!=pointer2||start){
            start=false;
            pointer1 = pointer1.next;
            if(pointer2!=null && pointer2.next!=null) {
                pointer2 = pointer2.next.next;
            } else {
                //scenario where there is no loop
                return null;
            }
        }

        pointer1 = head;

        //this while loop helps with finding the start of the loop
        while(pointer1!=pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int x){
            val=x;
            next =null;
        }
    }
}
