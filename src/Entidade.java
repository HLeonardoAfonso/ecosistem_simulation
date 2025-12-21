import java.util.ArrayList;

abstract class Entidade {

    private int pos_x;
    private int pos_y;
    private int age;
    private int max_age;
    private int energy_value;
    private String letter;

    public Entidade(int x, int y, int age, int maxAge, int eValue, String letter) {
        pos_x = x;
        pos_y = y;
        this.age = age;
        this.max_age = maxAge;
        this.energy_value = eValue;
        this.letter = letter;
    }

    // location
    public int getPos_x() { return pos_x; }
    public int getPos_y() { return pos_y; }
    public void newLocation(int dir) {
        switch (dir) {
            case 0: pos_x--; break;            // move north
            case 1: pos_y--; break;            // move west
            case 2: pos_x++; break;            // move south
            case 3: pos_y++; break;            // move east
        }
    }
    // age
    public int getAge() { return age; }
    public int getMaxAge() { return max_age;}
    public void aging() { age++; }                                  // add one to the age of entity per timeStep
    // energy
    public int getEnergyValue() { return energy_value; }
    // letter
    public String getLetter() { return letter; }

    // direction check
    public int directionCheck(int size) {
        boolean ok = false;
        int dir;
        do {
            dir = (int) (Math.random() * 4);
            switch (dir) {
                case 0: if (pos_x != 0) ok = true;              // isn't in the north border
                    break;
                case 1: if (pos_y != 0) ok = true;              // isn't in the west border
                    break;
                case 2: if (pos_x != size) ok = true;           // isn't in the south border
                    break;
                case 3: if (pos_y != size) ok = true;           // isn't in the east border
                    break;
            }
        } while (!ok);
        return dir;
    }

    // check if there is an entity in the intended direction
    public Entidade entityCheck(ArrayList<Entidade> entityList, int dir) {
        int new_x = pos_x, new_y = pos_y;
        switch (dir) {
            case 0: new_x--; break;
            case 1: new_y--; break;
            case 2: new_x++; break;
            case 3: new_y++; break;
        }
        for (Entidade a : entityList) {          // runs all entities
            if (a.getPos_x() == new_x && a.getPos_y() == new_y) return a;       // entity found
        }
        return null;            // no entity
    }

    public int findEmptyLocation(ArrayList<Entidade> entityList) {
        for (int i = 0; i < 4; i++) {              // try all directions
            int new_x = pos_x, new_y = pos_y;
            switch (i) {
                case 0: new_x--; break;
                case 1: new_y--; break;
                case 2: new_x++; break;
                case 3: new_y++; break;
            }
            boolean found = false;
            for (Entidade a : entityList) {          // runs all entities
                if (a.getPos_x() == new_x && a.getPos_y() == new_y) found = true;      // entity found
            }
            if (!found) return i;       // return empty direction
        }
        return -1;          // no empty direction found
    }

    // abstract
    public abstract Entidade createNew(int x, int y);
    public abstract boolean canMove();

}