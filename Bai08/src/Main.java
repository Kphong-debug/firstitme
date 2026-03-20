import java.util.Scanner;

abstract class Robot{
    private int id, batteryLevel;
    private String modelName;

    public Robot(int id, String modelName){
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery(){
        this.batteryLevel = 100;
    }

    public String getModelName(){
        return this.modelName;
    }

    public final void showIndentity(){
        System.out.println("ID: " + this.id + " | Name: " + this.modelName);
    }

    abstract public void performingMainTask();
}

interface Flyable{
    public void fly();
}
interface Swimmable{
    public void swim();
}

interface GPS{
    public void getCoordinate();
}

class DroneRobot extends Robot implements Flyable, GPS{
    public DroneRobot(int id, String modelName){
        super(id, modelName);
    }

    @Override
    public void fly(){
        System.out.println(this.getModelName() + " flying");
    }

    @Override
    public void getCoordinate(){
        System.out.println(this.getModelName() + " getting coordinate");
    }

    @Override
    public void performingMainTask(){
        System.out.println(this.getModelName() + " performing main task");
        this.fly();
        this.getCoordinate();
    }
}

class FishRobot extends Robot implements Swimmable{
    public FishRobot(int id, String modelName){
        super(id, modelName);
    }

    @Override
    public void swim(){
        System.out.println(this.getModelName() + " Swimming");
    }

    @Override
    public void performingMainTask(){
        System.out.println(this.getModelName() + " performing main task");
        this.swim();
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS{
    public AmphibiousRobot(int id, String name){
        super(id, name);
    }

     @Override
    public void swim(){
        System.out.println(this.getModelName() + " Swimming");
    }

    @Override
    public void fly(){
        System.out.println(this.getModelName() + " flying");
    }

    @Override
    public void getCoordinate(){
        System.out.println(this.getModelName() + " getting coordinate");
    }

      @Override
    public void performingMainTask(){
        System.out.println(this.getModelName() + " performing main task");
        this.fly();
        this.getCoordinate();
        this.swim();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        Robot[] listRobots = new Robot[n];
        for (int i = 0; i < n; i++){
            String type = inp.next();
            int id = inp.nextInt();
            String modelName = inp.next();

            if (type.equals("DR"))
                listRobots[i] = new DroneRobot(id, modelName);
            else if (type.equals("FR"))
                listRobots[i] = new FishRobot(id, modelName);
            else listRobots[i] = new AmphibiousRobot(id, modelName);

            
        }

        for (int i = 0; i < n; i++){
            listRobots[i].performingMainTask();
            System.out.println();
        }

        System.out.println("After checking: ");
        for (Robot rb : listRobots){
            if (rb instanceof Flyable) ((Flyable)rb).fly();
            if (rb instanceof Swimmable) ((Swimmable)rb).swim();
            if (rb instanceof GPS) ((GPS)rb).getCoordinate();

            System.out.println();
        }
        System.out.println("Checking Conflict");
        inp.close();
    }
}
