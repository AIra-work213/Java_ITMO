import enums.SocialStatus;
import exceptions.GroundFailureException;
import exceptions.StarvationException;

public class Peasant extends Human {
    private boolean hasGround;
    private String clothingCondition;
    private String location;

    public Peasant(String name, int age, SocialStatus status, String clothingCondition) {
        super(name, age, status);
        this.hasGround = true;
        this.clothingCondition = clothingCondition;
        this.location = "в деревне";
    }

    protected void sleepOnStraw() {
        System.out.println(getName() + " спит на соломе.");
    }

    protected void tryToEat() throws StarvationException {
        if (status == SocialStatus.POOR) {
            throw new StarvationException("В рот им положить нечего.");
        }
        System.out.println(getName() + " ест.");
    }

    protected void sow(Ground ground, SeasonalDisasters seasonalDisasters) throws GroundFailureException {
        System.out.println(getName() + " пытается посеять что-то на " + ground.getName() + "...");
        ground.cultivate(seasonalDisasters);
    }

    @Override
    public String describeState() {
        return super.describeState() + ", одежда: " + clothingCondition;
    }
    protected void getClothingCondition() {
        System.out.println(getName() + " статус одежды: " + clothingCondition);
    }
    protected String getLocation() {
        return location;
    }
}
