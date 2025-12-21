public class Plant extends Entidade{

    public Plant(int x, int y){
        super(x, y, 0, 20, 5,"*");
    }

    @Override
    public Entidade createNew(int x, int y) { return new Plant(x, y); }

    @Override
    public boolean canMove() { return false; }
}