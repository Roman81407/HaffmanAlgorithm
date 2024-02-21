package ru.penzgtu.haffmanAlgorithm.dataStruct;

public class Node {
    private int freq;
    private char symbol;

    public Node(char symbol, int freq) {
        this.freq = freq;
        this.symbol = symbol;
    }

    Node(int freq) {
        this.freq = freq;
    }

    public Node(String symbol) {
        this.symbol = symbol.charAt(0);
    }

    public int getFreq() {
        return freq;
    }

    public char getSymbol() {
        return symbol;
    }
}
