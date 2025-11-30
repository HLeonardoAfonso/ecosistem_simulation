public class Animal extends Entidade {

    private int energy;

    public Animal(int x, int y, int age, int maxAge, int eValue, int initialEnergy){
        super(x, y, age, maxAge, eValue);
        energy = initialEnergy;
    }
    public int getEnergy() { return energy; }
    public void setEnergy(int e) { energy = e; }

    // remove one to the energy of entity per timeStep
    public void tired() { energy--; }

    // update energy when eating entity
    public void ateEntity(Entidade eaten){
        energy += eaten.getEnergyValue();
    }
}
