
package fiverr2;

public class test {

    public static void main(String[] args) throws EmptyContainerException{
        StackChar newstack=new StackChar();
        
        System.out.println(newstack.toString());
    
        newstack.push('c');
        newstack.push('d');
//        System.out.println(newstack.top());
        newstack.pop();
       System.out.println(newstack.top());
//        newstack.pop();
//        System.out.println(newstack.isEmpty());
// //       newstack.top();
//        System.out.println(newstack.equals(newstack));
        
//        SnocList newSnocList=new SnocList('c', new SnocList('d', null));
//        newSnocList.addListNode('e');
//        System.out.println(newSnocList.getHeadListNode().getC());
//        newSnocList.printList();
        
//        SnocQueue newSnocQueue = new SnocQueue();
//        SnocQueue newSnocQueue1=new SnocQueue();
//        newSnocQueue.enqueue('w');
//        newSnocQueue.enqueue('x');
//        newSnocQueue.dequeue();
//        newSnocQueue.dequeue();
//        System.out.println(newSnocQueue.isEmpty());
//        System.out.println(newSnocQueue.equals(newSnocQueue1));
        
        AListPQueue pqueue=new AListPQueue();
        pqueue.insertItem(1, 'a');
        pqueue.insertItem(1, 'b');
        pqueue.insertItem(0, 'r');
        pqueue.insertItem(0, 't');
        pqueue.insertItem(3, 'k');
        pqueue.insertItem(3, 'l');
//        System.out.println(pqueue.next());
//        pqueue.deleteItem();
        System.out.println((char)pqueue.list.getHd());
        System.out.println((char)pqueue.list.getNextNode().getHd());
        System.out.println((char)pqueue.list.getNextNode().getNextNode().getHd());
        System.out.println((char)pqueue.list.getNextNode().getNextNode().getNextNode().getHd());
        System.out.println((char)pqueue.list.getNextNode().getNextNode().getNextNode().getNextNode().getHd());
   
        ListChar newListChar=new ListChar();
        newListChar.push('c');
        newListChar.push('d');
       
        
        newListChar.pop();
        newListChar.pop();
       
        System.out.println(newListChar.top());
//        System.out.println(newListChar.list.getLastElement().getData());
    
    }
            
}
