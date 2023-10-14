import Estruturas.ArvoreBinaria;
import Estruturas.ListaDuplamenteEncadeada;
import Estruturas.TabelaHashEncadeada;
import Estruturas.TabelaHashLinear;
import Model.Aluno;
import Pjbl1.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TabelaHashEncadeada table = new TabelaHashEncadeada(10);
        table.insert(new Aluno("jeba"));
        table.insert(new Aluno("jeba"));
        table.insert(new Aluno(1,"jair"));
        table.insert(new Aluno(15,"bolso"));
        table.insert(new Aluno(26,"lula"));
        System.out.println(table.search(15));
        System.out.println(table);

    }
}