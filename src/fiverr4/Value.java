package fiverr4;

enum Mode {

    INTEGER, FLOAT
}

public abstract class Value {

    Mode m;
}

class IntVal extends Value {

    int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class DblVal extends Value {

    double val;

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
