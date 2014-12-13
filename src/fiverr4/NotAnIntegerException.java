package fiverr4;

public class NotAnIntegerException  extends Throwable {
    private final String kind;
    
    public NotAnIntegerException(String kind){
        this.kind = kind;
    }
}
