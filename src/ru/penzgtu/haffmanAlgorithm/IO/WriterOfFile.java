package ru.penzgtu.haffmanAlgorithm.IO;

import java.io.FileWriter;
import java.io.IOException;

public class WriterOfFile {
    String filePath;

    public WriterOfFile(String path) {
        this.filePath = path;
    }

    public void write(String text) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
