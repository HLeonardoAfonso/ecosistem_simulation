import java.util.Scanner;


void main() {

    Scanner myObj = new Scanner(System.in);
    int stepN = 5;

    World world = new World(20);
    world.populate();
    world.print();
    for (int i = 0; i<stepN; i++){
        world.timeStep();
        world.print();
    }
}
