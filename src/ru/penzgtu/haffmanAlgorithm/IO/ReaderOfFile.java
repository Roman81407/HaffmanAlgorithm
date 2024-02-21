package ru.penzgtu.haffmanAlgorithm.IO;

import java.io.*;
import java.util.ArrayList;

public class ReaderOfFile {
    private ArrayList<String> strings;
    private String path;

    public ReaderOfFile(String path) {
        strings = new ArrayList<>();
        this.path = path;
    }

    public ArrayList<String> read() {
        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                strings.add(st.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
