package fiverr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackCharTest {

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
