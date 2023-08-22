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

        private void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        public Node(T value){
            data = value;
        }
    }

    Node<T> base;
    Node<T> top;
    int size;

    public void add(T value){
        if (isEmpty()){
            base = new Node<>(value);
            top = new Node<>(value);
        }
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }


}
