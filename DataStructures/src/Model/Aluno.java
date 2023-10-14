package Model;

public class Aluno {
    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Aluno(String nome){
        this.id = -1;
        this.nome = nome;
    }
    private int id;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private String nome;
    public String toString(){
        return "{Nome:" + nome + ",id:" + id + "}";
    }

}
