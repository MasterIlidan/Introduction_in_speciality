package org.example.laba2;


public class Mantissa {

    public static void main(String[] args) {
        int regex = 2;
        double num = 265.4;
        boolean isNumNegative = false;
        boolean isExponentNegative = false; //знак порядка

        int mantissaLength = 8;
        int exponentLength = 4;

        if (num < 0) {
            isNumNegative = true;
            num = num * -1;
        }
        int exponent = getExponent(num); //порядок
        if (exponent < 0) {
            isExponentNegative = true;
            exponent = exponent * -1;
        }
        System.out.println("Num: " + num);
        System.out.println("Exponent:" + exponent);

        System.out.printf("%f x 10^%d\n", num * Math.pow(10, exponent*-1), exponent);

        String mantissa = Converter.from10to(num * Math.pow(10,exponent * -1),regex);
        mantissa = mantissa.replace("0.", ""); //часть с "0." нам не нужна
        mantissa = formatBynaryString(mantissa, mantissaLength);
        mantissa = isNumNegative ? "1" + mantissa : "0" + mantissa;

        String exponentBinary = Converter.from10to(exponent,2);
        exponentBinary = formatBynaryString(exponentBinary, exponentLength);
        exponentBinary = isExponentNegative ? "1" + exponentBinary : "0" + exponentBinary;
        System.out.printf("Binary mantissa: %s\nBinary exponent: %s\n", mantissa, exponentBinary);
    }

    public static int getExponent(double num) {
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

    private static String formatBynaryString (String binary, int length) {
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
