package com.aditya.strings;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Optimal Solution

import java.util.Scanner;

public class Problem2337MovePiecesToObtainString {
    public static boolean canChange(String start, String target , int n) {

        int i = 0;
        int j = 0;

        while(i < n || j < n){

            while(i < n && start.charAt(i) == '_'){
                i++;
            }

            while(j < n && target.charAt(j) == '_'){
                j++;
            }

            if(i == n || j == n){
                return i == n && j == n;
            }

            if(start.charAt(i) != target.charAt(j)){
                return false;
            }

            if(start.charAt(i) == 'L' && i < j){
                return false;
            }

            if(start.charAt(i) == 'R' && i > j){
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter start string: ");
        String start = sc.nextLine();

        System.out.println("Enter end string: ");
        String end = sc.nextLine();

        int n = start.length();

        boolean result = canChange(start , end , n);
        System.out.println("can change: " + result);

        sc.close();
    }
}



/*

// Time Complexity : O(N * (2 ^ N))
// Space Complexity : O(N * (2 ^ N))
// Brute Force Approach Using Memoization

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Problem2337MovePiecesToObtainString {

    public static void swap(char[] arr , int i , int j){

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean canChange(String start, String target , Map<String , Boolean> map , int n) {

        if(start.equals(target)){
            return true;
        }

        if(map.containsKey(start)){
            return map.get(start);
        }

        char[] arr = start.toCharArray();

        for(int i = 0 ; i<n ; i++) {
            if (arr[i] == 'L' && i > 0 && arr[i - 1] == '_') {
                swap(arr, i, i - 1);

                if (canChange(new String(arr), target, map, n)) {
                    return true;
                }

                swap(arr, i, i - 1);
            }

            else if (arr[i] == 'R' && i < n - 1 && arr[i + 1] == '_'){
                swap(arr , i , i + 1);

                if(canChange(new String(arr) , target , map , n)){
                    return true;
                }

                swap(arr , i , i + 1);
            }
        }

        map.put(start , false);
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter start string: ");
        String start = sc.nextLine();

        System.out.println("Enter end string: ");
        String end = sc.nextLine();

        int n = start.length();

        Map<String , Boolean> map = new HashMap<>();

        boolean result = canChange(start , end , map , n);
        System.out.println("can change: " + result);

        sc.close();
    }
}

*/
