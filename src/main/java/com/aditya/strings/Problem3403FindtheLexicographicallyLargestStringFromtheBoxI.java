package com.aditya.strings;


// Time Complexity : O(N)
// Space Complexity : O(1)
// Optimal Approach


import java.util.Scanner;

public class Problem3403FindtheLexicographicallyLargestStringFromtheBoxI {
    public static int answerString(String word, int numFriends) {

        int n = word.length();

        int i = 0;
        int j = 1;

        while(j < n){
            int k = 0;

            while(j + k < n && word.charAt(i + k) == word.charAt(j + k)){
                k++;
            }

            if(j + k < n && word.charAt(j + k) > word.charAt(i + k)){
                i = j;
                j = j + 1;
            }
            else{
                j = j + k + 1;
            }
        }

        return i;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String word = sc.nextLine();

        System.out.println("Enter no. of friends: ");
        int numFriends = sc.nextInt();

        int n = word.length();

        int i = answerString(word , numFriends);
        int maxLongestStringPossible = n - (numFriends - 1);
        int maxLength = Math.min(maxLongestStringPossible , n - i);

        String result = numFriends == 1 ? word : word.substring(i , i + maxLength);
        System.out.println("The largest substring will be: " + result);

        sc.close();
    }
}


// Time Complexity : O(N ^ 2)
// Space Complexity : O(1)
// Brute Force Approach
//
//import java.util.Scanner;
//
//public class Problem3403FindtheLexicographicallyLargestStringFromtheBoxI {
//    public static String answerString(String word, int numFriends) {
//
//        int n = word.length();
//
//        if(numFriends == 1){
//            return word;
//        }
//
//        int longestStringPossible = n - (numFriends - 1);
//        String result = "";
//
//        for(int i = 0 ; i<n  ; i++){
//            int maxLongest = Math.min(longestStringPossible , n - i);
//            String maxString = word.substring(i , i + maxLongest);
//
//            if(maxString.compareTo(result) > 0){
//                result = maxString;
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter String: ");
//        String word = sc.nextLine();
//
//        System.out.println("Enter no. of friends: ");
//        int numFriends = sc.nextInt();
//
//        String result = answerString(word , numFriends);
//        System.out.println("The largest substring will be: " + result);
//
//        sc.close();
//    }
//}
