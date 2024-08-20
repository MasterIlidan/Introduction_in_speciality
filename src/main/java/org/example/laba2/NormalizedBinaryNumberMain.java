package org.example.laba2;

public class NormalizedBinaryNumberMain {
    public static void main(String[] args) {
        double num = 265.4;

        final int mantissaLength = 8;
        final int exponentLength = 4;

        NormalizedBinaryNumber normalizedBinaryNumber = new NormalizedBinaryNumber(num,
                mantissaLength, exponentLength);
        int exponent = normalizedBinaryNumber.getExponent();
        System.out.println("Num: " + num);
        System.out.println("Exponent:" + exponent);

        System.out.printf("%f x 10^%d\n", num * Math.pow(10, exponent * -1), exponent);
        System.out.printf("Binary mantissa: %s\nBinary exponent: %s\n", normalizedBinaryNumber.getBinaryMantissa(), normalizedBinaryNumber.getBinaryExponent());
    }
}
