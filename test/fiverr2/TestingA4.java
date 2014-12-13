package fiverr2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestingA4 {

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

    /**
     * Test of getNextNode method, of class AList.
     */
    @Test
    public void testGetNextNodeAList() {

        AList instance = new AList(1, 0, new AList(2, 1, new AList(3, 3, null)));
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
        try {
            instance.getNextNode().getPriority();
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testException2AList() {
        AList instance = new AList(1, 0, null);
        try {
            instance.getNextNode().getHd();
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testException3AList() {
        AList instance = new AList(1, 0, null);
        try {
            instance.getNextNode().getNextNode().getHd();
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPushListChar() {
        System.out.println("push");
        char c = 'a';
        ListChar instance = new ListChar();
        instance.push(c);
        try {
            assertNotNull(instance.top());
        } catch (EmptyContainerException ex) {
            Logger.getLogger(ListCharTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testTopListChar() throws Exception {
        System.out.println("top");
        ListChar instance = new ListChar();
        instance.push('a');
        instance.push('c');
        instance.pop();
        char expResult = 'a';
        char result = 0;
        try {
            result = instance.top();
        } catch (EmptyContainerException ex) {
            Logger.getLogger(ListCharTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class ListChar.
     */
    @Test
    public void testPopListChar() {
        ListChar instance = new ListChar();
        instance.push('a');
        instance.push('s');
        instance.pop();
        try {
            assertEquals(instance.top(), 'a');
        } catch (EmptyContainerException ex) {
            Logger.getLogger(ListCharTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testIsEmptyListChar() {
        System.out.println("isEmpty");
        ListChar instance = new ListChar();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void customtest1ListChar() throws EmptyContainerException {
        ListChar instance = new ListChar();
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.pop();
        instance.pop();
        instance.pop();
        instance.top();
        try {
            assertEquals(instance.top(), 's');
        } catch (EmptyContainerException ex) {
            Logger.getLogger(ListCharTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void customtest2ListChar() throws EmptyContainerException {
        ListChar instance = new ListChar();
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.push('s');
        instance.push('a');
        instance.push('s');
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        assertEquals(instance.isEmpty(), true);
    }

    @Test
    public void testToStringListChar() {
        ListChar instance = new ListChar();
        String expResult = "Stack is empty";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testException1ListChar() {
        ListChar instance = new ListChar();
        try {
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testException2ListChar() {
        ListChar instance = new ListChar();
        try {
            instance.push('a');
            instance.pop();
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testException3ListChar() {
        ListChar instance = new ListChar();
        try {
            instance.push('a');
            instance.pop();
            instance.pop();
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of addListNode method, of class SnocList.
     */
    @Test
    public void testAddListNodeSnocList() {
        char c = 'a';
        SnocList instance = new SnocList(c, null);
        instance.addListNode(c);
        assertEquals(instance.getC(), c);
    }

    /**
     * Test of getC method, of class SnocList.
     */
    @Test
    public void testGetCSnocList() {
        SnocList instance = new SnocList('a', null);
        char expResult = 'a';
        char result = instance.getC();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListNode method, of class SnocList.
     */
    @Test
    public void testSetListNodeSnocList() {
        SnocList l = new SnocList('a', null);
        SnocList instance = new SnocList('a', null);
        instance.setListNode(l);
        assertEquals(instance.getListNode(), l);
    }

    /**
     * Test of getListNode method, of class SnocList.
     */
    @Test
    public void testGetListNodeSnocList() {
        SnocList instance = new SnocList('a', null);
        SnocList expResult = null;
        SnocList result = instance.getListNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeadListNode method, of class SnocList.
     */
    @Test
    public void testGetHeadListNodeSnocList() {
        SnocList instance = new SnocList('a', new SnocList('b', null));
        char expResult = 'b';
        SnocList result = instance.getHeadListNode();
        assertEquals(expResult, result.getC());
    }

    /**
     * Test of getTailListNode method, of class SnocList.
     */
    @Test
    public void testGetTailListNodeSnocList() {
        SnocList instance = new SnocList('a', new SnocList('b', null));
        char expResult = 'b';
        SnocList result = instance.getTailListNode();
        assertEquals(expResult, result.getC());
    }

    @Test
    public void testToStringSnocList() {
        SnocList instance = new SnocList('a', null);
        String expResult = "a";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Tests for Exceptions, of class SnocList.
     */
    @Test
    public void testException1SnocList() {
        SnocList l = new SnocList('a', null);
        SnocList instance = null;

        try {
            instance.setListNode(l);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testException2SnocList() {
        SnocList l = new SnocList('a', null);
        SnocList instance = new SnocList('a', l);

        try {

            instance.getListNode().getListNode().getC();
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testException3SnocList() {
        SnocList instance = null;
        try {
            instance.getListNode().getListNode().getC();
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }
    
    
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
    
    /**
     * Test of top method, of class StackChar.
     */
    @Test
    public void testTopStackChar() throws Exception, EmptyContainerException {
        System.out.println("top");
        StackChar instance = new StackChar();
        instance.push('a');
        char expResult = 'a';
        char result = instance.top();
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class StackChar.
     */
    @Test
    public void testPopStackChar() throws EmptyContainerException {
        StackChar instance = new StackChar();
        instance.push('a');
        instance.push('b');
        instance.push('a');
        instance.push('b');
        instance.push('a');
        instance.push('b');
        instance.push('a');
        instance.push('b');
        instance.push('a');
        instance.push('b');
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();

        assertEquals(instance.top(), 'a');
    }

    /**
     * Test of push method, of class StackChar.
     */
    @Test
    public void testPushStackChar() throws EmptyContainerException {
        StackChar instance = new StackChar();
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.push('v');
        assertEquals(instance.top(), 'v');
    }
    
    public void customtest1StackChar() throws EmptyContainerException {
        StackChar instance = new StackChar();
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.push('u');
        instance.push('s');
        instance.push('t');
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        instance.pop();
        assertEquals(instance.isEmpty(),false);
    }
    

    /**
     * Test of isEmpty method, of class StackChar.
     */
    @Test
    public void testIsEmptyStackChar() {
        StackChar instance = new StackChar();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class StackChar.
     */
    @Test
    public void testEqualsStackChar() {
        Object obj = null;
        StackChar instance = new StackChar();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class StackChar.
     */
    @Test
    public void testToStringStackChar() {
        StackChar instance = new StackChar();
        String expResult = "Stack is empty";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testException1StackChar() {

        StackChar instance = new StackChar();
        try {
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }
    
    @Test
    public void testException2StackChar() {

        StackChar instance = new StackChar();
        try {
            instance.push('a');
            instance.pop();
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }
    
    @Test
    public void testException3StackChar() {

        StackChar instance = new StackChar();
        try {
            instance.push('a');
            instance.push('d');
            instance.push('a');
            instance.push('d');
            instance.pop();
            instance.pop();
            instance.pop();
            instance.pop();
            instance.top();
            assertTrue(false);
        } catch (EmptyContainerException ex) {
            assertTrue(true);
        }

    }

}
