package org.subproblem.reader;

import org.subproblem.storage.BitsetStorage;
import org.subproblem.storage.Storage;
import org.subproblem.util.IPAddrParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {

    // This value (10 MB) works best for me, but it should be adjusted based on other users' needs.
    private final static int MAX_BYTES_TO_READ = 10 * 1024 * 1024;

    public void readData(Path filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)), MAX_BYTES_TO_READ)) {

            long fileSizeBytes = Files.size(filePath);
            System.out.println("Size of File in Bytes: " + fileSizeBytes);

            var start = System.currentTimeMillis();

            String line;
            while ((line = reader.readLine()) != null) {
                long ipToLong = IPAddrParser.ipToLong(line);


                // If you want to use BitSet uncomment BitsetStorage.addIP(ipToLong);
                // And comment Storage.addIPAddress(ipToLong);
                // BitsetStorage.addIP(ipToLong);


                Storage.addIPAddress(ipToLong);

            }

            var end = System.currentTimeMillis();
            System.out.println("Total amount of unique IP addresses: " + Storage.counter);
            System.out.println("Total time taken: " + (end - start) / 1000.0);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
