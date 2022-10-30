package tickets;

public class Bug extends Ticket {
    public UserStory userStory;
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory.isCompleted() && userStory!=null){
            return new Bug(id, name, estimate, userStory);
        } else {
            return null;
        }
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug "+ this.idTicket + "] "+ userStory.nameTicket +": "+ this.nameTicket;
    }
}
