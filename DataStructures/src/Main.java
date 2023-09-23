import Estruturas.ArvoreBinaria;
import Pjbl1.*;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.add(5);
        arvore.add(8);
        arvore.add(3);
        arvore.add(2);
        arvore.add(1);
        arvore.add(9);
        arvore.add(6);
        arvore.print2D();
    }
}