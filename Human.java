import enums.SocialStatus;
import interfaces.Moveable;

public class Human extends Entity implements Moveable {
    protected int age;
    protected SocialStatus status;

    public Human(String name, int age, SocialStatus status) {
        super(name);
        this.age = age;
        this.status = status;
    }

    @Override
    public void move() {
        System.out.println(getName() + " идет.");
    }

    @Override
    public String describeState() {
        return getName() + ", возраст: " + age + ", статус: " + status;
    }
}
