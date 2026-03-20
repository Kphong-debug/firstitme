import java.util.Scanner;

class Standard{
    private int day;

    public Standard(int day){
        this.day = day;
    }

    public int getFinalPrice(){
        if (this.day <= 3) return (500000* this.day);
        return (500000 * this.day) * 95 / 100;
    }
}

class Vip{
    private int day;

    public Vip (int day){
        this.day = day;
    }

    public int getFinalPrice(){
        return 2000000 * this.day;
    }
}
public class Main {
    public static void main(String[] args) {
        int cnt = 1;
        Scanner inp = new Scanner(System.in);

        while(true){
            
            System.out.print("Case " + cnt + ": " );
            String type = inp.next();
            int day = inp.nextInt();

            if (type.equals("-1")) break;

            if (type.equals("S")){
                Standard room = new Standard(day);
                System.out.println("Case " + cnt + ": " + room.getFinalPrice());
            }
            else{
                Vip room = new Vip(day);
                System.out.println("Case " + cnt + ": " + room.getFinalPrice());
            }
            cnt++;
            System.out.print('\n');
        }
        inp.close();
    }
}
