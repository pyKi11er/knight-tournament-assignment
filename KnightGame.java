import javax.swing.SwingUtilities;

public class KnightGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI();
        });
    }
}