public class Plant extends Entidade{

    public Plant(int x, int y){
        super(x, y, 0, 2, 5, "*");
    }
    public boolean canReproduce(Entidade e){
        return e instanceof Plant;
    };
    public Entidade createNew(int x, int y){
        return new Plant(x, y);
    }
}