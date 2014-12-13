package fiverr2;

public class ListChar implements MyStack {

   private LinkedList list;

   //returns value of the top element of stack
    @Override
    public char top() throws EmptyContainerException {
        if (list == null) {
            throw new EmptyContainerException("Stack is empty");
        }

        LinkedList cur = list;
        return cur.getData();

    }

    //pop one element from stack
    @Override
    public void pop() {
        if (list != null) {
            if (list.getNextNode() != null) {
                this.list = this.list.getNextNode();
            } else {
                this.list = null;
            }
        }

    }

    // pushing an element to top of the stack
    @Override
    public void push(char c) {
        if (list == null) {
            list = new LinkedList(c, null);
        } else {
            LinkedList temp = new LinkedList(c, null);
            temp.setNextNode(list);
            list = temp;
        }
    }

    //checking whether the stack is empty
    @Override
    public boolean isEmpty() {
        if (list == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj){       
           if(this==obj){
               return true;
           }    
        return false;
    }
    
    public String toString(){
        String temp="Stack is empty";
        
        if(list!=null){
            temp="";
            LinkedList cur = list;
            LinkedList prev = null;

            while (cur != null) {
                prev = cur;
                temp+=prev.getData()+",";
                cur = cur.getNextNode();
            }
        }        
        return temp;
    }

}


// linked list class for stack implementation
class LinkedList {

    private char data;
    private LinkedList nextNode;

    public LinkedList(char data, LinkedList nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public void setNextNode(LinkedList list) {
        this.nextNode = list;
    }

    public void setData(char data) {
        this.data = data;
    }

    public LinkedList getNextNode() {
        return this.nextNode;
    }

    public char getData() {
        return this.data;
    }

    public LinkedList getLastElement() {
        LinkedList cur = this;
        LinkedList prev = null;
        while (cur != null) {
            prev = cur;
            cur = cur.getNextNode();
        }

        return prev;
    }

 

}
