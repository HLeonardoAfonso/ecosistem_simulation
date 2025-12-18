import java.util.ArrayList;

public class TerminalPrint {

    private int worldSize;

    public TerminalPrint(int worldSize){
        this.worldSize = worldSize;
    }

    public void charLine(){
        String charLine = "+";
        for (int j = 0; j < worldSize*2; j++) {
            charLine = charLine + "-";
        }
        System.out.println(charLine+"+");
    }

    public void printMapLn(int x, ArrayList<Entidade> entityList){
        StringBuilder str = new StringBuilder();
        boolean f = false;
        for (int y = 0; y < worldSize; y++) {
            f = false;
            for (Entidade e : entityList){
                if (e.getPos_x() == x && e.getPos_y() == y){
                    str.append(e.getLetter()).append(" ");
                    f = true;
                }
            }
            if ( !f ) str.append(". ");
        }
        System.out.println("|"+str+"|");
    }
}
