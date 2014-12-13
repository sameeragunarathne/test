package fiverr2;

import static org.junit.Assert.*;
import org.junit.Test;

public class DListPriQueueTest {

    /**
     * Test of insertItem method, of class DListPriQueue.
     */
    @Test
    public void testInsertItem() {
        Node node = new Node(100);
        Node node2 = new Node(101);
        DListPriQueue instance = new DListPriQueue();
        instance.insertItem(node);
        instance.insertItem(node2);
        String resultString=instance.print();
        String expResult="101,100,";
        
        assertEquals(expResult, resultString);
    }

    /**
     * Test of deleteItem method, of class DListPriQueue.
     */
    @Test
    public void testDeleteItem() throws Exception, EmptyContainerException {
        DListPriQueue instance = new DListPriQueue();
        instance.insertItem(new Node(1));
        instance.insertItem(new Node(3));
        instance.insertItem(new Node(100));
        instance.deleteItem();
        instance.insertItem(new Node(50));
        String expResult = "50,3,1,";
        String result = instance.print();
        assertEquals(expResult, result);
    }

    /**
     * Test of print method, of class DListPriQueue.
     */
    @Test
    public void testPrint() {
        DListPriQueue instance = new DListPriQueue();
        instance.insertItem(new Node(1));
        instance.insertItem(new Node(3));
        instance.insertItem(new Node(100));
        instance.insertItem(new Node(50));
        instance.insertItem(new Node(0));
        instance.insertItem(new Node(30));
        instance.insertItem(new Node(12));
        instance.insertItem(new Node(53));
        String expResult = "100,53,50,30,12,3,1,0,";
        String result=instance.print();
        assertEquals(expResult, result);
    }
    
}
