package lsp;

public class Bird implements Animal, Walkable {

    @Override
    public void makeSound() {
        System.out.println("Bird chirps.");
    }

    @Override
    public void walk() {
        System.out.println("Bird is walking.");
    }
}
