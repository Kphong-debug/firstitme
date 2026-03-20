class MathUils{
    public int sum(int a, int b){
        return a + b;
    }
}

class AdvanceMath extends MathUils{
    @Override
    public int sum(int a, int b){
        return a + b + 10;
    }

    public double sum(double a, double b){
        return a + b;
    }
}


public class Main {
    public static void main(String[] args) {
        MathUils  m = new AdvanceMath();
        System.out.println(m.sum(5, 5));
        //System.out.println(m.sum(5.5, 5.5));
    }
}
