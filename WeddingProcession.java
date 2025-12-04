import interfaces.Holdable;
import interfaces.Moveable;
import java.util.ArrayList;

public class WeddingProcession implements Holdable {
    private String name;
    private ArrayList<Moveable> participants;

    public WeddingProcession(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    protected void addParticipant(Moveable m) {
        participants.add(m);
    }

    @Override
    public void hold() {
        System.out.println("Шествие " + getName() + " проводится.");
    }

    protected void start() {
        hold();
        System.out.println("Ко дворцу потянулось " + getName() + " шествие...");
        for (Moveable m : participants) {
            m.move();
        }
    }

    public String describeState() {
        return getName() + ", участников: " + participants.size();
    }
}
