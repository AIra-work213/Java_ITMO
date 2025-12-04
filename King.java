import enums.SocialStatus;

public class King extends Human {
    public King(String name, int age, SocialStatus status) {
        super(name, age, status);
    }

    protected void observe(WeddingProcession wp) {
        System.out.println(getName() + " наблюдает за шествием: " + wp.getName());
        System.out.println(getName() + " не видал такого шествия!");
    }
}
