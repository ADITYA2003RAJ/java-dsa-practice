package com.aditya.strings;

import java.util.Scanner;

public class Problem2211CountCollisionsOnARoad {
    public static int countCollisions(String directions) {

        int count = 0;
        int n = directions.length();

        int i = 0;

        while(i < n && directions.charAt(i) == 'L'){
            i++;
        }

        int j = n - 1;

        while(j >= 0 && directions.charAt(j) == 'R'){
            j--;
        }

        while(i <= j){

            if(directions.charAt(i) != 'S'){
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Directions: ");
        String direction = sc.next();

        int count = countCollisions(direction);
        System.out.println("The count of collision of cars is: " + count);

        sc.close();
    }
}
