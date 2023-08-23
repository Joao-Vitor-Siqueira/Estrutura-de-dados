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
    int size;

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
    public Node<T> getNode(int pos){
        if(pos >= size || pos < 1) return null;
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

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString() {
        String lista = "[";
        int i = 0;
        Node<T> item = base;
        while (true){
           lista += item.getData();
           if(i == size - 1){
               break;
           }
           lista += ",";
           item = item.getNext();
           i++;
        }
        lista += "]";
        return lista;
    }

}
