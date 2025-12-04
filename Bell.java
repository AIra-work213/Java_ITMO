import interfaces.Ringable;

public final class Bell extends Entity implements Ringable {
    public Bell(String name) {
        super(name);
    }

    @Override
    public void ring() {
        System.out.println(getName() + " зазвонил сам собой!");
    }

    @Override
    public String describeState() {
        return getName() + " готов звонить.";
    }
}
