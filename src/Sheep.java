public class Sheep extends Animal{

    public Sheep(int x, int y){
        super(x, y, 0, 3, 10, 10, "O");
    }

    public boolean canEat(Entidade e){
        return e instanceof Plant;
    };

    public boolean canReproduce(Entidade e){
        return e instanceof Sheep;
    };

    public Entidade createNew(int x, int y){
        return new Sheep(x, y);
    }
}