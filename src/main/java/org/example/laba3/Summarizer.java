package org.example.laba3;

public class Summarizer {

    public static void main(String[] args) {
        String a = "-1110";
        String b = "11101";

        System.out.printf("""
                This program will sum %s(%d) and %s(%d)
                """.formatted(a, Integer.parseInt(a, 2), b, Integer.parseInt(b, 2)));

        System.out.printf("""
                result is (%s)%s""".formatted(format(sum(a,b), 6),
                sum(a,b)));

    }

    private static String format(int num, int max) {
        String result = Integer.toBinaryString(num);

        if (result.length() > max) {
            result = result.substring(result.length() - max);
        }
        if (result.length() < max) {
            while (result.length() < max) {
                result = "0" + result;
            }
        }
        return result;
    }

    private static int sum(String a, String b) {
        return Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
    }
}
