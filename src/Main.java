import java.util.Scanner;


void main() {

    Scanner myObj = new Scanner(System.in);
    int stepN = 5;
    int size = 20;
    System.out.println("Number of Steps: ");
    stepN = myObj.nextInt();
    System.out.println("Size of World: ");
    size = myObj.nextInt();

    World world = new World(size);
    world.populate();
    world.print();
    for (int i = 0; i<stepN; i++){
        world.timeStep();
        world.print();
    }
}
