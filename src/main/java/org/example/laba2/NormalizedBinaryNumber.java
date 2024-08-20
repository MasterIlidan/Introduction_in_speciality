package org.example.laba2;


public class NormalizedBinaryNumber {
    final int mantissaLength;
    final int exponentLength;
    final double num;
    private final int exponent;
    final boolean isNumNegative;
    final boolean isExponentNegative; //знак порядка

    private final String binaryMantissa;
    private final String binaryExponent;

    NormalizedBinaryNumber(double num, int mantissaLength, int exponentLength) {
        this.mantissaLength = mantissaLength;
        this.exponentLength = exponentLength;
        this.num = num;
        int regex = 2;

        if (num < 0) {
            isNumNegative = true;
            num = num * -1;
        } else {
            isNumNegative = false;
        }
        int exp = getExponent(num); //порядок
        if (exp < 0) {
            isExponentNegative = true;
            exponent = exp * -1;
        } else {
            isExponentNegative = false;
            exponent = exp;
        }

        String mantissa = Converter.from10to(num * Math.pow(10, exponent * -1), regex);
        mantissa = mantissa.replace("0.", ""); //часть с "0." нам не нужна
        mantissa = formatBynaryString(mantissa, mantissaLength);
        mantissa = isNumNegative ? "1" + mantissa : "0" + mantissa;
        binaryMantissa = mantissa;

        String exponentBinary = Converter.from10to(exponent, 2);
        exponentBinary = formatBynaryString(exponentBinary, exponentLength);
        exponentBinary = isExponentNegative ? "1" + exponentBinary : "0" + exponentBinary;
        binaryExponent = exponentBinary;
    }

    public int getExponent() {
        return exponent;
    }

    public String getBinaryMantissa() {
        return binaryMantissa;
    }

    public String getBinaryExponent() {
        return binaryExponent;
    }


    public int getExponent(double num) {
        int exponent = 0;
        if (num > 0) {
            while (num > 1) {
                num = num / 10;
                exponent++;
            }
        } else if (num < 0) {
            while (num < -1) {
                num = num * 10;
                exponent--;
            }

        }
        return exponent;
    }

    private String formatBynaryString(String binary, int length) {
        if (binary == null || binary.length() == length) return binary;
        StringBuilder binaryBuilder = new StringBuilder(binary);
        if (binary.length() < length) {
            while (binaryBuilder.length() < length) {
                binaryBuilder.insert(0, "0");
            }
        } else {
            binaryBuilder.delete(length, binary.length());
        }
        return binaryBuilder.toString();
    }
}
