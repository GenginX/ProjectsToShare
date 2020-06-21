package com.kaczmar.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String catalogName = "katalog1234";
        String fileName = "przyklad";

        File folder = new File(catalogName);
        boolean newFile = folder.mkdir();

        for (int i = 0; i < 100 ; i++) {
            int index = i + 1;
            String content = fileName+index+".txt";
            List<String> contentList = new ArrayList<>();
            contentList.add(content);
            String pathName = catalogName + "/" + content;
            File file = new File(pathName);
            Path path = Paths.get(pathName);

            try{
                boolean newtxt = file.createNewFile();
                Files.write(path,contentList);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
