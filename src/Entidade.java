import java.util.ArrayList;
import java.util.HashMap;

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

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int x) {
        pos_x = x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int y) {
        pos_y = y;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getMaxAge() {
        return max_age;
    }

    public void setMaxAge(int m) {
        max_age = m;
    }

    public int getEnergyValue() {
        return energy_value;
    }

    public void setEnergyValue(int v) {
        energy_value += v;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String c) {
        letter = c;
    }

    public abstract Entidade createNew(int x, int y);

    // add one to the age of entity per timeStep
    public void aging() {
        age++;
    }

// move

    // direction check
    public int directionCheck(int size) {
        boolean ok = false;
        int dir;
        do {
            dir = (int) (Math.random() * 4);
            switch (dir) {
                case 0:
                    if (pos_x != 0) {
                        ok = true;
                    }         // isn't in the north border
                    break;
                case 1:
                    if (pos_y != 0) {
                        ok = true;
                    }
                    ;        // isn't in the west border
                    break;
                case 2:
                    if (pos_x != size) {
                        ok = true;
                    }
                    ;     // isn't in the south border
                    break;
                case 3:
                    if (pos_y != size) {
                        ok = true;
                    }
                    ;     // isn't in the east border
                    break;
            }
        } while (!ok);
        return dir;
    }

    // check
    public Entidade entityCheck(ArrayList<Entidade> entityList, int dir) {
        int new_x = pos_x, new_y = pos_y;
        switch (dir) {
            case 0:
                new_x--;
                break;
            case 1:
                new_y--;
                break;
            case 2:
                new_x++;
                break;
            case 3:
                new_y++;
                break;
        }
        for (Entidade a : entityList) {          // runs all entities
            if (a.getPos_x() == new_x && a.getPos_y() == new_y) {      // xy coords are the same
                return a;
            }
        }
        //System.out.println("old: "+pos_x +"-"+ pos_y+"new: "+new_x+"-"+new_y);
        return null;
    }

    public void newLocation(int dir) {
        switch (dir) {
            case 0:
                pos_x--;
                break;            // move north
            case 1:
                pos_y--;
                break;            // move west
            case 2:
                pos_x++;
                break;            // move south
            case 3:
                pos_y++;
                break;            // move east
        }
    }

    public int findEmptyLocation(ArrayList<Entidade> entityList) {
        for (int i = 0; i < 4; i++) {              // try all directions
            int new_x = pos_x, new_y = pos_y;
            switch (i) {
                case 0:
                    new_x--;
                    break;
                case 1:
                    new_y--;
                    break;
                case 2:
                    new_x++;
                    break;
                case 3:
                    new_y++;
                    break;
            }
            boolean found = false;
            for (Entidade a : entityList) {          // runs all entities
                if (a.getPos_x() == new_x && a.getPos_y() == new_y) {      // xy coords are the same
                    found = true;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

// .createNewOnAdjacentPosition
// boolean (list)
// check direction, find . place new exit
// x++


    // observe surrounding locations
    public HashMap<String, String> observe(ArrayList<Entidade> entityList) {
        HashMap<String, String> observ = new HashMap<>();
        for (Entidade a : entityList) {
            if (a.getPos_x() == pos_x + 1) observ.put("N", a.getLetter());
            else if (a.getPos_x() == pos_x - 1) observ.put("S", a.getLetter());
            else if (a.getPos_y() == pos_y + 1) observ.put("E", a.getLetter());
            else if (a.getPos_y() == pos_y - 1) observ.put("W", a.getLetter());
        }
        if (!observ.containsKey("N")) observ.put("N", ".");
        if (!observ.containsKey("S")) observ.put("S", ".");
        if (!observ.containsKey("E")) observ.put("E", ".");
        if (!observ.containsKey("W")) observ.put("W", ".");
        return observ;
    }
}

