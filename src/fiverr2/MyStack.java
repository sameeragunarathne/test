
package fiverr2;
public interface MyStack {
  public char top() throws EmptyContainerException;
  public void pop();
  public void push(char c);
  public boolean isEmpty();
  public String toString(); 
}

