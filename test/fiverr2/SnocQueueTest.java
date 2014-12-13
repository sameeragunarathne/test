package fiverr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class SnocQueueTest {

    /**
     * Test of peek method, of class SnocQueue.
     */
    @Test
    public void testPeekSnocQueue() throws Exception, EmptyContainerException {
        SnocQueue instance = new SnocQueue();
        instance.enqueue('a');
        char expResult = 'a';
        char result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of dequeue method, of class SnocQueue.
     */
    @Test
    public void testDequeueSnocQueue() throws EmptyContainerException {
        SnocQueue instance = new SnocQueue();
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();

        assertEquals(instance.peek(), 'c');
    }

    /**
     * Test of enqueue method, of class SnocQueue.
     */
    @Test
    public void testEnqueueSnocQueue() throws EmptyContainerException {
        SnocQueue instance = new SnocQueue();
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('d');

        assertEquals(instance.peek(), 'd');
    }

    /**
     * Test of toString method, of class StackChar.
     */
    @Test
    public void testToStringSnocQueue() {
        SnocQueue instance = new SnocQueue();
        String expResult = "Queue is empty";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    public void customTest1SnocQueue() {

        SnocQueue instance = new SnocQueue();
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.enqueue('c');
        instance.dequeue();

        assertEquals(instance.isEmpty(), true);
    }

    public void customTest2SnocQueue() throws EmptyContainerException {

        SnocQueue instance = new SnocQueue();
        instance.enqueue('c');
        instance.enqueue('a');
        instance.enqueue('b');
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.enqueue('c');
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        instance.enqueue('c');
        instance.dequeue();

        assertEquals(instance.peek(), 'c');
    }

    /**
     * Test of isEmpty method, of class SnocQueue.
     */
    @Test
    public void testIsEmptySnocQueue() {
        SnocQueue instance = new SnocQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class SnocQueue.
     */
    @Test
    public void testEqualsSnocQueue() {
        Object obj = new Object();
        SnocQueue instance = new SnocQueue();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testException1SnocQueue() {
        SnocQueue instance = new SnocQueue();
        try {
            instance.peek();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testException2SnocQueue() {
        SnocQueue instance = new SnocQueue();
        try {
            instance.enqueue('a');
            instance.enqueue('b');
            instance.enqueue('c');
            instance.dequeue();
            instance.dequeue();
            instance.dequeue();
            instance.peek();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testException3SnocQueue() {
        SnocQueue instance = new SnocQueue();
        try {
            instance.enqueue('a');
            instance.enqueue('b');
            instance.enqueue('c');
            instance.dequeue();
            instance.dequeue();
            instance.dequeue();
            instance.dequeue();
            instance.dequeue();
            instance.peek();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }
}
