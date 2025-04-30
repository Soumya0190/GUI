# GUI
https://canvas.eee.uci.edu/courses/21534/assignments/401811

---

### **Lab 4 Project Description: GUI for ConnectFour Game**

This project involves creating a GUI (Graphical User Interface) for the **ConnectFour** game, incorporating Swing components, and integrating with your existing **ConnectFour** code. The GUI will allow users to interact with the game visually, making it a more user-friendly experience. 

Below is a breakdown of the requirements and how you can implement the solution:

---

### **Project Requirements & Implementation Steps**

#### 1. **Frame Setup**
- You need a JFrame that will hold the ConnectFour game board and the related components.
- The title of the window must include your **UCINetID** and the name of the game (e.g., `khermans - ConnectFour`).
- **JFrame** will hold all the Swing elements (buttons, labels, etc.).

```java
import javax.swing.*;

public class Lab4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectFourFrame frame = new ConnectFourFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
```

#### 2. **Menu Bar**
- You must create a menu bar at the top of the JFrame with the following options:
    - **Undo last move**
    - **Start a new game**
    - **Load a game from a text file**
    - **Save the current game to a text file**

To implement this, you will use `JMenuBar`, `JMenu`, and `JMenuItem` classes.

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFourFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem undoMenuItem, newGameMenuItem, loadGameMenuItem, saveGameMenuItem;

    public ConnectFourFrame() {
        setTitle("khermans - ConnectFour");
        setSize(700, 600);
        setLocationRelativeTo(null); // center the window

        // Create the menu bar
        menuBar = new JMenuBar();
        menu = new JMenu("Game");

        undoMenuItem = new JMenuItem("Undo Last Move");
        newGameMenuItem = new JMenuItem("New Game");
        loadGameMenuItem = new JMenuItem("Load Game");
        saveGameMenuItem = new JMenuItem("Save Game");

        // Add action listeners
        undoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoMove();
            }
        });
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
        loadGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });
        saveGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });

        // Add items to the menu
        menu.add(undoMenuItem);
        menu.add(newGameMenuItem);
        menu.add(loadGameMenuItem);
        menu.add(saveGameMenuItem);

        // Add the menu to the menu bar
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    // Action methods for the menu items
    private void undoMove() {
        // Logic to undo the last move in the game
    }

    private void startNewGame() {
        // Logic to start a new game
    }

    private void loadGame() {
        // Logic to load the game from a text file
    }

    private void saveGame() {
        // Logic to save the current game to a text file
    }
}
```

#### 3. **Game Status Labels**
- Display a **status label** that shows information about whose turn it is or if there is a winner.
- You will need a JLabel that updates during the game (e.g., `"Red player turn"`, `"Blue player wins"`, etc.).

```java
private JLabel statusLabel;

public ConnectFourFrame() {
    // Initialize label
    statusLabel = new JLabel("Red player turn");
    add(statusLabel, BorderLayout.SOUTH);
}
```

#### 4. **Wins Per Player**
- Display a second **label** that shows how many games each player has won.

```java
private JLabel winsLabel;
private int redWins = 0;
private int blueWins = 0;

public ConnectFourFrame() {
    winsLabel = new JLabel("Red Wins: " + redWins + " | Blue Wins: " + blueWins);
    add(winsLabel, BorderLayout.NORTH);
}
```

#### 5. **Buttons for Column Selection**
- Create **6 buttons** for each of the 6 columns.
- These buttons should allow the players to select which column they want to drop their piece in.
- If a column is full, the button should be **disabled** (greyed out).

```java
private JButton[] columnButtons = new JButton[7];

public ConnectFourFrame() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 7)); // 7 buttons for the 7 columns

    for (int i = 0; i < 7; i++) {
        columnButtons[i] = new JButton("Column " + (i + 1));
        columnButtons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to drop the piece in the column
            }
        });
        panel.add(columnButtons[i]);
    }

    add(panel, BorderLayout.NORTH);
}
```

#### 6. **Game Board Representation**
- Create a panel that visually represents the **ConnectFour** game board.
- You can use circles or any other shapes to represent the player's pieces. Color these shapes to distinguish between the players.

```java
private JPanel boardPanel;

public ConnectFourFrame() {
    boardPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Logic to draw the Connect Four grid
        }
    };
    add(boardPanel, BorderLayout.CENTER);
}
```

---

### **Additional Requirements**

#### Undo Last Move
- The `undoMove()` method should allow the user to undo the last move. This can be achieved by keeping track of the history of moves and reversing the last one.

#### Load/Save Game
- **Load Game**: Implement logic to load the game state (board configuration, current player, etc.) from a text file.
- **Save Game**: Implement logic to save the current game state into a text file.

For the **file operations**, you will need to use Java’s **File I/O** classes like `FileReader`, `FileWriter`, and `BufferedReader`.

---

### **Final Steps**
1. **Organize the Files**:
    - Make sure to include all necessary files (like the game logic classes, `Lab4.jar`, and the Java files).
    - Follow the folder structure `IDNUMBER_UCINETID_Lab4`.

2. **Testing**:
    - Ensure that the GUI responds correctly to user interactions.
    - Verify that game states (undo, load, save) are functioning correctly.
    - Test the win conditions and make sure the board updates in real-time.

3. **Submission**:
    - Zip the folder containing all your files and submit as per the instructions.

---

This outline covers all the necessary components for your **ConnectFour** GUI, integrating with the existing game logic.

---

Explanation of Key Components:
ConnectFour.java: Contains the game logic, such as dropping pieces and checking for a winner.

Lab4.java: Main class to initialize the JFrame and integrate the game logic. It includes buttons for player moves, a status bar to display game information, and a board to represent the game visually.

Swing Components: We used Swing components like JButton, JLabel, JPanel, and JMenuBar to create the game interface.

Game Flow: The game alternates between the two players (Red and Blue), updates the board, checks for a winner, and displays the current player and game results.

---

To provide the full Java solution for the ConnectFour game GUI project, I'll break down the code into the necessary Java files based on your requirements. The solution includes three core Java classes:

ConnectFour.java: Contains the game logic for the ConnectFour game. This file contains the game logic, such as managing the game board, checking for a win condition, and making moves.

TicTacToe.java (if it's part of the same project): A placeholder or similar game logic if you plan to extend the application.

Lab4.java: Main entry point that sets up the GUI frame and integrates with the ConnectFour game logic. This file creates the main GUI for the game, including buttons, labels, and handling the game logic.

---

To generate a `Lab4.jar` file for your **ConnectFour** Java project, you first need to compile your Java source files and then package them into a JAR (Java ARchive) file. Below is a complete, step-by-step guide.

---

## ✅ Step-by-Step: Creating `Lab4.jar`

### ✅ 1. **Project Directory Structure**
Assume your files are organized as follows:

```
ConnectFourProject/
├── ConnectFour.java
├── Lab4.java
└── (optional) TicTacToe.java
```

---

### ✅ 2. **Compile All Java Files**

Open a terminal or command prompt and navigate to your project directory:

```bash
cd path/to/ConnectFourProject
```

Then compile all `.java` files:

```bash
javac *.java
```

This creates `.class` files (e.g., `ConnectFour.class`, `Lab4.class`) in the same directory.

---

### ✅ 3. **Create a Manifest File**

Create a text file named `manifest.txt` with the following content to specify the main class (i.e., the one containing `public static void main()`):

```
Main-Class: Lab4
```

> ⚠️ Make sure there is a **newline** at the end of the `manifest.txt` file, or the JAR may not work correctly.

---

### ✅ 4. **Package the JAR**

Use the `jar` command to package everything:

```bash
jar cfm Lab4.jar manifest.txt *.class
```

- `c`: create new JAR
- `f`: specify file name
- `m`: specify manifest file

This creates `Lab4.jar` in your current directory.

---

### ✅ 5. **Run the JAR**

After creating the JAR file, run it like this:

```bash
java -jar Lab4.jar
```

If all goes well, your **ConnectFour GUI** window should launch.

---

### 📝 (Optional) Clean Up

You can delete the `.class` files if you only want to keep the `.java`, `.jar`, and `manifest.txt`:

```bash
rm *.class
```

---

### 🧩 Advanced Tips

- To include resources like images or sounds, create a directory (`resources/`) and use `jar`'s `-C` option.
- You can also create the JAR using an IDE like **Eclipse** or **IntelliJ IDEA**, which handles everything via a GUI.

---

Would you like a `build.sh` or `Makefile` to automate this process?

----

To **run the Java GUI project** for Lab 4 (which includes `TicTacToe.java`, `ConnectFour.java`, and `Lab4.java`), follow the instructions below. This assumes you already have Java installed and your IDE (e.g., IntelliJ, Eclipse, NetBeans, or VS Code) is set up.

---

### ✅ 1. **Ensure Project Structure**
Put these Java files in the same directory:
- `Lab4.java` (contains the GUI main logic)
- `ConnectFour.java` (game logic)
- `TicTacToe.java` (game logic)

---

### ✅ 2. **Compile the Code**
Open a terminal in your project directory and run:

```bash
javac *.java
```

This compiles all Java files in the directory.

---

### ✅ 3. **Run the Program**
Once compiled, run the GUI application:

```bash
java Lab4
```

This will launch the graphical window titled something like:

```
[Your UCINetID] - ConnectFour
```

---

### 🖥️ Sample GUI Run (Expected Behavior)

- **Window Title**: `jdoe123 - ConnectFour`
- **Top Menu Bar**: 
  - `Game` menu with items:
    - `Undo Move`
    - `New Game`
    - `Save Game`
    - `Load Game`
- **Status Label**:
  - Starts with: `"Red player's turn"` (or similar)
  - Updates dynamically based on game status
- **Wins Label**:
  - `"Red Wins: 0 | Blue Wins: 0"` and updates after each game
- **6 Buttons (Top Row)**:
  - Used to drop tokens in columns (e.g., columns A–F)
  - Disable when a column is full
- **Board Grid**:
  - Displays colored tokens: red and blue
  - Updates after each move

---

### 📦 Optional: Create Lab4.jar

To create a `.jar` file for submission:

```bash
jar cfe Lab4.jar Lab4 *.class
```

Then test it with:

```bash
java -jar Lab4.jar
```

---

Would you like me to generate a basic `Lab4.java` GUI code that fits your assignment?
