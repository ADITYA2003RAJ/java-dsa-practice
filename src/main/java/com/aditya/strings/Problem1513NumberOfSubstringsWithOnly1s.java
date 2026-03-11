package com.aditya.strings;

// Time Complexity : O(N)
// Space Complexity : O(1)

import java.util.Scanner;

public class Problem1513NumberOfSubstringsWithOnly1s {
    public static int numSub(String s) {

        int n = s.length();
        int MOD = 1_000_000_007;

        int count = 0;
        int result = 0;

        for(char ch : s.toCharArray()){

            if(ch == '1'){
                count++;
                result = (result + count) % MOD;
            }
            else{
                count = 0;
            }
        }

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.next();

        int result = numSub(str);

        System.out.println("The final count of 1's substring is: " + result);

        sc.close();
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)

//import java.util.Scanner;
//
//public class Problem1513NumberOfSubstringsWithOnly1s {
//    public static int numSub(String s) {
//
//        int n = s.length();
//        int MOD = 1_000_000_007;
//
//        long count = 0;
//        long result = 0;
//
//        for(char ch : s.toCharArray()){
//
//            if(ch == '1'){
//                count++;
//            }
//            else{
//                result = (result + count * (count + 1) / 2) % MOD;
//                count = 0;
//            }
//        }
//
//        result = (result + count * (count + 1) / 2) % MOD;
//
//        return (int)result;
//    }
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter String: ");
//        String str = sc.next();
//
//        int result = numSub(str);
//
//        System.out.println("The final count of 1's substring is: " + result);
//
//        sc.close();
//    }
//}
