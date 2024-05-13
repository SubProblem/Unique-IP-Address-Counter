package org.subproblem.storage;

public class Storage {


     /*
    The main idea behind this code is to achieve memory efficiency by choosing a data structure that uses as little memory as possible.

    Initially, I attempted to use a BitSet, but I ended up needing to create two BitSets because the maximum IP address can exceed 4 billion.

    After doing some research to improve code performance, I decided to use an array of integers for the following reasons:

    The size of the array is 2^27, where each index can hold up to 32 bits because an int is 4 bytes in size.

    Therefore, a single index can store representations for up to 32 unique IP addresses.

    Each bit in the array represents a single IP address.
    */

    public static int[] addresses = new int[1 << 27];
    public static int counter = 0;

    public static void addIPAddress(long address) {
        // Calculate the index in the 'addresses' array where the bit for the IP address should be stored
        int index = (int) (address >> 5);

        // Calculate the bitmask to set the specific bit corresponding to the IP address within the 'index'
        int bit = 1 << (address & 31);

        // Check if the bit for the IP address is already set in 'addresses[index]'
        if ((addresses[index] & bit) == 0) {
            // If the bit is not set, increment the counter to track the number of unique IP addresses
            counter++;
            // Set the bit for the IP address in 'addresses[index]' using bitwise OR (|) operation
            addresses[index] |= bit;
        }
    }
}
