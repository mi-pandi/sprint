package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    final private UserStory [] dependencies;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependencies = dependsOn;

    }

    @Override
    public void complete() {
        if (this.dependencies.length==0){
            this.completedTicket =true;
        } else {
            for (UserStory dependence : this.dependencies) {
                if (!dependence.completedTicket){
                    this.completedTicket=false;
                    break;
                }
                this.completedTicket=true;
            }
        }
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOfRange(dependencies, 0, dependencies.length);
    }

    @Override
    public String toString() {
        return "[US "+ idTicket +"] "+ nameTicket;
    }
}
