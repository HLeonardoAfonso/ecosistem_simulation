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
            //if (e instanceof Animal){
                // observing adjacent locations
                // located food
                // moving
                // eating
                // no food located
                // moving
            //}
            // reproducing
            e.aging();
            //dying of old age
            if (e.getAge() >= e.getMaxAge()){
                entityList.remove(e);           // remove entity from list
                e = null;                       // delete instance of entity
            }
        }
    }
    public StringBuilder printMapLn(int x){
        StringBuilder str = new StringBuilder("|");
        boolean f = false;
        for (int y = 0; y < size; y++) {
            f = false;
            for (Entidade e : entityList){
                if (e.getPos_x() == x && e.getPos_y() == y){
                    str.append(e.getLetter()+" ");
                    f = true;
                }
            }
            if ( !f ) str.append(". ");
        }
        str.append("|");
        return str;
    }
    public void charLine(){
        String charLine = "+";
        for (int j = 0; j < size*2; j++) {
            charLine = charLine + "-";
        }
        System.out.println(charLine+"+");
    }
    public void print(){
        charLine();
        for( int x = 0; x < size; x++) {
            System.out.println(printMapLn(x));
        }
        charLine();
    }
}
