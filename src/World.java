import java.util.ArrayList;

public class World {

    private int worldSize;
    private ArrayList<Entidade> entityList;
    private ArrayList<Entidade> deleteList;

    public World(int size){
        this.worldSize = size;
        entityList = new ArrayList<>();
        deleteList = new ArrayList<>();
    }

    public void populate(){
        for( int x = 0; x < worldSize; x++){
            for( int y = 0; y < worldSize; y++){
                double n = Math.random();
                if      (n < 0.04) entityList.add(new Wolf(x, y));
                else if (n < 0.12) entityList.add(new Sheep(x, y));
                else if (n < 0.55) entityList.add(new Plant(x, y));
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
                if (!e.canMove()){
                    // not animals can reproduce to location
                    Entidade newEntity = e.createNew(e.getPos_x(), e.getPos_y());
                    newEntity.newLocation(direction);
                    entityList.add(newEntity);
                } else {
                    // animals move to location
                    e.newLocation(direction);               // move to location
                }
            } else {                                        // some entity in destination
                if (e instanceof Animal){
                    // eat -- if entity in destination location can be eaten
                    if (((Animal) e).canEat(destinationEntity)){
                        deleteList.add(destinationEntity);                              // add eaten entity to delete list
                        ((Animal) e).addEnergy(destinationEntity.getEnergyValue());     // add energy to acting entity
                        e.newLocation(direction);                                       // move to location
                    }
                    // reproduce -- if entity in destination location is same species
                    if (((Animal) e).canReproduce(destinationEntity)){
                        //if energy  bigger than needed
                        if (((Animal) e).getEnergy() > ((Animal) e).getReproducingCost()) {
                            //is there space in adjacent location
                            int emptyDirection = e.findEmptyLocation(entityList);
                            // if return -1 entity is surrounded, no empty space
                            if (emptyDirection != -1){
                                // creates new entity
                                Entidade newEntity = e.createNew(e.getPos_x(), e.getPos_y());
                                newEntity.newLocation(emptyDirection);                  // move to location
                                entityList.add(newEntity);
                                // remove energy for reproducing
                                ((Animal) e).reproducingCost(((Animal) e).getReproducingCost());
                            }
                        }
                    }
                    // destroy -- if entity in destination location can be stepped on
                    if (((Animal) e).canDestroy(destinationEntity)) {
                        deleteList.add(destinationEntity);      // remove entity on location
                        e.newLocation(direction);               // move to location
                    }
                }
            }
            if (e instanceof Animal) ((Animal) e).tired();      // getting tired by time
            e.aging();                                          // adding age
            if (e.getAge() >= e.getMaxAge()) {                  // dying of old age
                deleteList.add(e);                              // add to delete list
            }
        }
        for (Entidade a : deleteList) entityList.remove(a);     // delete entity
        deleteList.clear();                                     // clear delete list
    }

    public void print(){
        TerminalPrint map = new TerminalPrint(worldSize);
        map.charLine();
        for( int x = 0; x < worldSize; x++) {
            map.printMapLn(x, entityList);
        }
        map.charLine();
        map = null;     // do I need it?
    }
}
