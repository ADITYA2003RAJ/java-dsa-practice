package com.aditya.strings;

// Time Complexity : O(N)
// Space Complexity : O(1)

import java.util.Scanner;

public class Problem1769MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public static int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] store = new int[n];

        int sumValue = 0;
        int cumSumValue = 0;

        for(int i = 0 ; i<n ; i++){
            store[i] = cumSumValue;
            sumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumSumValue += sumValue;
        }

        sumValue = 0;
        cumSumValue = 0;

        for(int j = n - 1 ; j >= 0 ; j--){
            store[j] += cumSumValue;
            sumValue += boxes.charAt(j) == '0' ? 0 : 1;
            cumSumValue += sumValue;
        }

        return store;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter boxes: ");
        String boxes = sc.nextLine();

        int[] result = minOperations(boxes);
        System.out.print("Result Array: ");
        for(int i = 0 ; i<result.length ; i++){
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}

// Time Complexity : O(N ^ 2)
// Space Complexity : O(1)
//
//import java.util.Scanner;
//
//public class Problem1769MinimumNumberofOperationstoMoveAllBallstoEachBox {
//    public static int[] minOperations(String boxes) {
//
//        int n = boxes.length();
//        int[] store = new int[n];
//
//        for(int i = 0 ; i<n ; i++){
//            if(boxes.charAt(i) == '1'){
//                for(int j = 0 ; j<n ; j++){
//                    store[j] += Math.abs(j - i);
//                }
//            }
//        }
//
//        return store;
//    }
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter boxes: ");
//        String boxes = sc.nextLine();
//
//        int[] result = minOperations(boxes);
//        System.out.print("Result Array: ");
//        for(int i = 0 ; i<result.length ; i++){
//            System.out.print(result[i] + " ");
//        }
//
//        sc.close();
//    }
//}
