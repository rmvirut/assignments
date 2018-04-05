package assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author s4979389
 *
 * Could not finish the program. Missing key functions including printing full calendar,
 * adding invitees to events, incomplete testing.
 *
 */
public class Assignment3 {

    //holds all EventCalendars creadeted at runtime
    static ArrayList<EventsCalendar> calendars = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int response = 0;

        do {
            try {
                prompt();
                response = kbd.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option selected");
                response = 0;
            } finally {
                kbd.nextLine(); //clear input stream
                switch (response) {
                    case 1:
                        newCalendar();
                        break;
                    case 2:
                        createNewEvent();
                        break;
                    case 3:
                        displayCalendar();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Please try again");
                        break;
                }
            }
        } while (response != 6);
    }

    public static void newCalendar() {
        Scanner in = new Scanner(System.in);
        String name = "";
        String owner = "";
        //prompt user for calendar info
        System.out.printf("\n%s\n", "Please enter the name of the new Calendar");
        name = in.nextLine();
        System.out.println("Does this calendar have an owner?(yes/no)");
        if (in.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter the owner's name: ");
            owner = in.nextLine();
        }
        //create new calendar
        calendars.add(new EventsCalendar(name, owner));
    }

    public static void createNewEvent() {
        Scanner in = new Scanner(System.in);

        listCalendars();
        int response = in.nextInt();
        in.nextLine();
        Event newEvent = new Event();
        //add to the specified calendar
        calendars.get(response).addEvent(newEvent);
        System.out.printf("Event number %d created with null parameters\n", newEvent.getEventNum());
        //get details for the newly created event
        System.out.println("Please enter the event type");
        newEvent.setType(in.nextLine());
        System.out.println("Please enter the event title");
        newEvent.setTitle(in.nextLine());
        System.out.println("Please enter the event priority");
        newEvent.setPriority(in.nextInt());
        System.out.println("Please enter the event time (0-23)");
        newEvent.setTime(in.nextInt());
        System.out.println("Please enter the day of the month");
        newEvent.setDay(in.nextInt());
        System.out.println("Please enter the month");
        newEvent.setMonth(in.nextInt());
        System.out.println("Please enter the year");
        newEvent.setYear(in.nextInt());
        in.nextLine();//clear input stream
        System.out.println("Please enter the list of invitees separated by the comma");
        newEvent.addInvitees(in.nextLine());
        System.out.println(newEvent.toString());
    }

    public static void displayCalendar() {
        Scanner in = new Scanner(System.in);
        listCalendars();
        int index = in.nextInt();
        calendars.get(index).printCalendar(false);
    }

    public static void displayEvents() {
        Scanner in = new Scanner(System.in);
        listCalendars();//choose a calendar
        int index = in.nextInt();
        in.nextLine();//clear input stream of \n
        System.out.printf("%s\n", "Display events for which month/year (mm/yyyy)?");
        //get month and year as string and convert to int
        String[] response = in.nextLine().split("/");
        int[] respArr = new int[response.length];
        for (int i = 0; i < response.length; i++) {
            respArr[i] = Integer.parseInt(response[i]);
        }

        EventsCalendar temp = calendars.get(index);
        temp.printCalendar(true);
        Event holdMeNow; //holds the event object for now lol
        //iterate all events in the calendar
        for (int i = 0; i < temp.getEventCount(); i++) {
            holdMeNow = temp.getEvent(i);
            printSymbols(20, "-");
            //if the month/year fall within the category, print the Event and details
            if (respArr[0] == holdMeNow.getMonth() && respArr[1] == holdMeNow.getYear()) {
                System.out.println(holdMeNow.toString());
                printSymbols(20, "-");
            }
        }
    }

    public static void displayEventReminders() {
        Scanner in = new Scanner(System.in);
        listCalendars();
        int index = in.nextInt();
        EventsCalendar tempCalendar = calendars.get(index);//get selected calendar
        System.out.print("Please enter the period for which you want to view all event alerts (mm/yyyy:mm/yyyy):");
        //replace all non-digits with spaces and split to array (mm/yyyy:mm/yyyy becomes [mm, yyyy, mm, yyyy]);

        String[] resArr = in.nextLine().replaceAll("[\\D]", " ").split(" ");
        int[] resArrInt = new int[resArr.length];
        /*add code for min and max check*/
        for (int i = 0; i < resArr.length; i++) {
            resArrInt[i] = Integer.parseInt(resArr[i]);
        }

        Event tempEvent;
        for (int i = 0; i < tempCalendar.getEventCount(); i++) {
            tempEvent = tempCalendar.getEvent(i);
            if (tempEvent.getMonth() >= resArrInt[0] && tempEvent.getMonth() <= resArrInt[2] &&
                    tempEvent.getYear() >= resArrInt[1] && tempEvent.getYear() <= resArrInt[3]) {
                System.out.printf("%s", tempEvent.toString());
            }
        }
    }

    public static void prompt() {
        System.out.println("Please enter your choice from the available options:");
        String[] prompts = {"add a new calendar", "add an event to an existing calendar",
                "display empty calendar", "display all events in a specific calendar for a specific month/year",
                "display reminders for the closest events within the specified number of days",
                "exit program"};

        for (int i = 0; i < prompts.length; i++) {
            System.out.printf("%d) %s\n", i + 1, prompts[i]);
        }
        System.out.print(": ");
    }

    private static void listCalendars() {
        System.out.println("Please choose from one of the following calendars: ");
        for (int i = 0; i < calendars.size(); i++) {
            System.out.printf("Calendar#%d %s\n", i, calendars.get(i).name);
        }
    }

    private static void printSymbols(int numberOfdashes, String symbol) {
        for (int i = 0; i < numberOfdashes; i++) {
            System.out.printf("%s", symbol);
        }
        System.out.println();
    }
}
