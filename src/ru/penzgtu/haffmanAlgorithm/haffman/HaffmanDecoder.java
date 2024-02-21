package ru.penzgtu.haffmanAlgorithm.haffman;

import ru.penzgtu.haffmanAlgorithm.IO.ReaderOfFile;
import ru.penzgtu.haffmanAlgorithm.IO.WriterOfFile;
import ru.penzgtu.haffmanAlgorithm.dataStruct.Node;
import ru.penzgtu.haffmanAlgorithm.dataStruct.Tree;

public class HaffmanDecoder {
    private String[] inputData;
    private Tree tree;
    private WriterOfFile writerOfFile;
    private int j;
    private int k;

    HaffmanDecoder(String path) {
        inputData = new ReaderOfFile(path).read().get(0).split("/");
        writerOfFile = new WriterOfFile("fileOutputDecoderText.txt");
        tree = new Tree();
        buildTree(tree);
        j = 0;
        k = 0;
    }

    private void buildTree(Tree tree) {
        String[] treeArr = inputData[0].split("");
        String[] symArr = inputData[1].split("");
        if (j < treeArr.length) {
            if (treeArr[j].equals("0")) {
                tree.setLeft(new Tree());
                j++;
                if (treeArr[j].equals("0"))
                    buildTree(tree.getLeft());
                if (treeArr[j].equals("1")) {
                    tree.setRight(new Tree());
                    j++;
                }
            }

            if (j < treeArr.length && treeArr[j].equals("0")) {
                buildTree(tree.getRight());
            }

        }
    }

    private void inOrder(Tree tree) {
        String[] symArr = inputData[1].split("");
        if (tree != null) {

            inOrder(tree.getLeft());
            inOrder(tree.getRight());
            if (tree.getLeft() == null && tree.getRight() == null) tree.setRoot(new Node(symArr[k++]));
        }
    }

    public void decod() {
        Tree temp = tree, temp2 = tree;
        buildTree(tree);
        inOrder(tree);

        String inputString = inputData[2];
        String outputString = "";
        int jj = 0;
        int jjj = 0;
        temp2 = temp = tree;

        while (jj < inputString.length()) {
            if (inputString.charAt(jj) == '0') {
                temp2 = temp;
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                    jj++;
                    if (jj == inputString.length()) outputString += temp.getRoot().getSymbol();
                } else {
                    outputString += temp2.getRoot().getSymbol();
                    temp2 = temp = tree;
                }
            } else if (inputString.charAt(jj) == '1') {
                temp2 = temp;
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                    jj++;
                    if (jj == inputString.length()) outputString += temp.getRoot().getSymbol();
                } else {
                    outputString += temp2.getRoot().getSymbol();
                    temp2 = temp = tree;
                }
            }
        }

        writerOfFile.write(outputString);
    }
}

