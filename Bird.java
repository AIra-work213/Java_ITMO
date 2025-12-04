import interfaces.Moveable;

public class Bird extends Entity implements Moveable {
    private int flockSize;

    public Bird(String name, int flockSize) {
        super(name);
        this.flockSize = flockSize;
    }

    public void fly() {
        System.out.println(getName() + " (стая из " + flockSize + " птиц) слетелась");
    }

    @Override
    public void move() {
        System.out.println(getName() + " летит в шествии.");
    }

    @Override
    public String describeState() {
        return getName() + ", размер стаи: " + flockSize;
    }
}
