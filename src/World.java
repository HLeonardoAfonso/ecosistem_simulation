import java.util.ArrayList;
import java.util.HashMap;

public class World {

    private int worldSize;
    private ArrayList<Entidade> entityList;
    private ArrayList<Entidade> deleteList;
    private HashMap<String, String> observeMap;

    public World(int size){
        this.worldSize = size;
        entityList = new ArrayList<>();
        deleteList = new ArrayList<>();
        observeMap = new HashMap<>();
    }
    public void populate(){
        for( int x = 0; x < worldSize; x++){
            for( int y = 0; y < worldSize; y++){
                double n = Math.random();
                if      (n < 0.04) entityList.add(new Wolf(x, y));
                else if (n < 0.12) entityList.add(new Sheep(x, y));
                //else if (n < 0.75) entityList.add(new Plant(x, y));
                // else xy = null
            }
        }
    }

    public void timeStep() {
        for (int nEntity = 0; nEntity < entityList.size(); nEntity++){
            Entidade e = entityList.get(nEntity);
            int direction = e.directionCheck(worldSize);
            Entidade destinationEntity = e.entityCheck(entityList, direction);
            if (destinationEntity == null){                 // empty location
                if (e instanceof Plant){
                    //Entidade newEntity = new Plant(entityList.get(nEntity).getPos_x(), entityList.get(nEntity).getPos_y());
                    //newEntity.newLocation(direction);
                    //entityList.add(newEntity);
                } else {
                    e.newLocation(direction);               // move to location
                }
            } else {                                        // some entity in destination
                if (e instanceof Animal){
                    // eat -- if entity in destination location can be eaten
                    if (((Animal) e).canEat(destinationEntity)){
                        deleteList.add(destinationEntity);                              // add eaten entity to delete list
                        ((Animal) e).addEnergy(destinationEntity.getEnergyValue());     // add energy to acting entity
                    }
                    // reproduce -- if entity in destination location is same species
                    if (((Animal) e).canReproduce(destinationEntity)){
                        //if energy  bigger than needed
                        //canReproduce
                        //is there space in adjacent location
                        int emptyDirection = e.findEmptyLocation(entityList);
                        // if return -1 entity is surrounded, no empty space
                        if (emptyDirection != -1){
                            // creates new entity
                            Entidade newEntity = e.createNew(e.getPos_x(), e.getPos_y());
                            newEntity.newLocation(emptyDirection);
                            entityList.add(newEntity);
                        }
                    }
                }
            }
            e.aging();
            if (e.getAge() >= e.getMaxAge()) {                  //dying of old age
                deleteList.add(e);                              // add to delete list
            }
        }
        for (Entidade a : deleteList) entityList.remove(a);     // delete entity
        deleteList.clear();                                     // clear delete list
    }

    public StringBuilder printMapLn(int x){
        StringBuilder str = new StringBuilder("|");
        boolean f = false;
        for (int y = 0; y < worldSize; y++) {
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
        for (int j = 0; j < worldSize*2; j++) {
            charLine = charLine + "-";
        }
        System.out.println(charLine+"+");
    }
    public void print(){
        charLine();
        for( int x = 0; x < worldSize; x++) {
            System.out.println(printMapLn(x));
        }
        charLine();
    }
}
