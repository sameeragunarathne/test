package fiverr2;

public interface MyQueue {
  public char peek() throws EmptyContainerException; // front 
  public void dequeue(); // front
  public void enqueue(char c); // back
  public boolean isEmpty();
  public String toString(); 
}
