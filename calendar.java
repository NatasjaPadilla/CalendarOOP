/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prelimproject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nat
 */
public class calendar {
    public static ArrayList<String> months = new ArrayList<String>();
    public static int month = 0, year = 0;
    
    public static int daysinamonth() {
        int days = 0;
        
	switch(month) {
            case 1:
            case 3:
            case 5: 
            case 7:
            case 8:
            case 10:
            case 12:	
                days = 31; //these are the months with 31 days
		break;
            case 4:
            case 6:
            case 9:
            case 11:	
                days = 30; //these are the months with 30 days
		break;
            case 2:
                if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){ //for leap yer
                    days = 29;
                }
                else{
                    days = 28; //not leap year
                }
		break;
	}
        return days;
    }
    
    public static void formula(int month) {
        int day = 1;
	int y = year;
	int m = month;
	int d = day;
        
	if (month== 1 || month == 2) {
            m = month + 12;
            y = year - 1;
	}
	//formula i got from the old calendar activity
	int h = (d + (int) ((26 * (m + 1)) / 10) + y + (int) (y / 4)
	    	+ 6 * (int) (y / 100) + (int) (y / 400)) % 7;  
	       
	switch (h) {
	    case 0:
	    h += 7;
	}
            
        printcalendar(h, daysinamonth());
    }
    
    public static void printcalendar(int hplaceholder, int daysplaceholder) {
	System.out.println("______________________________________"); //this is a line
	System.out.println("Sun  Mon   Tue   Wed   Thu   Fri   Sat"); //these are the days in a week

	int dayy = 2 - hplaceholder;
	boolean insertvariable = false;
	        
	while (!insertvariable) {
	    for (int i = 1; i <= 7 && !insertvariable; i++) {
	    	if (dayy > 0) {
                    System.out.printf("%2d ", dayy);
                    System.out.print("   ");
	    	}
	    	else {
                    System.out.print("      ");
	    	}
	    	if (dayy >= daysplaceholder) {
                    insertvariable = true;
	    	}
	        dayy++;
	    }
	    System.out.println();
	}
        System.out.println();
    }
    
    public static void addmonthstocalendar() {
        //months added to the arraylist
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
	//prints each month
        for (int i = 0; i < months.size(); i++) {
            System.out.println("            " + months.get(i) + " " + year);
            month+=1; //adds 1 until it reaches 12 (for the switch case thingy)
            formula(month);
        }
    }
    
    public static int getInput() {
	Scanner scan = new Scanner(System.in);
	String number = "";
	int num = 0;
	do {
            number = scan.nextLine();
            num = intConverter(number);
	}
        while(num == -1);
        return num;
    }
        
    public static int intConverter(String input) {
	int num = -1;
	try {
            num = Integer.parseInt(input);
	}
	catch(Exception e) {
            System.out.println("not a number");
	}
	return num;
    }
    
    public static void write(String message) {
        System.out.println(message);
    }
    public static void writeln(String message) {
        write(message + "\n");
    }
    
    public static void main(String[] args) {
        writeln("enter year: "); //input
	year = getInput();
        
        addmonthstocalendar(); //prints the calendar
        //prints the calendar on TextEdit
        try {
            PrintStream var = System.out;
            PrintStream var2 = new PrintStream("/Users/tea/Desktop/Prelim_Calendar_Padilla_" + year + ".txt");
            System.setOut(var2);
            month=0;
            for (int i = 0; i < months.size(); i++) {
                System.out.println("            " + months.get(i) + " " + year);
                month+=1;
                formula(month);
            }
        }
        catch (Exception e) {
            writeln("unable to print");
        }
        
    }
    
}
