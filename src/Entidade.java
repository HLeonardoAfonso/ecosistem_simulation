public class Entidade {

    private int pos_x;
    private int pos_y;
    private int age;
    private int max_age;
    private int energy_value;

    public Entidade(int x, int y, int age, int maxAge, int eValue){
        pos_x = x;
        pos_y = y;
        this.age = age;
        this.max_age = maxAge;
        this.energy_value = eValue;
    }
    public int getPos_x() { return pos_x; }
    public void setPos_x(int x) { pos_x = x; }
    public int getPos_y() { return pos_y; }
    public void setPos_y(int y) { pos_y = y; }
    public int getAge() { return age; }
    public void setAge(int a) { age = a; }
    public int getMaxAge() { return max_age; }
    public void setMaxAge(int m) { max_age = m; }
    public int getEnergyValue() { return energy_value; }
    public void setEnergyValue(int v) { energy_value = v; }

    // add one to the age of entity per timeStep
    public void aging() { age++; }
}
