package lib;

public class Lista <T>{
    private T[] data;
    int size;
    public Lista(int size){
        this.size = size;
        data = (T[]) new Object[size];
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    public void add(T item){
        if(isFull()){
            System.out.println("A lista está cheia!");
        }
        else {
            int i = 0;
            while (i < data.length){
                if(data[i] == null){
                    data[i] = item;
                    break;
                }
                i++;
            }
        }
    }
    public void add(T item,int pos){
        if(pos >= size || pos < 0){
            return;
        }
        if(isFull()){
            System.out.println("A lista está cheia!");
        }
        T element = data[pos];
        data[pos] = item;
        add(element,pos + 1);
    }

    public void setData(T item,int pos){
        if(data[pos] != null){
            data[pos] = item;
        }
        else {
            System.out.println("A posição está vazia!");
        }
    }

    public T remove(int pos){
        if (isEmpty()){
            System.out.println("A lista está vazia!");
            return null;
        }
        if(pos >= size || pos < 0){
            return null;
        }

        T item = null;
        for(int i = pos;i < size;i ++){
            if(i == pos){
                item = data[i];
                data[i] = null;

            }
            else{
                data[i - 1] = data[i];
                data[i] = null;
            }
        }
        return item;
    }

    public boolean isFull(){
        return data[size-1] != null;
    }

    public boolean isEmpty(){
        return data[0] == null;
    }

    public int getSize(){return size;}

    public T getData(int pos){
        return data[pos];
    }

    int find(T item){
        for (int i = 0;i < size; i ++){
            if(data[i] == item) return i;
        }
        return -1;
    }

    public String toString() {
        String lista = "[";
        for(int i = 0;i < size; i ++){
            lista += data[i];
            if(i != data.length - 1){
                lista += ",";
            }
        }
        lista += "]";
        return lista;
    }




}
