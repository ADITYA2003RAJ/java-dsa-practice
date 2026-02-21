package com.aditya.strings;

import java.util.Scanner;

public class Problem2982FindLongestSpecialSubstringThatOccursThrice2 {
    public static int maximumLength(String s) {

        int n = s.length();
        int[][] table = new int[26][n + 1];
        char prev_ch = s.charAt(0);

        int len = 0;

        for(int i = 0 ; i<n ; i++){
            char curr_ch = s.charAt(i);
            if(curr_ch == prev_ch){
                len++;
                table[curr_ch - 'a'][len] += 1;
            }
            else{
                len = 1;
                table[curr_ch - 'a'][len] += 1;
                prev_ch = curr_ch;
            }
        }

        int result = 0;

        for(int row = 0 ; row<26; row++){
            int cumSum = 0;
            for(int col = n ; col > 0 ; col--){
                cumSum += table[row][col];
                if(cumSum >= 3){
                    result = Math.max(result , col);
                    break;
                }
            }
        }

        return result == 0 ? -1 : result;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();

        int result = maximumLength(str);
        System.out.println("Maximum Length: " + result);

        sc.close();
    }
}
