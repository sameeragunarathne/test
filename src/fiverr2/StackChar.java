package fiverr2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackChar implements MyStack {

    private List<Character> list;
    private int listSize = 0;

    public StackChar() {
        list = new ArrayList<Character>();
    }

    @Override
    public char top() throws EmptyContainerException {
        listSize = list.size();
        if (listSize == 0) {
            throw new EmptyContainerException("stack is empty");
        }
        char topElement = list.get(listSize - 1);
        return topElement;
    }

    @Override
    public void pop() {
        listSize = list.size();
        list.remove(--listSize);
    }

    @Override
    public void push(char c) {
        list.add(new Character(c));
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }

    public String toString() {
        String temp = "Stack is empty";

        if (list.size() != 0) {
            temp = "";

            for (int i = 0; i < list.size(); i++) {
                temp += list.get(i) + "";
            }
        }

        return temp;
    }

}
