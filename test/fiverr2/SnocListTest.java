package fiverr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class SnocListTest {

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
        SnocList instance = new SnocList('a',null);
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

}
