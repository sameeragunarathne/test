package fiverr2;

public class SnocList {

    private char c;
    private Object o;
    private SnocList l;

    public SnocList(char c, SnocList l) {
        this.c = c;
        this.l = l;
    }
    
    public SnocList(Object o, SnocList l) {
        this.o = o;
        this.l = l;
    }


    public void addListNode(Object o) {
        SnocList l1 = new SnocList(o, null);
        SnocList curListNode = this;
        SnocList prevListNode = null;

        while (curListNode != null) {
            prevListNode = curListNode;
            curListNode = curListNode.getListNode();
        };
        prevListNode.setListNode(l1);
    }

    public char getC() {
        return c;
    }
    
    public Object getObject(){
        return o;
    }
          

    public void setListNode(SnocList l){
        this.l=l;
    }
    
    public SnocList getListNode() {
        return l;
    }

    public SnocList getHeadListNode(){
        SnocList curListNode = this;
        SnocList prevListNode = null;

        while (curListNode != null) {
            prevListNode = curListNode;
            curListNode = curListNode.getListNode();
        };
        return prevListNode;
    }
    
    public SnocList getTailListNode(){
        return l;
    }
    
    public void printList(){
        String result="";
        SnocList curListNode = this;
        SnocList prevListNode = null;

        while (curListNode != null) {
            prevListNode = curListNode;
            result+=curListNode.getC();
            curListNode = curListNode.getListNode();
        };
        
        char[] result2=result.toCharArray();
        
        for (int i = result2.length-1; i>=0; i--) {
            System.out.print(result2[i]+",");
        }
    }
    
      public String toString(){
         
        return this.getC()+"";
    }


}
