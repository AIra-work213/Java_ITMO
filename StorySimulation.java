import enums.GroundHazard;
import enums.SocialStatus;
import exceptions.StarvationException;
import java.util.ArrayList;
import java.util.Random;


public class StorySimulation {
    public static void main(String[] args) {
        StorySimulation sim = new StorySimulation();
        sim.runScene();
    }
    
    private void runScene() {
        
        ArrayList<Bell> bells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Bell bell = new Bell("Колокол " + (i + 1));
            bell.ring();
            bells.add(bell);
        }
        int birdsCount = new Random().nextInt(20, 51);
        Bird birds = new Bird("Птицы", birdsCount);
        birds.fly();
        
        WeddingProcession procession = new WeddingProcession("cвадебное");
        procession.addParticipant(birds);
        
        King king = new King("Король", 60, SocialStatus.ROYAL);
        king.observe(procession);
        procession.start();


        Peasant peasant = new Peasant("Мать-крестьянка", 50, SocialStatus.POOR, "cтарая, латаная");
        Semen semen = new Semen("Семен", 25, SocialStatus.POOR, "cтарая, латаная");
        
        System.out.println(peasant.getLocation() + " жили " + peasant.getName() + " и её сын " + semen.getName() + ".");
        
        semen.getMarriedStatus();

        peasant.getClothingCondition();
        semen.getClothingCondition();


        peasant.sleepOnStraw();
        
        try {
            peasant.tryToEat();
        } catch (StarvationException e) {
            System.out.println(e.getMessage());
        }

        double fertilityRate = new Random().nextDouble();
        Ground ground = new Ground("Участок земли", fertilityRate);
        
        System.out.println(ground.describeState());

        GroundHazard[] hazards = {
            GroundHazard.FROST,
            GroundHazard.DROUGHT,
            GroundHazard.FLOOD,
            GroundHazard.LOCUSTS
        };
        
        ground.processFarming(peasant, hazards);
    }
}
