package fiverr2;

public class SnocQueue implements MyQueue {

    private SnocList list = null;

    //returns the value of the head of the queue
    @Override
    public char peek() throws EmptyContainerException {
        if (list == null) {
            throw new EmptyContainerException("Queue is empty");
        }

        return list.getHeadListNode().getC();
    }

    //dequeue one element from the queue.
    @Override
    public void dequeue() {
        if (list != null) {
            SnocList newTail = list.getListNode();
            list = null;
            list = newTail;
        }
    }

    // adding an element to the queue
    @Override
    public void enqueue(char c) {
        if (list == null) {
            list = new SnocList(c, null);
        } else {
            list.addListNode(c);
        }

    }

    @Override
    public boolean isEmpty() {
        if (list == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }

    public String toString() {
        String temp = "Queue is empty";
        if (list != null) {

            temp = "";
            SnocList cur = list;
            SnocList prev = null;

            while (cur != null) {
                prev = cur;
                temp += prev.getC() + ",";
                cur = cur.getListNode();
            }

        }
        return temp;
    }

}
