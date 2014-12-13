package fiverr2;

public class AList {
    private int hd;
    private int priority;
    private AList t1;

    
    //constructor for Alist
    public AList(final int hd,final int priority,final AList t1) {
        this.hd = hd;
        this.priority = priority;
        this.t1 = t1;
    }
    
    
    public AList getNextNode(){
        return t1;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public int getHd(){
        return hd;
    }

    //adding a node to the list
    public void addNode(AList node){
        AList curListNode=this;
        AList prevListNode=null;
        
        while(curListNode!=null){
            prevListNode=curListNode;
            curListNode=curListNode.getNextNode();
        }
        prevListNode.t1=node;
    }
    
    public void setNextNode(AList node){
        this.t1=node;
    }
    
    @Override
    public boolean equals(Object obj){       
           if(this==obj){
               return true;
           }    
        return false;
    }
    
    public String toString(){
        String temp=this.getHd()+" : "+this.getPriority();
        return temp;
    }
    
}
