package com.mycompany.icetaskone;

import java.util.Scanner;

public class ICETaskOne {

    public static void main(String[] args)
    {
    String[] days = {"Monday", "Tuesday","Wednesday","Thursday", "Friday","Saturday","Sunday"};
    String[] bouquetTypes = {"Roses","Tulips","Lilies"};
    
    Scanner input = new Scanner(System.in);
    
    int numOfTypes = bouquetTypes.length;
    
    int[][] sales = new int[7][3];
    
        System.out.println("Enter daily sales figures for the flower shop");
        System.out.println("==============================================");
        
        int numOfDays = days.length;
        for (int i = 0; i <numOfDays; i++)
        {
            for (int j = 0; j < numOfTypes; j++)
            {
                int value = -1;
                while (value < 0)
                {
                    System.out.println("Enter sales of " + bouquetTypes[j] + " for " + days[i] + ": ");
                    //input.next();
                    
                    value = input.nextInt();
                    if (value < 0)
                    {
                        System.out.println("Please insert a positive number");
                    }
                }
                sales[i][j] = value;
            }
        }
        
        
        int[] dayTotal = new int[numOfDays];
        int[] typeTotal = new int[numOfTypes];
        int finalTotal = 0;
        
        for (int i = 0; i < numOfDays; i++)
        {
            int rowSum = 0;
            for(int j = 0; j < numOfTypes; j++)
            {
                rowSum += sales[i][j];
                typeTotal[j] += sales[i][j];
            }
            dayTotal[i] = rowSum;
            finalTotal += rowSum;
        }
        
        System.out.println();
        System.out.println("FLOWER SHOP WEEKLY SALES REPORT");
        System.out.println("==============================================");
        
        String header = "DAY";
        for (String type : bouquetTypes)
        {
            header = header + "\t" + type;
        }
        header = header + "\tTotal";
        System.out.println(header);
        
        System.out.println("---------------------------------------------");
        
        for (int i = 0; i < numOfDays; i++)
        {
            String row = days[i];
            for (int j = 0; j < numOfTypes; j++)
            {
                row = row + "\t" + sales[i][j];
            }
            row = row + "\t" + dayTotal[i];
            System.out.println(row);
        }
        
        System.out.println();
        System.out.println("---------------------------------------------");
        
        String totalRow = "TOTAL";
        for (int j = 0; j < numOfTypes; j++)
        {
            totalRow = totalRow + "\t" + typeTotal[j];
        }
        totalRow = totalRow + "\t" + finalTotal;
        System.out.println(totalRow);
        
        for (int j = 0; j < numOfTypes; j++)
        {
            System.out.println("Total sales for " + bouquetTypes[j] + ": " + typeTotal[j]);
        }
        
        System.out.println("Overall total sales for the week: R " + finalTotal);
        
        
    }
}
