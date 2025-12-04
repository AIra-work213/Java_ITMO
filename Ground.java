import enums.GroundHazard;
import exceptions.GroundFailureException;

public final class Ground extends Entity {
    private double fertility;

    public Ground(String name, double fertility) {
        super(name);
        this.fertility = fertility;
    }

    public void processFarming(Peasant peasant, GroundHazard[] hazards) {
        if (this.getFertility() > 0.7){
            this.isGood();
        }
        else {
            for (GroundHazard hazard : hazards) {
                try {
                    SeasonalDisasters disasters = createDisasterFromHazard(hazard);
                    peasant.sow(this, disasters);
                } catch (GroundFailureException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private SeasonalDisasters createDisasterFromHazard(GroundHazard hazard) {
        return switch (hazard) {
            case FROST -> new SeasonalDisasters(false, true, false, false);
            case DROUGHT -> new SeasonalDisasters(true, false, false, false);
            case FLOOD -> new SeasonalDisasters(false, false, true, false);
            case LOCUSTS -> new SeasonalDisasters(false, false, false, true);
            case NONE -> new SeasonalDisasters(false, false, false, false);
        };
    }

    protected void cultivate(SeasonalDisasters disasters) throws GroundFailureException {
        if (disasters.isFrost()) {
            throw new GroundFailureException("Земля вымерзла!");
        }
        if (disasters.isDrought()) {
            throw new GroundFailureException("Земля засохла!");
        }
        if (disasters.isFlood()) {
            throw new GroundFailureException("Земля вымокла!");
        }
        if (disasters.hasLocusts()) {
            throw new GroundFailureException("Земля пострадала от саранчи!");
        }
    }

    @Override
    public String describeState() {
        if (fertility < 0.3) {
            return getName() + ", плодородность: " + fertility + " (неродящая земля)";
        } else {
            return getName() + ", плодородность: " + fertility + " (хорошая земля)";
        }
    }
    public double getFertility() {
        return fertility;
    }
    public void isGood(){
        System.out.println("Плодородность земли: " + fertility + ". Посадка успешна!");
    }
}
