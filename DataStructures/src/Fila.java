public class Fila <T>{
    private T[] data;
    private int head = -1;
    private int tail = -1;

    private int size;

    public Fila(int size){
        this.size = size;
        data = (T[]) new Object[size];
    }
    public void add(T item){
        if(isFull()){
            System.out.println("A fila está cheia!");
        }
        else {
            if(head == -1){
                head = 0;
            }
            tail = (tail + 1) % size;
            data[tail] = item;
        }
    }
    public T remove(){
        T element;
        if(isEmpty()){
            System.out.println("A fila está vazia!");
            return null;
        }
        element = data[head];
        data[head] = null;
        if(head == tail){
            head = -1;
            tail = -1;
        }
        else {
            head = (head + 1) % size;
        }
        return element;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        if(head == 0 && tail == size - 1){
            return true;
        }
        return head == tail + 1;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        head = -1;
        tail = -1;
    }

    @Override
    public String toString() {
        String queue = "[";
        for(int i = 0;i < size; i ++){
            queue += data[i];
            if(i != data.length - 1){
                queue += ",";
            }
        }
        queue += "]" + "  Head: " + head + "   Tail:" + tail;
        return queue;
    }
}
