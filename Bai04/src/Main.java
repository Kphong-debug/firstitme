class Animal{
    public void makeSound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Woof woof");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Meows meows");
    }

}

class Duck extends Animal{

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Before: Class Cast Exception");
        Animal a = new Dog();

        System.out.println("After: ");
        if (! (a instanceof Cat)){
            System.out.println("Day khong phai la Meo");
        }
        else{
            Cat c = (Cat) a;
            c.makeSound();
        }
    }
}