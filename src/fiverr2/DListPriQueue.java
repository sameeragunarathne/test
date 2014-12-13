package fiverr2;

public class DListPriQueue {

    private Node first;
    private Node last;

    public DListPriQueue() {
        first = new Node();
        last = new Node();

        first.val = Integer.MAX_VALUE;
        last.val = 0;

        first.prev = null;
        first.next = last;
        last.prev = first;
        last.next = null;

    }
 

    public void insertItem(Node node) {
        if (first.next == last) {
            first.next = node;
            node.prev = first;
            node.next = last;
            last.prev = node;
        } else {
            Node temp = node;
            Node cur = first.next;

            while (cur != last && (temp.val <= cur.val)) {
                cur = cur.next;
            }

            Node tempcur = cur;
            temp.next = tempcur;
            temp.prev = tempcur.prev;
            tempcur.prev.next = temp;

            tempcur.prev = temp;
        }

    }

    public Node deleteItem()throws EmptyContainerException {
        if (first.next == last) {
            throw new EmptyContainerException("Pqueue is empty");
        } else {
            Node temp = new Node();
            temp = first.next;
            first.next = temp.next;
            temp.next.prev = first;
            return temp;
        }
    }

    public String print() {
        Node temp = new Node();
        temp = first.next;
        String result="";

        while (temp != last) {
            System.out.println(temp.val);
            result+=temp.val+",";
            temp = temp.next;
        }
        
        return result;
    }


}

class Node {

    Node next;
    Node prev;
    int val;

    public Node() {

    }

    public Node(int value) {
        val = value;
    }
}
