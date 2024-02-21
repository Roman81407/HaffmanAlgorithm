package ru.penzgtu.haffmanAlgorithm.haffman;

public class HaffmanDecoderMain {
    public static void main(String[] args) {
        HaffmanDecoder haffmanDecoder = new HaffmanDecoder("fileDecoder.txt");
        haffmanDecoder.decod();
    }
}
