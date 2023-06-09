import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class ClickColors implements ActionListener {
    private static int count = 0;
    private JPanel textPanel;
    private JFrame frame;
    private static JPanel buttonPanel;
    private JButton[][] buttons;
    static JLabel textfield;
    private int x;
    private int y;

    int size;
    static int score = 0;
    int treasure = 0;
    Random random;


    ArrayList<Integer> xPositions;
    ArrayList<Integer> yPositions;
    public static void setScore() {
        if (textfield != null) {
            textfield.setText("Score = " + score + " Timer = " + Timer.seconds + " Clicks: " + count);
        }
    }
    public static void gameOver(){
        textfield.setText("Game Over. Your score was " + score);
        buttonPanel.setVisible(false);
    }
    public ClickColors() {
        Timer minuteTime = new Timer();
        Thread myThread = new Thread(minuteTime);
        myThread.start();
        xPositions = new ArrayList<Integer>();
        yPositions = new ArrayList<Integer>();
        size = 10;
        treasure = 10;

        random = new Random();
        for (int i = 0; i < treasure; i++) {
            xPositions.add(random.nextInt(size));
            yPositions.add(random.nextInt(size));
        }

        for (int i = 0; i < treasure; i++) {
            for (int j = i + 1; j < treasure; j++) {
                if (xPositions.get(i) == xPositions.get(j) && yPositions.get(i) == yPositions.get(j)) {
                    xPositions.set(j, random.nextInt(size));
                    yPositions.set(j, random.nextInt(size));

                    i =0;
                    j =0;
                }
            }
        }
        for (int i = 0; i < treasure; i++) {
            System.out.println("xPositions of "+i+" is"+xPositions.get(i));
            System.out.println("yPositions of "+i+" is"+yPositions.get(i));
        }
        frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setVisible(true);
        textPanel.setBackground(Color.BLACK);

        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(new GridLayout(size, size));

        textfield = new JLabel();
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setFont(new Font ("MV Boli", Font.BOLD, 20));
        textfield.setForeground(Color.YELLOW);
        x = ThreadLocalRandom.current().nextInt(0, 10);
        y = ThreadLocalRandom.current().nextInt(0, 10);

        buttons = new JButton[size][size];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 12));
                buttons[i][j].addActionListener(this);
                buttons[i][j].setText("");
                if (x == i && y == j) {
                    buttons[i][j].setBackground(Color.RED);
                } else {
                    buttons[i][j].setBackground(Color.BLUE);
                }
                buttonPanel.add(buttons[i][j]);
            }
        }
        textPanel.add(textfield);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if (e.getSource() == buttons[x][y]) {
            score++;
            buttons[x][y].setBackground(Color.BLUE);
            x = ThreadLocalRandom.current().nextInt(0, 10);
            y = ThreadLocalRandom.current().nextInt(0, 10);
            buttons[x][y].setBackground(Color.RED);
        } else {
            score--;
        }
    }
}