package fiverr2;

class EmptyContainerException extends Throwable {

    private String kind;

    public EmptyContainerException(String s) {
        this.kind = s;
    }


}
