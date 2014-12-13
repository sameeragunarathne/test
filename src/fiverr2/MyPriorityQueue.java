package fiverr2;

public interface MyPriorityQueue {
  public char next() throws EmptyContainerException; 
  public void deleteItem(); 
  public void insertItem(int p, char c); 
  public boolean isEmpty();
  public String toString(); 
}
