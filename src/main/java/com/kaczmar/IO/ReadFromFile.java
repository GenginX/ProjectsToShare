package com.kaczmar.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFromFile {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("katalog1234/przyklad2.txt");
        List<String> strings = Files.readAllLines(path);
        for(String s : strings){
            System.out.println(s);
        }

    }

}
