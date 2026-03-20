import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public abstract double getFinalPrice();
    public abstract String getType();
}

class Date{
    private int day, month, year;
    public Date(int day, int  month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }
}

class Electronics extends Product{
    private double mantancePrice;

    public Electronics(String name, double price, double mantancePrice){
        super(name, price);
        this.mantancePrice = mantancePrice;
    }

    @Override
    public double getFinalPrice() {
        return this.getPrice() + (this.getPrice() * 0.1) + this.mantancePrice;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}

class Food extends Product{
      private LocalDate expiryDate;

      public Food(String name, double price, LocalDate expiryDate){
        super(name, price);
        this.expiryDate = expiryDate;
      }

      public double getFinalPrice(){
        LocalDate nowDate = LocalDate.now();

        long daypassed = ChronoUnit.DAYS.between(this.expiryDate, nowDate);

        if (daypassed > -7) return this.getPrice() * 0.8;
        return this.getPrice();
      }
      
      public String getType(){
        return "Food";
      }
}

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        inp.nextLine();

        Product[] listProducts = new Product[n];
        for (int i = 0; i < n; i++){
            String line = inp.nextLine().trim();

            int first = line.indexOf('"');
            int last = line.lastIndexOf('"');

            String type = line.substring(0, first).trim();
            String name = line.substring(first + 1, last);
            String rest = line.substring(last + 1).trim();

            String[] numbers = rest.split("\\s+");
            
            if (type.equals("E"))
                listProducts[i] = new Electronics(name, Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            else {
                listProducts[i] = new Food(name, Double.parseDouble(numbers[0]), LocalDate.parse(numbers[1]));
            }

        }

        double total = 0;
        for (int i = 0; i < n; i++){
            System.out.println(listProducts[i].getName() + "-" + listProducts[i].getType() + "-" + listProducts[i].getFinalPrice());
            total += listProducts[i].getFinalPrice();
        }

        System.out.println("Total = " + total);
        inp.close();
    }
}
