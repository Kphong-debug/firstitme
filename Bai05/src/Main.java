import java.util.Scanner;

abstract class Employee {
    private String name, id;

    public Employee (String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract double getSalary();
    public abstract String getType();
}

class FulltimeEmployee extends Employee{
    private double baseSalary, bonus, penalty;
    public FulltimeEmployee(String id, String name, double baseSalary, double bonus, double penalty){
        super(id, name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public String getType(){
        return "Full time";
    }

    @Override
    public double getSalary(){
        return this.baseSalary + (this.bonus - this.penalty);
    }
}

class ParttimeEmployee extends Employee{

    private double workingHours, hourlyRate;

    public ParttimeEmployee(String id, String name, double workingHours, double hourlyRate){
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
    }

    @Override
    public String getType(){
        return "Part time";
    }

    @Override
    public double getSalary(){
        return this.hourlyRate * this.workingHours;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        int n = inp.nextInt();
        inp.nextLine();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++){
            String line  = inp.nextLine().trim();

            if (line.isEmpty()) {
                i--;
                continue;
            }

            int first = line.indexOf('"');
            int last = line.lastIndexOf('"');

            String type = line.substring(0, first).trim();
            String name = line.substring(first + 1, last);
            String numbersPart = line.substring(last + 1).trim();

            String[] number = numbersPart.split("\\s+");

            if (type.equals("F")) employees[i] = new FulltimeEmployee("F", name, Double.parseDouble(number[0]), Double.parseDouble(number[1]), Double.parseDouble(number[2]));
            else employees[i] = new ParttimeEmployee("P", name, Double.parseDouble(number[0]), Double.parseDouble(number[1]));
        }


        for (int i = 0; i < n; i++){
            System.out.println(employees[i].getName() + " " + employees[i].getType() + " " + employees[i].getSalary());
        }
        inp.close();
    }
}
