import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectFourFrame frame = new ConnectFourFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ConnectFourFrame extends JFrame {
    private ConnectFour game;
    private JPanel boardPanel;
    private JLabel statusLabel;
    private JButton[] columnButtons = new JButton[7];
    private JLabel winsLabel;
    private int redWins = 0;
    private int blueWins = 0;

    public ConnectFourFrame() {
        setTitle("khermans - ConnectFour");
        setSize(700, 600);
        setLocationRelativeTo(null);

        game = new ConnectFour();

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        
        JMenuItem undoMenuItem = new JMenuItem("Undo Last Move");
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenuItem loadGameMenuItem = new JMenuItem("Load Game");
        JMenuItem saveGameMenuItem = new JMenuItem("Save Game");

        // Add actions
        undoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Undo logic
            }
        });

        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.initializeBoard();
                updateBoard();
                updateStatus("Red player turn");
            }
        });

        loadGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load game logic
            }
        });

        saveGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save game logic
            }
        });

        // Add items to the menu
        menu.add(undoMenuItem);
        menu.add(newGameMenuItem);
        menu.add(loadGameMenuItem);
        menu.add(saveGameMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Add board panel
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(6, 7)); // 6 rows, 7 columns
        add(boardPanel, BorderLayout.CENTER);

        // Add column selection buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 7));
        for (int i = 0; i < 7; i++) {
            columnButtons[i] = new JButton("Column " + (i + 1));
            columnButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int column = Integer.parseInt(e.getActionCommand()) - 1;
                    if (game.dropPiece(column)) {
                        updateBoard();
                        if (game.checkWinner()) {
                            updateStatus(game.getCurrentPlayer() + " wins!");
                            if (game.getCurrentPlayer().equals("Red")) redWins++;
                            else blueWins++;
                            updateWins();
                        } else {
                            game.switchPlayer();
                            updateStatus(game.getCurrentPlayer() + " player turn");
                        }
                    }
                }
            });
            panel.add(columnButtons[i]);
        }

        add(panel, BorderLayout.SOUTH);

        // Status label
        statusLabel = new JLabel("Red player turn");
        add(statusLabel, BorderLayout.NORTH);

        // Wins label
        winsLabel = new JLabel("Red Wins: " + redWins + " | Blue Wins: " + blueWins);
        add(winsLabel, BorderLayout.WEST);
    }

    // Update the board display
    private void updateBoard() {
        boardPanel.removeAll();
        String[][] board = game.getBoard();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                JPanel panel = new JPanel();
                panel.setBackground(board[row][col].equals("Red") ? Color.RED : 
                    board[row][col].equals("Blue") ? Color.BLUE : Color.WHITE);
                panel.setPreferredSize(new Dimension(80, 80));
                boardPanel.add(panel);
            }
        }
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    // Update status label
    private void updateStatus(String status) {
        statusLabel.setText(status);
    }

    // Update wins label
    private void updateWins() {
        winsLabel.setText("Red Wins: " + redWins + " | Blue Wins: " + blueWins);
    }
}
