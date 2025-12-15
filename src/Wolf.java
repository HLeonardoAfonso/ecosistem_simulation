public class Wolf extends Animal{

    public Wolf(int x, int y){
        super(x, y, 0, 4, 0, 15, "W");
    }

    public boolean canEat(Entidade e){
        return e instanceof Sheep;
    };
    public boolean canReproduce(Entidade e){
        return e instanceof Wolf;
    };
    public Entidade createNew(int x, int y){
        return new Wolf(x, y);
    }
}