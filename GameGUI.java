import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame implements BoardGUI.BoardClickListener {
    private Game game;
    private BoardGUI boardGUI;
    private JLabel statusLabel;
    private int boardSize;

    public GameGUI(){
        setTitle("Knight Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardSize = selectBoardSize();
        game = new Game(boardSize);       
        setupGUI();      
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupGUI(){
        getContentPane().removeAll();

        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        
        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.addActionListener(e -> startNewGame());
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        
        gameMenu.add(newGameItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(new java.awt.Color(240, 240, 240));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusLabel = new JLabel("Current Player: WHITE");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.NORTH);

        boardGUI = new BoardGUI(game, this);
        add(boardGUI, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new java.awt.Color(240, 240, 240));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JLabel infoLabel = new JLabel("Click your knight to select, then click a highlighted square to move");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        infoPanel.add(infoLabel);
        add(infoPanel, BorderLayout.SOUTH);

        boardGUI.updateBoard();
    }

    @Override
    public void onCellClicked(int row, int col){
        Knight knight = game.getBoard().getKnight(row, col);
        
        if(knight != null && knight.getOwner() == game.getCurrentPlayer()){
            game.selectKnight(row, col);
            boardGUI.updateBoard();
            statusLabel.setText("Current Player: " + game.getCurrentPlayer().getColor() + 
                              " (Knight selected at " + row + "," + col + ")");
        }
        else if(game.getSelectedKnight() != null){
            boolean moved = game.moveSelectedKnight(row, col);
            if(moved){
                boardGUI.updateBoard();
                checkGameEnd();
                if(!game.isGameEnded()){
                    statusLabel.setText("Current Player: " + game.getCurrentPlayer().getColor());
                }
            }
        }
    }

    private void checkGameEnd(){
        if(game.isGameEnded()){
            Color winner = game.checkGameOver();
            String message;
            
            if(winner != null){
                message = winner + " player wins!";
            } else {
                message = "Game ended in a draw! No grey fields left.";
            }

            JOptionPane.showMessageDialog(
                this, 
                message, 
                "Game Over", 
                JOptionPane.INFORMATION_MESSAGE
            );
            
            startNewGame();
        }
    }

    private void startNewGame(){
        boardSize = selectBoardSize();
        game = new Game(boardSize);
        setupGUI();
        pack();
    }

    private int selectBoardSize(){
        String[] options = {"4x4", "6x6", "8x8"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Select board size:",
            "Board Size",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]
        );

        if(choice == -1) choice = 1; // Default to 6x6 if closed
        return (choice == 0) ? 4 : (choice == 1) ? 6 : 8;
    }

}