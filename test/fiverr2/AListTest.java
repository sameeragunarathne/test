package fiverr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class AListTest {
    /**
     * Test of getNextNode method, of class AList.
     */
    @Test
    public void testGetNextNodeAList() {
        
        AList instance = new AList(1, 0, new AList(2,1,new AList(3, 3, null)));
        int expResult = 2;
        int result = instance.getNextNode().getHd();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPriority method, of class AList.
     */
    @Test
    public void testGetPriorityAList() {
        AList instance = new AList(1, 0, null);
        int expResult = 0;
        int result = instance.getPriority();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHd method, of class AList.
     */
    @Test
    public void testGetHdAList() {
        AList instance = new AList(1, 0, null);
        int expResult = 1;
        int result = instance.getHd();
        assertEquals(expResult, result);
    }

    /**
     * Test of addNode method, of class AList.
     */
    @Test
    public void testAddNodeAList() {
        AList node = new AList(1, 2, null);
        AList instance = new AList(1, 0, null);
        instance.addNode(node);
        instance.addNode(node);
        node = new AList(1, 4, null);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        
        assertEquals(instance.getNextNode().getNextNode().getNextNode().getPriority(), 4);
    }
    
    @Test
    public void testToStringAList() {
        AList instance = new AList(1, 2, null);
        String expResult = "1 : 2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void customtest1AList() {
        AList node = new AList(1, 2, null);
        AList instance = new AList(1, 0, null);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        instance.addNode(node);
        
        assertEquals(instance.getNextNode().getNextNode().getNextNode().getPriority(), 2);
    }
    
    /**
     * Test of setNextNode method, of class AList.
     */
    @Test
    public void testSetNextNodeAList() {
        AList node = new AList(1, 2, null);
        AList instance = new AList(1, 0, null);
        instance.setNextNode(node);
        assertEquals(instance.getNextNode().getPriority(), 2);
    }
    
    @Test
    public void testException1AList() {
        AList instance = new AList(1, 0, null);
        try{
            instance.getNextNode().getPriority();
            assertTrue(false);
        }catch(NullPointerException e){
            assertTrue(true);
        }
    }
    
    @Test
    public void testException2AList() {
        AList instance = new AList(1, 0, null);
        try{
            instance.getNextNode().getHd();
            assertTrue(false);
        }catch(NullPointerException e){
            assertTrue(true);
        }
    }
    
    @Test
    public void testException3AList() {
        AList instance = new AList(1, 0, null);
        try{
            instance.getNextNode().getNextNode().getHd();
            assertTrue(false);
        }catch(NullPointerException e){
            assertTrue(true);
        }
    }
    
}
