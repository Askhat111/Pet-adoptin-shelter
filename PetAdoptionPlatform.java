import java.util.ArrayList;
import java.util.Scanner;

// Pet class
class Pet {
    private String name;
    private String type;
    private int age;

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "', type='" + type + "', age=" + age + "}";
    }
}

// Adopter class
class Adopter {
    private String name;

    public Adopter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void adoptPet(Pet pet) {
        System.out.println("Congratulations " + name + "! You have adopted " + pet.getName() + " the " + pet.getType() + ".");
    }
}

// Shelter class
class Shelter {
    private ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void displayPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets available for adoption at the moment.");
        } else {
            System.out.println("Available Pets for Adoption:");
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i + 1) + ". " + pets.get(i));
            }
        }
    }

    public Pet adoptPet(int index) {
        if (index >= 0 && index < pets.size()) {
            return pets.remove(index);
        } else {
            System.out.println("Invalid choice. Try again.");
            return null;
        }
    }
}

// Main class
public class PetAdoptionPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shelter shelter = new Shelter();

        // Adding sample pets to the shelter
        shelter.addPet(new Pet("Bobik", "Dog", 3));
        shelter.addPet(new Pet("Barsik", "Cat", 2));
        shelter.addPet(new Pet("Bugz bunny", "Rabbit", 1));

        System.out.println("Welcome to the Pet Adoption Platform!");
        System.out.print("Enter your name: ");
        String adopterName = scanner.nextLine();
        Adopter adopter = new Adopter(adopterName);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View available pets");
            System.out.println("2. Adopt a pet");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shelter.displayPets();
                    break;

                case 2:
                    shelter.displayPets();
                    System.out.print("Enter the number of the pet you want to adopt: ");
                    int petChoice = scanner.nextInt() - 1;

                    Pet adoptedPet = shelter.adoptPet(petChoice);
                    if (adoptedPet != null) {
                        adopter.adoptPet(adoptedPet);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Pet Adoption Platform. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


