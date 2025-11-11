import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardGUI extends JPanel {
    private Game game;
    private JButton[][] buttons;
    private int boardSize;
    private BoardClickListener clickListener;

    public interface BoardClickListener {
        void onCellClicked(int row, int col);
    }

    public BoardGUI(Game game, BoardClickListener listener){
        this.game = game;
        this.clickListener = listener;
        this.boardSize = game.getBoard().getSize();
        
        setLayout(new GridLayout(boardSize, boardSize));
        buttons = new JButton[boardSize][boardSize];
        
        initBoard();
    }

    private void initBoard(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(80, 80));
                button.setFont(new Font("Arial", Font.BOLD, 24));
                
                final int row = i;
                final int col = j;
                
                button.addActionListener(e -> {
                    if(clickListener != null){
                        clickListener.onCellClicked(row, col);
                    }
                });
                
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    public void updateBoard(){
        Board board = game.getBoard();
        List<int[]> possibleMoves = game.getPossibleMoves();

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                JButton button = buttons[i][j];
                Color cellColor = board.getCellColor(i, j);
                Knight knight = board.getKnight(i, j);

                if(cellColor == Color.WHITE){
                    button.setBackground(java.awt.Color.WHITE);
                } else if(cellColor == Color.BLACK){
                    button.setBackground(java.awt.Color.BLACK);
                } else {
                    button.setBackground(java.awt.Color.LIGHT_GRAY);
                }

                if(knight != null){
                    if(knight.getOwner().getColor() == Color.WHITE){
                        button.setText("♘");
                        button.setForeground(java.awt.Color.BLUE);
                    } else {
                        button.setText("♞");
                        button.setForeground(java.awt.Color.RED);
                    }
                } else {
                    button.setText("");
                }
                
                boolean isHighlighted = false;
                if(possibleMoves != null){
                    for(int[] move : possibleMoves){
                        if(move[0] == i && move[1] == j){
                            button.setBorder(BorderFactory.createLineBorder(java.awt.Color.GREEN, 3));
                            isHighlighted = true;
                            break;
                        }
                    }
                }
                
                if(!isHighlighted){
                    button.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY, 1));
                }
            }
        }
        
        repaint();
    }

    public void setGame(Game game){
        this.game = game;
        this.boardSize = game.getBoard().getSize();
    }
}