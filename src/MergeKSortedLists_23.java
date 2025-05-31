import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class MergeKSortedLists_23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        return createListNode(pq);
    }

    public ListNode createListNode(PriorityQueue<Integer> pq) {
        if(pq.isEmpty()) return null;
        return new ListNode(pq.poll(), createListNode(pq));
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        ListNode node2 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(4))));
        ListNode node3 = new ListNode(1, new ListNode(2, new ListNode(6)));
        ListNode[] arr = new ListNode[]{node1, node2, node3};

        ListNode res = new MergeKSortedLists_23().mergeKLists(arr);
        printList(res);
    }
}

