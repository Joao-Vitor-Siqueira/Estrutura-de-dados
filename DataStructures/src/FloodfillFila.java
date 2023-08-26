import lib.Lista;
import lib.Fila;

import java.util.Arrays;

public class FloodfillFila {
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


    private Fila<Lista<Integer>> fila;

    private int initialValue;
    public FloodfillFila(){
        initialValue = -1;
        fila = new Fila<>(100);
    }

    public void setPos(int row,int col,int newValue){
        if(initialValue == -1){
            setInitialValue(img[row][col]);
        }
        Lista<Integer> pos = new Lista<>(2);
        pos.add(row);
        pos.add(col);
        fila.add(pos);
        fill(newValue);
    }

    private void fill(int newValue){
        if (fila.isEmpty()) return;
        Lista<Integer> pos = fila.remove();
        int row = pos.getData(0);
        int col = pos.getData(1);
        if (img[row][col] == initialValue) {
            img[row][col] = newValue;
            printImg();
            if(row - 1 >= 0){
                Lista<Integer> up = new Lista<>(2);
                up.add(row - 1);
                up.add(col);
                fila.add(up);
            }
            if(row + 1 < img.length){
                Lista<Integer> down = new Lista<>(2);
                down.add(row + 1);
                down.add(col);
                fila.add(down);
            }
            if(col - 1 >= 0){
                Lista<Integer> left = new Lista<>(2);
                left.add(row);
                left.add(col - 1);
                fila.add(left);
            }
            if(col + 1 < img.length){
                Lista<Integer> right = new Lista<>(2);
                right.add(row);
                right.add(col + 1);
                fila.add(right);
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
