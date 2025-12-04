import enums.SocialStatus;

public final class Semen extends Peasant {
    private boolean isMarried;

    public Semen(String name, int age, SocialStatus status, String clothingCondition) {
        super(name, age, status, clothingCondition);
        this.isMarried = false;
    }

    protected void marry() {
        if (isMarried) {
            System.out.println(getName() + " уже женат.");
        } else {
            System.out.println(getName() + " женился!");
            isMarried = true;
        }
    }
    public void getMarriedStatus() {
        if (isMarried) {
            System.out.println(getName() + " женат.");
        } else {
            System.out.println(getName() + " неженат.");
        }
    }

    @Override
    public String describeState() {
        return super.describeState() + ", женат: " + isMarried;
    }
}
