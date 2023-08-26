import lib.Lista;
import lib.Pilha;

import java.util.Arrays;
import java.util.Objects;

public class FloodfillPilha {
    private int[][] img = {
            {1,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,1}
    };


    private Pilha<Lista<Integer>> pilha;

    private int initialValue;
    public FloodfillPilha(){
        initialValue = -1;
        pilha = new Pilha<>(100);
    }

    public void setPos(int row,int col,int newValue){
        if(initialValue == -1){
            setInitialValue(img[row][col]);
        }
        Lista<Integer> pos = new Lista<>(2);
        pos.add(row);
        pos.add(col);
        pilha.push(pos);
        fill(newValue);
    }

    private void fill(int newValue){
        if (pilha.isEmpty()) return;
        Lista<Integer> pos = pilha.pop();
        int row = pos.getData(0);
        int col = pos.getData(1);
            if (img[row][col] == initialValue) {
                img[row][col] = newValue;
                printImg();
                if(row - 1 >= 0){
                    Lista<Integer> up = new Lista<>(2);
                    up.add(row - 1);
                    up.add(col);
                    pilha.push(up);
                }
               if(row + 1 < img.length){
                   Lista<Integer> down = new Lista<>(2);
                   down.add(row + 1);
                   down.add(col);
                   pilha.push(down);
               }
               if(col - 1 >= 0){
                   Lista<Integer> left = new Lista<>(2);
                   left.add(row);
                   left.add(col - 1);
                   pilha.push(left);
               }
               if(col + 1 < img.length){
                   Lista<Integer> right = new Lista<>(2);
                   right.add(row);
                   right.add(col + 1);
                   pilha.push(right);
               }
            }
        fill(newValue);
    }

    private void setInitialValue(int value){
        initialValue = value;
    }
    public void printImg() {
        for(int i = 0;i < img.length;i ++){
            System.out.println(Arrays.toString(img[i]));
        }
        System.out.println("-----------------------------------------");
    }
}
