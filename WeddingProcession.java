import interfaces.Moveable;
import java.util.ArrayList;

public class WeddingProcession extends Entity {
    private ArrayList<Moveable> participants;

    public WeddingProcession(String name) {
        super(name);
        this.participants = new ArrayList<>();
    }

    protected void addParticipant(Moveable m) {
        participants.add(m);
    }

    protected void start() {
        System.out.println("Ко дворцу потянулось " + getName() + " шествие...");
        for (Moveable m : participants) {
            m.move();
        }
    }

    @Override
    public String describeState() {
        return getName() + ", участников: " + participants.size();
    }
}
