package org.example.laba2;

public class NormalizedBinaryNumberMain {
    public static void main(String[] args) {
        double num = 265.4;

        final int mantissaLength = 8;
        final int exponentLength = 4;

        NormalizedBinaryNumber normalizedBinaryNumber = new NormalizedBinaryNumber(num,
                mantissaLength, exponentLength);

        System.out.println(normalizedBinaryNumber);
    }
}
