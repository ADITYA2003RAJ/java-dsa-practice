package com.aditya.strings;

import java.util.Scanner;

// Time Complexity : O(rows * cols)
// Space Complexity : O(rows)

public class Problem951DeleteColumnsToMakeSortedII {
    public static int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();

        int n = strs.length;

        boolean[] order = new boolean[n - 1];

        int delCount = 0;

        for(int col = 0 ; col<cols ; col++){
            boolean isDeleted = false;
            for(int row = 0 ; row < rows - 1 ; row++){

                if(!order[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)){
                    isDeleted = true;
                    delCount++;
                    break;
                }
            }

            if(isDeleted){
                continue;
            }

            for(int i = 0 ; i< rows - 1 ; i++){
                order[i] = order[i] | strs[i].charAt(col) < strs[i + 1].charAt(col);
            }
        }

        return delCount;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Enter String: ");
        String[] strs = new String[n];

        for(int i = 0 ; i<n ; i++){
            strs[i] = sc.next();
        }

        int result = minDeletionSize(strs);
        System.out.println("The count of deleted column to make lexicographical order is: " + result);

        sc.close();

    }
}
