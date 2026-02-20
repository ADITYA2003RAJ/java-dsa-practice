package com.aditya.strings;

import java.util.Scanner;

public class LeetCode2825MakeStringSubsequence {
    public static boolean canMakeSubsequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int i = 0;
        int j = 0;

        while(i < m && j < n){
            char ch_i = str1.charAt(i);
            char ch_j = str2.charAt(j);

            if(ch_i == ch_j || ch_i + 1 == ch_j || (ch_i == 'z' && ch_j == 'a')){
                j++;
            }
            i++;
        }
        return j == n;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String: ");
        String str1 = sc.nextLine();

        System.out.println("Enter second String: ");
        String str2 = sc.nextLine();

        boolean result = canMakeSubsequence(str1 , str2);
        System.out.println("Can make subsequence: " + result);

        sc.close();
    }
}
