
package fiverr2;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListCharTest {

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

}
