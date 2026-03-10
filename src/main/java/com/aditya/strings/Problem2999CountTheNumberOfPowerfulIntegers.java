package com.aditya.strings;

//Time Complexity : O(log10(N))
//Space Complexity : O(log10(N))

import java.util.Scanner;

public class Problem2999CountTheNumberOfPowerfulIntegers {
    private static long solve(long inputString , int limit , String s){
        String str = String.valueOf(inputString);

        if(str.length() < s.length()){
            return 0;
        }

        String suffix = str.substring(str.length() - s.length());
        long count = 0;

        int remainLength = str.length() - s.length();

        for(int i = 0 ; i<remainLength ; i++){
            int digit = str.charAt(i) - '0';

            if(digit <= limit){
                count += digit * Math.pow((limit + 1) , remainLength - i - 1);
            }
            else{
                count += Math.pow((limit + 1) , remainLength - i);
                return count;
            }
        }

        if(suffix.compareTo(s) >= 0){
            count++;
        }

        return count;
    }

    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return solve(finish , limit , s) - solve(start - 1 , limit , s);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start value: ");
        long start = sc.nextLong();

        System.out.println("Enter finish value: ");
        long finish = sc.nextLong();

        System.out.println("Enter limit value: ");
        int limit = sc.nextInt();

        System.out.println("Enter string: ");
        String s = sc.next();

        long result = numberOfPowerfulInt(start , finish , limit , s);
        System.out.println("The value of powerful int is : " + result);

        sc.close();
    }
}
