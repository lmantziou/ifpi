package com.ifpi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner readData = new Scanner(System.in);
        System.out.println("Enter any string :");
        String str = readData.nextLine();
        String[] str1 = str.split(" ");

        CalculateCharges.getTotalAmount(str1);
    }

}
