public class Wolf extends Animal{

    public Wolf(int x, int y){
        super(x, y, 0, 40, 0, 15, 6, "W");
    }

    @Override
    public boolean canEat(Entidade e){
        return e instanceof Sheep;
    };

    @Override
    public boolean canReproduce(Entidade e){
        return e instanceof Wolf;
    };

    @Override
    public boolean canDestroy(Entidade e) { return e instanceof Plant; }

    @Override
    public Entidade createNew(int x, int y){
        return new Wolf(x, y);
    }
}