import java.util.ArrayList;

abstract class Animal extends Entidade {

    private int energy;

    public Animal(int x, int y, int age, int maxAge, int eValue, int initialEnergy, int reproduceEnergyCost, String letter){
        super(x, y, age, maxAge, eValue, reproduceEnergyCost, letter);
        energy = initialEnergy;
    }
    public int getEnergy() { return energy; }

    // update energy when eating entity
    public void addEnergy(int e) { energy += e; }

    // remove one to the energy of entity per timeStep
    public void tired() { energy--; }

    // remove energy when reproducing
    public void reproducingCost(int e) { energy -= e; }

    public abstract boolean canReproduce(Entidade e);
    public abstract boolean canEat(Entidade e);
    public abstract boolean canDestroy(Entidade e);
    public abstract Entidade createNew(int x, int y);

    @Override
    public boolean canMove() { return true; }
}
