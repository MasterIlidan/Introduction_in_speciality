package org.example.laba2;

import java.util.ArrayList;
import java.util.Stack;

public class Converter {
    static ArrayList<Integer> divideResults = new ArrayList<>();
    static Stack<Integer> divideReceives = new Stack<>();

    static ArrayList<Integer> multiplyResults = new ArrayList<>();

    private static void clr() {
        divideReceives.clear();
        divideResults.clear();
        multiplyResults.clear();
    }

    public static int from2to10(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        if (!validateBinaryString(num)) { //проверка наличие "посторонних" символов
            throw new IllegalArgumentException("Invalid binary string: " + num);
        }
        //1110 = 1 * 2^3 +1* 2^2 +1* 2^1 +0* 2^0 =14
        char[] chars = num.toCharArray();
        int result = 0;
        int multiply = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                result += multiply;
            }
            multiply *= 2; //число - исходная система счисления. В теории можно переводить с любой
        }
        return result;
    }

    private static boolean validateBinaryString(String num) {
        //если есть что-то кроме 0 и 1
        for (char c : num.toCharArray()) {
            if (c == '1') {
                continue;
            }
            if (c == '0') {
                continue;
            }
            return false;
        }
        return true;
    }

    public static String from10to(int num, int regex) {
        if (regex > 10) throw new IllegalArgumentException("Regex > 10");
        if (regex < 1) throw new IllegalArgumentException("Regex < 1");
        if (regex == 10) return num + "";
        if (num == 0) return 0 + "";
        if (num == 1) return 1 + "";

        clr();

        do {
            divideReceives.add(num % regex);
            num = num / regex;
            divideResults.add(num);
        } while (num >= regex);
        divideReceives.add(num % regex);

        StringBuilder result = new StringBuilder();
        while (!divideReceives.isEmpty()) {
            result.append(divideReceives.pop());
        }
        return result.toString();
    }

    public static String from10to(double num, int regex) {
        if (regex > 10) throw new IllegalArgumentException("Regex > 10");
        if (regex < 1) throw new IllegalArgumentException("Regex < 1");
        if (regex == 10) return num + "";

        String decimalPart = from10to((int) num, regex);

        num = num - (int) num;

        clr();

        for (int i = 0; i <= 8; i++) {
            num = num * regex;
            multiplyResults.add((int) num);
            if (num > 1) {
                num = num - (int) num;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int fl : multiplyResults) {
            result.append(fl);
        }

        return decimalPart + "." + result;
    }
}
