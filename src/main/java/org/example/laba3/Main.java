package org.example.laba3;

public class Main {
    static int maxLength = 32;

    public static void main(String[] args) {
        int num = 1110;
        String binaryString = toBinaryString(num);
        System.out.printf("Number %d in binary view: %s\n",
                num, binaryString);
    }

    public static String toBinaryString(int num) {
        StringBuilder str = new StringBuilder(Integer.toBinaryString(num));
        if (str.length() > maxLength) {
            return str.substring(str.length() - maxLength, str.length());
        } else {
            while ((str.length() < 32)) {
                str.insert(0, "0");
            }
            return str.toString();
        }

    }
}