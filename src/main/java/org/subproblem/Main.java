package org.subproblem;

import org.subproblem.reader.Reader;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\IPs.txt";

        Path filePath = Paths.get(path);

        Reader reader = new Reader();
        reader.readData(filePath);

    }

}



