package Estruturas;

public class ListaDuplamenteEncadeada <T> {

    public ListaDuplamenteEncadeada(){
        base = null;
        top = null;
        size = 0;
    }
    private static class Node<T>{
        Node<T> previous;
        T data;
        Node<T> next;

        private Node<T> getPrevious() {
            return previous;
        }

        private void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
        public Node(T value,Node<T> previous,Node<T> next){
            data = value;
            this.previous = previous;
            this.next = next;
        }
    }

    Node<T> base;
    Node<T> top;

    public int getSize() {
        return size;
    }

    private int size;

    public void add(T value){
        if (isEmpty()){
            Node<T> newNode = new Node<>(value,null,null);
            base = newNode;
            top = newNode;
        }
        else {
            Node<T> newNode = new Node<>(value,top,null);
            top.setNext(newNode);
            top = newNode;
        }
        size++;
    }
    public void add(T value,int pos){
        if(pos <= size){
            Node<T> newNode;
            if(pos == size){
                newNode = new Node<>(value,top,null);
                top.setNext(newNode);
                top = newNode;
            }
            else{
                Node<T> next = getNode(pos);
                Node<T> previous = getNode(pos - 1);
                newNode = new Node<>(value,previous,next);
                if(previous == null){
                    base = newNode;
                }
                else {
                    previous.setNext(newNode);
                }
                next.setPrevious(newNode);
            }
            size++;
        }

    }
    public T remove(int pos){
        if (size == 0) return null;
        Node<T> node = null;
        if(pos <= size && pos >= 0){
            node = getNode(pos);
            remove(node);
            size--;
        }
        if (node.data != null) return node.data;
        return null;
    }
    private void remove(Node<T> node){
        Node<T> previous = node.getPrevious();
        Node<T> next = node.getNext();
        if(previous == null){
            base = next;
            if(next != null && next.getPrevious() != null) next.setPrevious(null);
            return;
        }
        if(next == null){
            top = previous;
            if(previous != null && previous.getNext() != null) previous.setNext(null);
            return;
        }
        previous.setNext(next);
        next.setPrevious(previous);
    }
    public Node<T> getNode(int pos){
        if(pos >= size || pos < 0) return null;
        int half = size/2;
        Node<T> item;
        if(pos < half){
            item = base;
            for(int i = 0;i < pos; i ++){
                Node<T> next = item.getNext();
                item = next;
            }
        }
        else {
            item = top;
            for(int i = size - 1;i > pos; i --){
                Node<T> next = item.getPrevious();
                item = next;
            }
        }
        return item;
    }
    public void clear(){
        base = null;
        top = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T get(int pos){
        return getNode(pos).getData();
    }
    public void set(T value,int pos){
        getNode(pos).setData(value);
    }
    public String toString() {
        String lista = "[";
        if(size > 0){
            int i = 0;
            Node<T> item = base;
            while (true){
                lista += item.getData();
                if(i == size - 1){
                    break;
                }
                lista += " -> ";
                item = item.getNext();
                i++;
            }
        }
        lista += "]";
        return lista;
    }

}
