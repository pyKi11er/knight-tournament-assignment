import java.util.List;
import java.util.ArrayList;

public class Player {
    private Color color;
    private List<Knight> knights;

    public Player(Color color){
        this.color = color;
        this.knights = new ArrayList<>();
    }

    public Color getColor(){
        return this.color;
    }

    public List<Knight> getKnights(){
        return this.knights;
    }

    public void addKnight(Knight knight){
        this.knights.add(knight);
    }
}
