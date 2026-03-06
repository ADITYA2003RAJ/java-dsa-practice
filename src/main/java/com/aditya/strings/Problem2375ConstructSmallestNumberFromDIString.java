package com.aditya.strings;

// Time Complexity : O(N)
// Space Complexity : O(N)

import java.util.Scanner;
import java.util.Stack;

public class Problem2375ConstructSmallestNumberFromDIString {
    public static String smallestNumber(String pattern) {

        int counter = 1;
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i <= n ; i++){
            st.add((char)(counter + '0'));
            counter++;

            if(i == n || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pattern: ");
        String pattern = sc.nextLine();
        String result = smallestNumber(pattern);
        System.out.println("The pattern is: " + result);

        sc.close();
    }
}
