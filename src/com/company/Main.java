package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr = new InputStreamReader(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Введите номер задания (для завершения выберите 0):");
            int number = in.nextInt();
            switch (number) {
                case 0: {
                    isExit = true;
                    break;
                }
                case 1: {
                    System.out.println("n: ");
                    int n = in.nextInt();
                    System.out.println("repeat(mice, " + n + ") = " + One("mice", n));
                    System.out.println("repeat(hello, " + n + ") = " + One("hello", n));
                    System.out.println("repeat(stop, " + n + ") = " + One("stop", n));
                    break;
                }
                case 2: {
                    System.out.println("Введите длинну массива:");
                    int n = in.nextInt();
                    int[] array = new int [n];
                    System.out.println("Введите элементы массива:");
                    for (int i = 0; i < n; i++){
                        array[i] = in.nextInt();
                    }
                    System.out.println("differenceMaxMin = " + Two(array));
                    break;
                }
                case 3: {
                    System.out.println("Введите длинну массива:");
                    int n = in.nextInt();
                    int[] array = new int [n];
                    System.out.println("Введите элементы массива:");
                    for (int i = 0; i < n; i++){
                        array[i] = in.nextInt();
                    }
                    System.out.println("isAvgWhole = " + Three(array));
                    break;
                }
                case 4: {
                    System.out.println("Введите длинну массива:");
                    int n = in.nextInt();
                    int[] array = new int [n];
                    System.out.println("Введите элементы массива:");
                    for (int i = 0; i < n; i++){
                        array[i] = in.nextInt();
                    }
                    Four(array);
                    break;
                }
                case 5: {
                    in.nextLine();
                    System.out.println("Введите число:");
                    String str = in.nextLine();
                    System.out.println("getDecimalPlaces(" + str + ") = " + Five(str));
                    break;
                }
                case 6: {
                    System.out.println("Введите число:");
                    int num = in.nextInt();
                    System.out.println(Six(num));
                    break;
                }
                case 7: {
                    in.nextLine();
                    System.out.println("Введите число:");
                    String str = in.nextLine();
                    System.out.println("isValid(" + str + ") =" + Seven(str));
                    break;
                }
                case 8: {
                    System.out.println(Eight("ratio", "orator"));
                    System.out.println(Eight("sparkling", "groups"));
                    System.out.println(Eight("bush", "hubris"));
                    System.out.println(Eight("", ""));
                    break;
                }
                case 9: {
                    System.out.println(isPrefix("automation", "auto-"));
                    System.out.println(isSuffix("arachnophobia", "-phobia"));
                    System.out.println(isPrefix("retrospect", "sub-"));
                    System.out.println(isSuffix("vocation", "-logy"));
                    break;
                }
                case 10: {
                    System.out.println(Ten(0));
                    System.out.println(Ten(1));
                    System.out.println(Ten(2));
                    System.out.println(Ten(6));
                    System.out.println(Ten(9));
                    break;
                }
            }
        }
    }
    public static String One(String string, int n){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            for (int j = 0; j < n; j++) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }
    public static int Two(int[] array){
        int max = -10000;
        int min = 10000;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max) max = array[i];
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) min = array[i];
        }
        int result = max - min;
        return result;
    }
    public static boolean Three(int[] array){
        boolean simple = true;
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        int result = sum / array.length;
        for (int i = 2; i <= result-1; i++){
            if ( result % i == 0) simple = false;
            else simple = true;
        }
        return simple;
    }
    public static void Four(int[] array){
        int sum = 0;
       for (int i = 0; i < array.length; i++) {
           sum += array[i];
           array[i] = sum;
       }
       System.out.println("cumulativeSum = " + Arrays.toString(array));
    }
    public static int Five(String str){
        if (str.contains(".")){
            return str.length() - str.indexOf('.') - 1;
        }
        else return 0;
    }
    public static int Six(int number){
        if (number <= 2){
            return number;
        }
        return Six(number - 1) + Six(number - 2);
    }
    public static boolean Seven(String str){
        if (str.length() != 5) return false;
        for (int i = 0; i < str.length(); i++) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    static boolean Eight(String string1, String string2) {
        if (string1.length() == 0 && string2.length() == 0) {
            return true;
        }
        if (string1.charAt(0) != string2.charAt(string2.length() - 1)) {
            return false;
        }
        return string1.charAt(string1.length() - 1) == string2.charAt(0);
    }
    static boolean isPrefix(String word, String prefix) {
        if (prefix.charAt(prefix.length() - 1) == '-') {
            prefix = prefix.substring(0, prefix.length() - 1);
        } else return false;
        return word.contains(prefix);
    }

    static boolean isSuffix(String word, String suffix) {
        if (suffix.charAt(0) == '-') {
            suffix = suffix.substring(1, suffix.length() - 1);
        } else return false;
        return word.contains(suffix);
    }
    public static int Ten(int number){
            int result = 0;
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    result--;
                } else result += 3;
            }
            return result;
    }
}
