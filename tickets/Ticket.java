package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    protected int idTicket;
    protected String nameTicket;
    private int estimateTicket;
    protected boolean completedTicket=false;
    public Ticket(int id, String name, int estimate) {
        this.idTicket = id;
        this.nameTicket = name;
        this.estimateTicket = estimate;
    }

    public int getId() {
        return this.idTicket;
    }

    public String getName() {
        return this.nameTicket;
    }

    public boolean isCompleted() {
        return this.completedTicket;
    }

    public void complete() {
        this.completedTicket=true;
    }

    public int getEstimate() {
        return this.estimateTicket;
    }
}
