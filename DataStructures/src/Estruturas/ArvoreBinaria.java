package Estruturas;

import java.util.ArrayList;

public class ArvoreBinaria{

    public ArvoreBinaria(){
        root = null;
        size = 0;
    }
    private static class Node{

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
        Node left;
        Node right;
        int data;
        public boolean isEmpty(){
            return left == null && right == null;
        }
        public boolean isLeft(){
            return left != null;
        }
        public boolean isRight(){
            return right != null;
        }
    }

    private Node root;

    private int size;

    public void add(int data){
        if (data < 0) return;
        size ++;
        Node newNode = new Node(data);
        root = insert(root,newNode);
    }
    private Node insert(Node root,Node newNode){
        if (root == null){
            root = newNode;
            return root;
        }
        else if(newNode.data >= root.data){
            root.right = insert(root.right,newNode);
        }
        else {
           root.left = insert(root.left,newNode);
        }
        return root;
    }

    public Node delete(int data){
        if(!search(data)) return null;
        size --;
        System.out.println("Valor " + data + " removido!");
        return  deleteNode(root,data);
    }

    private Node deleteNode(Node root,int data){
        if (root == null){
            return root;
        }
        else if(data < root.data){
            root.left = deleteNode(root.left,data);
        }
        else if(data > root.data){
            root.right = deleteNode(root.right,data);
        }
        else{
            if (root.isEmpty()){
                root = null;
            }
            else if(root.isRight()){
                root.data = sucessor(root.right);
                root.right = deleteNode(root.right,root.data);
            }
            else{
                root.data = predecessor(root.left);
                root.left = deleteNode(root.left,root.data);
            }
        }
        return root;
    }
    private int sucessor(Node root){
            if (root.isLeft()){
                return sucessor(root.left);
            }
            return root.data;
        }
    private int predecessor(Node root){
        if (root.isRight()){
            return predecessor(root.right);
        }
        return root.data;
    }

    public int traverse(int data){
        if(!search(data)) {
            return -1;
        }
        else{
            return getNode(root,data).data;
        }
    }

    private Node getNode(Node node, int data){
        if(node == null) {
            return null;
        }
        else if(node.data == data) {
            return node;
        }
        else if(node.data > data) {
            return getNode(node.left,data);}
        else{
            return getNode(node.right,data);
            }
    }

    public boolean search(int data){
        Node node = getNode(root,data);
        return  node != null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getRoot() {
        return root.data;
    }

    public int getSize() {
        return size;
    }
    private void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D()
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

}
