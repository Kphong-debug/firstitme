import java.util.Scanner;

class Employee{
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName(){
        return this.name;
    }
    public double caculateBonus(){
        return this.baseSalary * 0.1;
    }
}

class Developer extends Employee{
    int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours){
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double caculateBonus() {
        // TODO Auto-generated method stub
        return super.caculateBonus() + this.overtimeHours * 200000;
    }

    public String Gift() {
        return "Tặng khóa học AWS";
    }
}

class Tester extends Employee{
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound){
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double caculateBonus() {
        // TODO Auto-generated method stub
        return super.caculateBonus() + this.bugsFound * 50000;
    }

    public String Gift() {
        return "Tặng tool Test";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++){
            String type = inp.next();
            String name = inp.next();
            double baseSalary = inp.nextDouble();

            if (type.equals("D")){
                int overtimeHours = inp.nextInt();
                employees[i] = new Developer(name, baseSalary, overtimeHours);
            }
            else if (type.equals("T")){
                int bugsFound = inp.nextInt();
                employees[i] = new Tester(name, baseSalary, bugsFound);
            }
            else employees[i] = new Employee(name, baseSalary);

        }

        for (Employee em : employees){
            System.out.println(em.getName() + " - Bonus: " + em.caculateBonus());

            if (em instanceof Developer){
                Developer dev = (Developer) em;
                System.out.println(dev.Gift());
            }
            else if (em instanceof Tester){
                Tester tester = (Tester) em;
                System.out.println(tester.Gift());
            }

            System.out.println();
        }
        inp.close();
    }    
}
