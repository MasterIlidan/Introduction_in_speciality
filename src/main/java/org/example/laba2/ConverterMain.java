package org.example.laba2;

public class ConverterMain {
    public static void main(String[] args) {
        double num = 265.431;
        int regex = 2;

        System.out.printf("Converting number %f to %d...\n", num, regex);
        System.out.printf("Result: %s", Converter.from10to(num, regex));

        System.out.println("\n\n\n");

        String binary = "10111111";
        regex = 10;

        System.out.printf("Converting number %s to %d...\n", binary, regex);
        System.out.printf("Result: %s", Converter.from2to10(binary));
    }
}
