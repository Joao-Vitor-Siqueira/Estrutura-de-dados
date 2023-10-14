package Estruturas;
import Model.Aluno;
import java.util.Objects;


public class TabelaHashEncadeada{
    public TabelaHashEncadeada(int size){
        this.size = size;
        this.data = new ListaDuplamenteEncadeada[size];
        for (int i = 0; i < size; i++) {
            data[i] = new ListaDuplamenteEncadeada<Aluno>();
        }
    }
    private ListaDuplamenteEncadeada[] data;
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
        data[pos].add(item);
        if (getLoadFactor() >= 0.7) increaseSize();
    }

    public Aluno search(int key){
        int numIteracoes = 0;
        int pos = hashFunction(new Aluno(key,""));
        for (int i = 0; i < data[pos].getSize(); i++) {
            numIteracoes ++;
            Aluno obj = (Aluno) data[pos].get(i);
            if(obj.getId() == key) {
                System.out.println("Iterações: " + numIteracoes);
                return  obj;
            }
        }
        System.out.println("Valor não encontrado!");
        return null;
    }
    public Aluno search(String key){
        int numIteracoes = 0;
        int pos = hashFunction(new Aluno(key));
        for (int i = 0; i < data[pos].getSize(); i++) {
            numIteracoes ++;
            Aluno obj = (Aluno) data[pos].get(i);
            if(Objects.equals(obj.getNome(), key)) {
                System.out.println("Iterações: " + numIteracoes);
                return  obj;
            }
        }
        return null;
    }
    public Aluno remove(int key){
        int pos = hashFunction(new Aluno(key,""));
        if (data[pos].isEmpty()) return null;
        Aluno obj = search(key);
        data[pos].remove(0);
        System.out.println("Chave:" + key + " e Valor:" + obj + " removidos!");
        return obj;
    }
    public Aluno remove(String key){
        int pos = hashFunction(new Aluno(key));
        if (data[pos].isEmpty()) return null;
        Aluno obj = search(key);
        data[pos].remove(0);
        System.out.println("Chave:" + key + " e Valor:" + obj + " removidos!");
        return obj;
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
        ListaDuplamenteEncadeada[] newData = new ListaDuplamenteEncadeada[size * 2];
        for (int i = 0; i < size * 2; i++) {
            if(i < size){
                newData[i] = data[i];
            }
            else {
                newData[i] = new ListaDuplamenteEncadeada<Aluno>();
            }
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
