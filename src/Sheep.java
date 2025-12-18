public class Sheep extends Animal{

    public Sheep(int x, int y){
        super(x, y, 0, 30, 10, 10, 3,"O");
    }

    @Override
    public boolean canEat(Entidade e){
        return e instanceof Plant;
    };

    @Override
    public boolean canReproduce(Entidade e){
        return e instanceof Sheep;
    };

    @Override
    public boolean canDestroy(Entidade e) {
        return false;
    }

    @Override
    public Entidade createNew(int x, int y){
        return new Sheep(x, y);
    }
}