package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;
import java.util.Objects;

public class Sprint {
    private final Ticket[] tickets;
    protected final int CAPACITY;
    protected final int TICKETS_LIMIT;
    protected int totalEstimate = 0;
    protected int currentQuantity=0;

    public Sprint(int capacity, int ticketsLimit) {
        CAPACITY = capacity;
        TICKETS_LIMIT = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory != null && !userStory.isCompleted()) {
            int addedEstimate = this.totalEstimate + userStory.getEstimate();
            if (currentQuantity < TICKETS_LIMIT && addedEstimate <= CAPACITY) {
                if ((userStory.getDependencies().length != 0)) {
                    if (checkDependence(userStory)) {
                        tickets[currentQuantity] = userStory;
                        currentQuantity++;
                        totalEstimate = addedEstimate;
                        return true;
                    }
                } else {
                    tickets[currentQuantity++] = userStory;
                    totalEstimate = addedEstimate;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDependence(UserStory userStory){
        int temporaryConst = 0;
        for (UserStory dependence:userStory.getDependencies()) {
            for (Ticket ticket:tickets) {
                if (ticket!=null && dependence.getId()==ticket.getId()){
                    temporaryConst++;
                }
            }
        }
        return temporaryConst == userStory.getDependencies().length;
    }


    public boolean addBug(Bug bugReport) {
        if (bugReport!=null && !bugReport.isCompleted()){
            int addedEstimate = this.totalEstimate + bugReport.getEstimate();
            if (currentQuantity < TICKETS_LIMIT && addedEstimate <= CAPACITY) {
                tickets[currentQuantity] = bugReport;
                currentQuantity++;
                this.totalEstimate = addedEstimate;
                return true;
            }
        }
        return false;

    }


    public Ticket[] getTickets() {
        return Arrays.copyOfRange(tickets, 0, currentQuantity);
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }

}
