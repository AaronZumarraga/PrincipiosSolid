package lsp;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal fish = new Fish();
        Animal bird = new Bird();

        dog.makeSound();
        if (dog instanceof Walkable) {
            ((Walkable) dog).walk();  // Se puede caminar porque es un perro
        }

        fish.makeSound();
        // No intentamos que el pez camine, ya que no implementa Walkable

        bird.makeSound();
        if (bird instanceof Walkable) {
            ((Walkable) bird).walk();  // Se puede caminar porque es un pájaro
        }
    }
}
