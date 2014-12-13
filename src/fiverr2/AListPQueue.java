package fiverr2;

public class AListPQueue implements MyPriorityQueue {

    private AList list;

//displaying highest priority item
    @Override
    public char next() throws EmptyContainerException {
        if (list == null) {
            throw new EmptyContainerException("Pqueue is empty");
        }

        return (char) list.getHd();
    }

//    deleting highest priority item
    @Override
    public void deleteItem() {
        if (list != null) {
            list = list.getNextNode();
        }
    }

//insert item to the Pqueue
    @Override
    public void insertItem(int p, char c) {
        if (list == null) {
            list = new AList(c, p, null);
        } else {
            AList cur = list;
            AList prev = null;

            while (cur != null && cur.getPriority() > p) {
                prev = cur;
                cur = cur.getNextNode();
            }
            if (cur != null && cur.getPriority() == p) {
                while (cur != null && cur.getHd() < c && cur.getPriority() == p) {
                    prev = cur;
                    cur = cur.getNextNode();
                }

                if (cur == null) {
                    prev.setNextNode(new AList(c, p, null));
                } else if (prev != null) {
                    AList temp = prev.getNextNode();
                    prev.setNextNode(new AList(c, p, temp));
                } else {
                    AList temp = list;
                    list = new AList(c, p, temp);
                }
            } else {
                if (cur == null) {
                    prev.setNextNode(new AList(c, p, null));
                } else if (prev != null) {
                    AList temp = prev.getNextNode();
                    prev.setNextNode(new AList(c, p, temp));
                } else {
                    AList temp = list;
                    list = new AList(c, p, temp);
                }
            }

        }
    }

    //check wheher Queue is empty
    @Override
    public boolean isEmpty() {
        if (list != null) {
            return false;
        }
        return true;
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
            temp="";
            AList cur = list;
            AList prev = null;

            while (cur != null) {
                prev = cur;
                temp+=prev.getHd()+":"+prev.getPriority()+",";
                cur = cur.getNextNode();
            }
        }

        return temp;
    }

}
