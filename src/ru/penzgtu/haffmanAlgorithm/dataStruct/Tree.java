package ru.penzgtu.haffmanAlgorithm.dataStruct;

public class Tree {
    private Node root;
    private Tree left;
    private Tree right;

    public Tree(Tree left, Tree right) {
        this.root = new Node(left.getRoot().getFreq() + right.getRoot().getFreq());
        this.left = left;
        this.right = right;
    }

    public Tree(Node root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Tree() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public Node getRoot() {
        return root;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}


