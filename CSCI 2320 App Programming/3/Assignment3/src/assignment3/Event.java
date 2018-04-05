/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.*;

/**
 *
 * @author s4979389
 */
public class Event {

    String title;
    String type;
    int priority;
    private Calendar eventCalendar;
    static int eventNum = 0;
    private ArrayList<String> invitees;

    public Event() {
        this.title = "";
        this.type = "";
        this.eventCalendar = Calendar.getInstance();
        this.priority = 0;
        eventNum++;
        invitees = new ArrayList();
    }

    public Event(String name, String type, int priority) {
        this.title = name;
        this.type = type;
        this.eventCalendar = Calendar.getInstance();
        this.priority = priority;
        eventNum++;
        invitees = new ArrayList();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        String text = String.format("Title: %s\n"
                + "Event Type: %s\n"
                + "Event Time/Date: %d:00, %2d/%2d/%d\n"
                + "Priority: %d\n"
                + "Invitees: %s", this.title, this.type, eventCalendar.getTime(),
                eventCalendar.get(Calendar.DAY_OF_MONTH),
                eventCalendar.get(Calendar.MONTH), eventCalendar.get(Calendar.YEAR),
                this.priority, invitees.toString());
        return text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static int getEventNum() {
        return eventNum;
    }

    public static void setEventNum(int eventNum) {
        Event.eventNum = eventNum;
    }

    public ArrayList<String> getInvitees() {
        return invitees;
    }

    public int getDay() {
        return eventCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return eventCalendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return eventCalendar.get(Calendar.MONTH);
    }

    public void addInvitees(String invitees) {
        //split the invitees into an array of strings
        String[] inviteesArr = invitees.split(",");
        this.invitees.addAll(Arrays.asList(inviteesArr));
    }

    public int getTime() {
        return eventCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public void setTime(int time) {
        eventCalendar.set(Calendar.HOUR, time);
    }

    public void setDay(int day) {
        this.eventCalendar.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setMonth(int month) {
        this.eventCalendar.set(Calendar.MONTH, month);
    }

    public void setYear(int year) {
        this.eventCalendar.set(Calendar.YEAR, year);
    }
}
