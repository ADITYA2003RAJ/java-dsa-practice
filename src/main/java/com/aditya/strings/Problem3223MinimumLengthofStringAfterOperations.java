package com.aditya.strings;

import java.util.Scanner;

public class Problem3223MinimumLengthofStringAfterOperations {
    public static int minimumLength(String s) {

        int[] freq = new int[26];
        int n = s.length();
        int result = 0;


        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for(int i = 0 ; i<26 ; i++){

            if(freq[i] == 0){
                continue;
            }

            if(freq[i] % 2 == 0){
                result += 2;
            }
            else{
                result += 1;
            }
        }

        return result;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.next();

        int result = minimumLength(s);
        System.out.println("Minimum length of String: " + result);

        sc.close();
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)

//public class Problem3223MinimumLengthofStringAfterOperations {
//    public static int minimumLength(String s) {
//
//        int[] freq = new int[26];
//        int n = s.length();
//        int deleted = 0;
//
//        for(int i = 0 ; i<n ; i++){
//            char ch = s.charAt(i);
//            freq[ch - 'a']++;
//
//            if(freq[ch - 'a'] == 3){
//                freq[ch - 'a'] -= 2;
//                deleted += 2;
//            }
//        }
//        return n - deleted;
//    }
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter String: ");
//        String s = sc.next();
//
//        int result = minimumLength(s);
//        System.out.println("Minimum length of String: " + result);
//
//        sc.close();
//    }
//}


// Time Complexity : O(2N)
// Space Complexity : O(1)

//public class Problem3223MinimumLengthofStringAfterOperations {
//    public static int minimumLength(String s) {
//
//        int[] freq = new int[26];
//        int n = s.length();
//
//        for(int i = 0 ; i<n ; i++){
//            char ch = s.charAt(i);
//            freq[ch - 'a']++;
//
//            if(freq[ch - 'a'] == 3){
//                freq[ch - 'a'] -= 2;
//            }
//        }
//
//        int minLength = 0;
//
//        for(int i = 0 ; i<26 ; i++){
//            minLength += freq[i];
//        }
//
//        return minLength;
//    }
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter String: ");
//        String s = sc.next();
//
//        int result = minimumLength(s);
//        System.out.println("Minimum length of String: " + result);
//
//        sc.close();
//    }
//}
