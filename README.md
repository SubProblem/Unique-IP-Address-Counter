# Unique IP Address Counter

This project implements a program to efficiently count unique IP addresses from large files using optimized data structures and approaches.

## Problem Overview

Counting unique IP addresses from large files presents challenges due to memory and performance constraints. The naive approach using a line-by-line reader with a `HashSet` was inefficient for large datasets, necessitating the exploration of more efficient strategies.

## Approaches Explored

### First Approach: Buffered Reader with BitSet

The initial approach involved using a `BufferedReader` for efficient file reading coupled with a `BitSet` for tracking unique IP addresses. While this approach showed improvement over the naive method, the need to handle IP addresses exceeding 4 billion required multiple `BitSet` instances, which introduced complexity.

### Second Approach: Array of Integers

After further research and optimization, a more efficient approach was devised using an array of integers (`int[]`) to represent and track unique IP addresses. The array's size was optimized to `2^27` (134,217,728 elements) (`int[1 << 27]`), with each index capable of storing representations for up to 32 unique IP addresses using bitwise operations.

## Benchmark Results

- **Environment**:
    - CPU: AMD RYZEN 5 2600
    - SSD: Samsung SSD 870 EVO
    - File Size: 11 GB
    - Columns: Over 1 Billion

### Performance Comparison

| Approach | Data Structure | Total Time Taken (seconds) |
|----------|----------------|----------------------------|
| First Attempt | Array of Integers | 294.543 |
|              | BitSet | 298.389 |
| Second Attempt | Array of Integers | 288.711 |
|                | BitSet | 289.917 |

## Conclusion

While the array-based approach did not demonstrate significantly superior performance compared to using `BitSet`, it showed slightly better efficiency in counting unique IP addresses within large datasets. This optimization leverages the compact representation of IP address data using bit manipulation, resulting in improved processing speed and reduced memory overhead compared to the `BitSet` approach.
