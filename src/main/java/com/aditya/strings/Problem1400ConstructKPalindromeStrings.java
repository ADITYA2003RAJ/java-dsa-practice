package com.aditya.strings;

import java.util.Scanner;

// Time Complexity : O(N)
// Space Complexity : O(1)

public class Problem1400ConstructKPalindromeStrings {
    public static boolean canConstruct(String s, int k) {

        int n = s.length();
        int[] freq = new int[26];

        if(n == k){
            return true;
        }

        if(n < k){
            return false;
        }

        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int oddCharCount = 0;
        for(int i = 0 ; i<26 ; i++){
            if(freq[i] % 2 != 0){
                oddCharCount++;
            }
        }

        return oddCharCount <= k;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();

        System.out.println("Enter k represent no. of palindrome is possible to make: ");
        int k = sc.nextInt();

        boolean result = canConstruct(str , k);
        System.out.println("is Palindrome: " + result);

        sc.close();
    }
}
