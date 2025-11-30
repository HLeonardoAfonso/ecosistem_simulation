import java.util.ArrayList;
import java.util.HashMap;

public class World {

    private int size;
    private ArrayList<Entidade>entityList;

    public World(int size){
        this.size = size;
        entityList = new ArrayList<>();
    }
    public void populate(){
        for( int x = 0; x < size; x++){
            for( int y = 0; y < size; y++){
                double n = Math.random();
                if      (n < 0.04) entityList.add(new Wolf(x, y));
                else if (n < 0.12) entityList.add(new Sheep(x, y));
                else if (n < 0.75) entityList.add(new Plant(x, y));
                // else xy = null
            }
        }
    }
    public void timeStep(){
        for (Entidade e : entityList){
            // moving
            // eating
            // reproducing
            e.aging();
            // dying
        }
    }
}
