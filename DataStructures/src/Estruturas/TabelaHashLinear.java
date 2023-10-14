package Estruturas;
import Model.Aluno;
import java.util.Objects;

public class TabelaHashLinear {
    public TabelaHashLinear(int size){
        this.size = size;
        this.data = new Aluno[size];
    }
    private Aluno[] data;
    private int size;
    private int itemCount;

    public int hashFunction(Aluno item){
        if (item.getId() != -1) return item.getId() % getClosestPrime(size);
        int pos = 0;
        for (int i = 0; i < item.getNome().length(); i++) {
            pos += item.getNome().charAt(i) % size;
        }
        return pos % size;
    }
    public void insert(Aluno item){
        itemCount ++;
        int pos = hashFunction(item);
        data[getNextPos(pos % size)] = item;
        if (getLoadFactor() >= 0.7) increaseSize();
    }

    public Aluno search(int key){
        int numIteracoes = 0;
        int pos = hashFunction(new Aluno(key,""));
        if (data[pos] != null && data[pos].getId() == key) {
            System.out.println("Iterações: " + numIteracoes);
            return data[pos];
        }
        for (int i = pos; i < size + pos; i++) {
            numIteracoes ++;
            Aluno obj = data[i % size];
            if(obj != null && obj.getId() == key) {
                System.out.println("Iterações: " + numIteracoes);
                return  obj;}
        }
        System.out.println("Valor não encontrado!");
        return null;
    }
    public Aluno search(String key){
        int numIteracoes = 0;
        int pos = hashFunction(new Aluno(key));
        if (data[pos] != null && Objects.equals(data[pos].getNome(), key)) {
            System.out.println("Iterações: " + numIteracoes);
            return data[pos];
        }
        for (int i = pos; i < size + pos; i++) {
            numIteracoes ++;
            Aluno obj = data[i % size];
            if(obj != null && Objects.equals(obj.getNome(), key)) {
                System.out.println("Iterações: " + numIteracoes);
                return  obj;
            }
        }
        System.out.println("Valor não encontrado!");
        return null;
    }
    public Aluno remove(int key){
        int pos = hashFunction(new Aluno(key,""));
        if (data[pos].getId() == key) {
            System.out.println("Chave:" + key + " e Valor:" + data[pos] + " removidos!");
            data[pos] = null;
            return data[pos];
        }
        for (int i = pos; i < size + pos; i++) {
            Aluno obj = data[i % size];
            if(obj.getId() == key) {
                data[i % size] = null;
                System.out.println("Chave:" + key + " e Valor:" + obj + " removidos!");
                return  obj;
            }
        }
        System.out.println("Valor não encontrado!");
        return null;
    }
    public Aluno remove(String key){
        int pos = hashFunction(new Aluno(key));
        if (Objects.equals(data[pos].getNome(), key)) {
            System.out.println("Chave:" + key + " e Valor:" + data[pos] + " removidos!");
            data[pos] = null;
            return data[pos];
        }
        for (int i = pos; i < size + pos; i++) {
            Aluno obj = data[i % size];
            if(Objects.equals(obj.getNome(), key)) {
                data[i % size] = null;
                System.out.println("Chave:" + key + " e Valor:" + obj + " removidos!");
                return  obj;
            }
        }
        System.out.println("Valor não encontrado!");
        return null;
    }

    public float getLoadFactor(){
        return (float)itemCount / size;
    }
    public int getSize(){
        return this.size;
    }
    private int getClosestPrime(int num){
        if(!isPrime(num)) return getClosestPrime(num - 1);
        return num;
    }
    private boolean isPrime(int num){
        int start = 2;
        while (start < num){
            if (num % start == 0) return false;
            start ++;
        }
        return  true;
    }
    private void increaseSize(){
        Aluno[] newData = new Aluno[size * 2];
        for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
        size *= 2;
        data = newData;
    }
    private int getNextPos(int pos){
        if (data[pos] != null) return getNextPos((pos + 1) % size);
        return pos;
    }

    public String toString(){
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += data[i];
            if (i == size - 1) break;
            str += ",";
        }
        str += "]";
        return str;
    }
}
