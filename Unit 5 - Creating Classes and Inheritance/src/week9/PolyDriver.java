package week9;

public class PolyDriver {
    public static void main(String[] args) {
        /*NOT Polymorphism - reference is the same type as the instantiated Object
        Animal animal = new Animal();
        animal.makeSound(); //"Sound"
        Cat cat = new Cat();
        cat.makeSound(); //"Meow"
        Dog dog = new Dog();
        dog.makeSound(); //Bark
        dog.chaseTail();
        */

        /*Animal animal = new Cat();
        animal.makeSound(); //Meow
        //1. compilation time - checks to see if makeSound method exists in Animal class
        //2. run time - checks makeSound method in Cat*/

        Animal animal = new Dog(); //POLYMORPHISM
        animal.makeSound(); //Bark! //DYNAMIC BONDING - java waits until run time to figure out what class to use (parent or subclass)

        //animal.chaseTail(); //this will not work because Animal does not have a chaseTail method
        ((Dog)animal).chaseTail(); //cast this as a Dog 
    }
}
