/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author s4979389
 */
public class EventsCalendar {

    // storing the coloring strings as class constants
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    final String name;
    final String owner;
    private ArrayList<Event> eventList;
    Calendar dispCal;
    private int eventCounter = 0;
    final int WIDTH = 20;
    final int WEEK = 7;

    public EventsCalendar(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.eventList = new ArrayList<>();
        this.dispCal = Calendar.getInstance();
        dispCal.set(2000, 0, 1);
        printCalendar(false);
    }

    public void addEvent(Event e) {
        eventList.add(e);
        eventCounter++;
    }

    public int getEventCount() {
        return eventCounter;
    }

    /**
     * Prints the full calendar with or without the event days highlighted depending on the specified
     * paramete
     *
     * @param showEvents
     */
    public void printCalendar(boolean showEvents) {
        //print calendar header
        printHeader(dispCal.get(Calendar.MONTH), dispCal.get(Calendar.YEAR));

        printWeeks(dispCal.get(Calendar.DAY_OF_MONTH),
                dispCal.get(Calendar.DAY_OF_WEEK),
                daysInMonth(dispCal.get(Calendar.MONTH), dispCal.get(Calendar.YEAR)),
                showEvents);
    }

    public Event getEvent(int i) throws ArrayIndexOutOfBoundsException {
        if (!eventList.isEmpty() && eventList.size() >= i) {
            return eventList.get(i);
        } else {
            throw new ArrayIndexOutOfBoundsException("Event does not exits;");
        }
    }

    /**
     * * Determines if argument is a leap year.** @param year current year
     *
     * @return true if year is a leap year code copied from instructor
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    /**
     * * Prints a header consisting of a month and a year centered on a line,*
     * followed by the days of the week** @param mo the number of the month
     * (1-12)* @param yr the year
     */
    public void printHeader(int mo, int yr) {
        String month = "";
        String calName = "";
        switch (mo) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        calName = name + " Calendar";
        int leadSpaces = (WIDTH - calName.length()) / 2;
        System.out.println("\n" + spaces(leadSpaces) + calName);
        month = month + " " + yr;
        leadSpaces = (WIDTH - month.length()) / 2;
        System.out.println(spaces(leadSpaces) + month);
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    /**
     * * Prints a header consisting of a month and a year centered on a line,*
     * followed by the days of the week** @param mo the number of the month
     * (1-12)* @param yr the year
     */
    public String spaces(int n) {
        String blanks = "";
        for (int i = 0; i < n; ++i) {
            blanks = blanks + " ";
        }
        return blanks;
    }

    /**
     * Returns the number of days in a given month
     * <p>
     * *
     *
     * @param mo the number of the month (1-12)
     * @param yr the year
     * @return the number of days in the given month-year
     */
    public int daysInMonth(int mo, int yr) {
        int days = 31;
        switch (mo) {
            case 2:
                days = 28;// February
                if (isLeapYear(yr)) {
                    days = 29;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
        }
        return days;
    }

    /**
     * Displays the dates for a given week on a line
     *
     * @param dayOfMonth  the starting date to print
     * @param dayOfWeek   the starting day of the week
     * @param daysInMonth the number of days in the month
     * @param wEvents     determines whether to highlight events or not
     * @return the next date to be printed
     */
    public int printWeeks(int dayOfMonth, int dayOfWeek, int daysInMonth, boolean wEvents) {
        boolean dayHasEvents;
        String dispClr = "";

        //create string for each week
        String weekS = "";
        int daysLeftCtr = daysInMonth;
        //first line of weeks
        if (dayOfMonth == 1 && dayOfWeek != 1) {
            weekS += spaces(dayOfWeek * 3);//add padding
            weekS += String.format("%2d", dayOfMonth);
        }

        if (dayOfWeek == 1) {//sunday
            weekS += String.format("%2d", dayOfMonth);
        } else {
            String padding = spaces(dayOfWeek * 3);
            weekS += padding;
        }

        System.out.println(weekS);
        weekS = "";

        //traverse all the days of the month
        while (dayOfMonth <= daysInMonth) {
            //iterate through a week
            for (int i = 0; i < 7; i++) {
                weekS += String.format("%2d ", dayOfMonth);
            }

            dayOfMonth++;
        }

        while (dayOfWeek <= 6 && dayOfMonth <= daysInMonth) {
            // check if events required to be displayed?
            if (wEvents = true) {
                //check whether the dayNumber in the this calendar dispDate has events in it?
                for (Event i : eventList) {

                    if (i.getDay() == dayOfMonth && i.getYear() == dispCal.get(Calendar.YEAR) && i.getMonth() == dispCal.get(Calendar.MONTH)) {
                        // if the day has events then change the display color to show this event and highlight it
                        dispClr = ANSI_YELLOW_BACKGROUND + ANSI_RED;
                    } else {
                        // else just keep the original display black color and don't highlight
                        dispClr = "";
                    }
                }
            }
            System.out.printf(dispClr + "%2d " + ANSI_RESET, dayOfMonth);
            dayOfWeek++;
            dayOfMonth++;
        }
        System.out.println();
        return dayOfMonth;
    }
}
