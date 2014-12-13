package fiverr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class AListPQueueTest {

    /**
     * Test of next method, of class AListPQueue.
     */
    @Test
    public void testNextPQueue() throws Exception, EmptyContainerException {
        AListPQueue instance = new AListPQueue();
        char expResult = 'a';
        instance.insertItem(1, 'a');
        char result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteItem method, of class AListPQueue.
     */
    @Test
    public void testDeleteItemPQueue() throws EmptyContainerException {
        AListPQueue instance = new AListPQueue();
        instance.insertItem(1, 'a');
        instance.insertItem(2, 'b');
        instance.insertItem(4, 'a');
        instance.insertItem(3, 'b');
        instance.insertItem(2, 'a');
        instance.insertItem(3, 'a');
        instance.insertItem(4, 'b');
        instance.insertItem(5, 'b');
        instance.insertItem(5, 'c');
        instance.insertItem(5, 'a');
        instance.insertItem(6, 'a');
        instance.insertItem(6, 'b');
        instance.insertItem(6, 'c');
        instance.deleteItem();
        char expResult = 'b';
        char result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertItem method, of class AListPQueue.
     */
    @Test
    public void testInsertItemPqueue() throws EmptyContainerException {
        int p = 0;
        char c = 'b';
        AListPQueue instance = new AListPQueue();
        instance.insertItem(1, 'a');
        instance.insertItem(2, 'b');
        instance.insertItem(3, 'a');
        instance.insertItem(4, 'b');
        instance.insertItem(4, 'a');
        instance.insertItem(5, 'b');
        instance.insertItem(5, 'a');
        instance.insertItem(2, 'b');
        instance.insertItem(5, 'c');
        instance.insertItem(5, 'd');
        instance.insertItem(2, 'e');
        instance.insertItem(6, 'b');
        instance.insertItem(7, 'a');
        instance.insertItem(7, 'b');

        char expResult = 'a';
        char result = instance.next();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class AListPQueue.
     */
    @Test
    public void testIsEmptyPqueue() {
        AListPQueue instance = new AListPQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringPqueue() {
        AListPQueue instance = new AListPQueue();
        String expResult = "Queue is empty";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void customtest1Pqueue() throws EmptyContainerException {
        AListPQueue instance = new AListPQueue();
        instance.insertItem(1, 'a');
        instance.insertItem(2, 'b');
        instance.insertItem(3, 'a');
        instance.insertItem(4, 'b');
        instance.insertItem(4, 'a');
        instance.insertItem(5, 'b');
        instance.insertItem(9, 'a');
        instance.insertItem(9, 'b');
        instance.insertItem(5, 'c');
        instance.insertItem(4, 'd');
        instance.insertItem(2, 'e');
        instance.insertItem(6, 'b');
        instance.insertItem(7, 'a');
        instance.insertItem(7, 'b');

        char expResult = 'a';
        char result = instance.next();

        assertEquals(expResult, result);
    }

    @Test
    public void customtest2Pqueue() throws EmptyContainerException {

        AListPQueue instance = new AListPQueue();
        instance.insertItem(1, 'a');
        instance.insertItem(2, 'b');
        instance.insertItem(3, 'a');
        instance.deleteItem();
        instance.deleteItem();
        instance.insertItem(4, 'b');
        instance.insertItem(4, 'a');
        instance.insertItem(5, 'b');
        instance.insertItem(9, 'a');
        instance.deleteItem();
        instance.deleteItem();
        instance.deleteItem();
        instance.deleteItem();
        instance.deleteItem();
        instance.deleteItem();

        assertEquals(true, instance.isEmpty());
    }

    @Test
    public void testException1Pqueue() {
        AListPQueue instance = new AListPQueue();
        try {
            instance.next();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }

    @Test
    public void testException2Pqueue() {
        AListPQueue instance = new AListPQueue();
        try {
            instance.insertItem(1, 'a');
            instance.deleteItem();
            instance.next();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }

    @Test
    public void testException3Pqueue() {
        AListPQueue instance = new AListPQueue();
        try {
            instance.insertItem(1, 'a');
            instance.insertItem(1, 'b');
            instance.deleteItem();
            instance.deleteItem();
            instance.next();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }

}
