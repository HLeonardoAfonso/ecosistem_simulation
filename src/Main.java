import java.util.Scanner;


void main() {

    Scanner myObj = new Scanner(System.in);
    int stepN = 3;

    World world = new World(20);
    world.populate();
    for (int i = 0; i<stepN; i++){
        world.print();
    }
}
