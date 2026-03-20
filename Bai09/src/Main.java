import java.util.Scanner;

interface IPayable{
    public double getPaymentamount();
}

abstract class Staff implements IPayable{
    private String id, name;
    
    public Staff(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public abstract String getType();
}

class PartTimeStaff extends Staff implements IPayable{
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate){
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentamount(){
        return this.workingHours * this.hourlyRate;
    }

    @Override
    public String getType() {
        return "PartTimeStaff";
    }
}

class Invoice implements IPayable{
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem){
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }
    
    @Override
    public double getPaymentamount() {
        return this.quantity * this.pricePerItem;
    }

     public String getName(){
        return this.itemName;
    }

    public String getType(){
        return "Invoice";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        IPayable[] payablesList = new IPayable[n];
        for (int i = 0; i < n; i++){
            String type = inp.next();
            
            if (type.equals("S")){
                String id = inp.next();
                String name = inp.next();
                int workingHours = inp.nextInt();
                double hourlyRate = inp.nextDouble();


                payablesList[i] = new PartTimeStaff(id, name, workingHours, hourlyRate);
            }
            else{
                String itemName = inp.next();
                int quantity = inp.nextInt();
                double pricePerItem = inp.nextDouble();

                payablesList[i] = new Invoice(itemName, quantity, pricePerItem);
            }
        }

        double totalPayment = 0;
        for (IPayable obj : payablesList){
            totalPayment += obj.getPaymentamount();

            if (obj instanceof PartTimeStaff){
                PartTimeStaff staff = (PartTimeStaff) obj;
                System.out.println(staff.getType() + " " + staff.getName() + " - Payment: " +  staff.getPaymentamount());
            }

            if (obj instanceof Invoice){
                Invoice item = (Invoice) obj;
                System.out.println(item.getType() + " " + item.getName() + " - Payment: " + item.getPaymentamount());
            }

        }
        System.out.println("Total Payment = " + totalPayment);
        inp.close();
    }
    
}
