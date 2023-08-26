package lib;

public class Pilha <T>{
    private T[] data;
    private int top;
    private int size;

    public Pilha(int size){
        this.size = size;
        data = (T[]) new Object[size];
        top = -1;
    }

    public void push(T item){
        if (isFull()){
            System.out.println("A pilha está cheia!");
        }
        else {
            top ++;
            data[top] = item;
        }
    }

    public T pop(){
        T element;
        if(isEmpty()){
            System.out.println("A pilha está vazia!");
            return null;
        }
        else {
            element = data[top];
            data[top] = null;
            top --;
            return element;
        }
    }
    public boolean isFull(){
        return top == size - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        top = -1;
    }

    @Override
    public String toString() {
        String stack = "[";
        for(int i = 0;i < size; i ++){
            stack += data[i];
            if(i != data.length - 1){
                stack += ",";
            }
        }
        stack += "]";
        return stack;
    }
}
