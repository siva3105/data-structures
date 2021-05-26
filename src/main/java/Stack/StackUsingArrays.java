package Stack;

public class StackUsingArrays<T> {
    private int numOfItems;
    private T[] stack;

    public StackUsingArrays() {
        this.stack = (T[]) new Object[1];
    }

    public void push(T data) {
        if (size() == this.stack.length) {

            resize(this.stack.length + this.stack.length / 2 + 1); //followed dynamic array
        }
        stack[numOfItems++] = data;

    }

    public T pop() {
        T popedItem = this.stack[--numOfItems];
        //optimal condition to strink
        if (size() >0 && size() == this.stack.length/4){
            resize(this.stack.length/2);
        }
        return popedItem;
    }

    public T peek(){
        return this.stack[numOfItems - 1];
    }

    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    public int size() {
        return this.numOfItems;
    }


    private void resize(int length) {
        T[] newArray = (T[]) new Object[length];

        for (int i = 0; i < numOfItems; i++) {
            newArray[i] = this.stack[i];
        }
        this.stack = newArray;
    }

}
