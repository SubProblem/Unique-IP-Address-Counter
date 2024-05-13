package org.subproblem.storage;

import java.util.BitSet;



public class BitsetStorage {

    private static final int INTEGER_MAX = Integer.MAX_VALUE;

    // Note: The broadcast address 255.255.255.255 is not considered in this approach


    // BitSet to represent IP addresses within the range of 0 to 2,147,483,647 (Integer.MAX_VALUE)
    private static BitSet bitSetInteger = new BitSet();

    // BitSet to represent IP addresses within the range of 2,147,483,647 to 4,294,967,295
    private static BitSet bitSetLong = new BitSet();

    public static long counter = 0;

    public static void addIP(long address) {

        // Checks if the address is in range of Integer it will be stored in bitSetInteger

        if (address >= 0 && address <= INTEGER_MAX) {

            if (!bitSetInteger.get((int) address)) { // Check if bit is not already set (unique)
                bitSetInteger.set((int) address);
                counter++;
            }
        } else {
            // If the address is not in range of Integer, it will be stored in bitSetLong

            int adjustedIndex = (int) (address - INTEGER_MAX - 1); // Adjust index for bitSet2 (casting to int for bit index)

            if (!bitSetLong.get(adjustedIndex)) { // Check if bit is not already set (unique)
                bitSetLong.set(adjustedIndex);
                counter++;
            }
        }

    }

}
