import java.util.ArrayList;

abstract class Animal extends Entidade {

    private int energy;

    public Animal(int x, int y, int age, int maxAge, int eValue, int initialEnergy, String letter){
        super(x, y, age, maxAge, eValue, letter);
        energy = initialEnergy;
    }
    public int getEnergy() { return energy; }
    public void addEnergy(int e) { energy =+ e; }

    // remove one to the energy of entity per timeStep
    public void tired() { energy--; }

    // update energy when eating entity
    public void ateEntity(Entidade eaten){
        energy += eaten.getEnergyValue();
    }

    public abstract boolean canReproduce(Entidade e);
    public abstract boolean canEat(Entidade e);
    public abstract Entidade createNew(int x, int y);
}
