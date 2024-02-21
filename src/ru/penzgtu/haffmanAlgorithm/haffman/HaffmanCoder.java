package ru.penzgtu.haffmanAlgorithm.haffman;

import ru.penzgtu.haffmanAlgorithm.IO.WriterOfFile;
import ru.penzgtu.haffmanAlgorithm.dataStruct.Node;
import ru.penzgtu.haffmanAlgorithm.dataStruct.PriorityQueue;
import ru.penzgtu.haffmanAlgorithm.dataStruct.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class HaffmanCoder {
    private HashMap<String, String> table;
    private Handler handler;
    private String path;
    private String treeForFile = "";
    private String treeForFileSymbols = "";

    public HaffmanCoder(String path) {
        this.path = path;
        table = new HashMap<>();
        handler = new Handler(path);
        buildTableOfCodes();
    }

    private Tree buildTreeOfHaffman() {
        PriorityQueue priorityQueue = new PriorityQueue();
        Node[] nodes = handler.getFreqOfSym();

        for (Node node : nodes) {
            if (node.getFreq() > 0)
                priorityQueue.insert(new Tree(node));
        }

        while (priorityQueue.getSize() > 1) {
            Tree temp = new Tree(priorityQueue.getTree(0), priorityQueue.getTree(1));
            priorityQueue.removeTrees();
            priorityQueue.insert(temp);
        }
        return priorityQueue.getTree(0);
    }

    public void buildTableOfCodes() {
        Tree completeTree = buildTreeOfHaffman();
        reqBuildTable(completeTree, "");
    }

    private void reqBuildTable(Tree node, String str) {
        if (node.getLeft() != null) {
            reqBuildTable(node.getLeft(), str + "0");
            reqBuildTable(node.getRight(), str + "1");
        } else {
            table.put(String.valueOf(node.getRoot().getSymbol()), str);
        }
    }

    private String getStringOfTree() {
        inOrder(this.buildTreeOfHaffman(), "");
        return treeForFile;
    }

    private void inOrder(Tree tree, String LorR) {
        if (tree != null) {
            treeForFile += LorR;
            if (tree.getRoot().getSymbol() != '\0')
                treeForFileSymbols += tree.getRoot().getSymbol();
            inOrder(tree.getLeft(), String.valueOf(0));
            inOrder(tree.getRight(), String.valueOf(1));
        }
    }

    public HashMap<String, String> getTable() {
        return table;
    }

    public void coder() {
        String treeString = getStringOfTree();
        ArrayList<String> input = handler.getInputStrings();
        String inputStirng = "";
        String treeOfSymbolsCode = "";
        int count = 1;
        int j = 0;
        char a = treeString.charAt(0);
        while (treeString.charAt(j) == a) {
            count++;
            j++;
        }

        for (String s : input) inputStirng += s;
        char[] arr = inputStirng.toCharArray();
        char[] arr1 = treeForFileSymbols.toCharArray();
        String codedString = "";
        for (char c : arr) {
            codedString += table.get(String.valueOf(c));
        }
        for (char c : arr1) {
            treeOfSymbolsCode += table.get(String.valueOf(c));
        }

        WriterOfFile writerOfFile = new WriterOfFile("fileDecoder.txt");
        writerOfFile.write(treeForFile + "/" + treeForFileSymbols + "/" + codedString);
    }
}
