package org.subproblem.util;

public class IPAddrParser {


    public static long ipToLong(String ipAddress) {

        // Split the IP address string into 4 octets using dot (.) as the delimiter
        var parsedIP = ipAddress.split("\\.");

        // Convert each octet from string to a long integer and perform bit shifting to combine them into a single long value
        // Example: For IP address "192.168.1.1"
        // - parsedIP[0] = "192", parsedIP[1] = "168", parsedIP[2] = "1", parsedIP[3] = "1"
        // - Convert each octet to long and perform bit shifting to combine them:
        //   - Long.parseLong(parsedIP[0]) << 24 => (192 << 24)
        //   - Long.parseLong(parsedIP[1]) << 16 => (168 << 16)
        //   - Long.parseLong(parsedIP[2]) << 8  => (1 << 8)
        //   - Long.parseLong(parsedIP[3])       => 1
        // - Combine the shifted values using bitwise OR (|) to get the final long value
        return Long.parseLong(parsedIP[0]) << 24 |
                Long.parseLong(parsedIP[1]) << 16 |
                Long.parseLong(parsedIP[2]) << 8 |
                Long.parseLong(parsedIP[3]);

    }

}
