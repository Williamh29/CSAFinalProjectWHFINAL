import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minesweeper implements ActionListener {
    private int count = 0;
    private int gold = 1000000;
    private JPanel textPanel;
    private JFrame frame;
    private JPanel buttonPanel;
    private JButton[][] buttons;
    JLabel textfield;

    int size;
    int bombs;
    Random random;

    ArrayList<Integer> xPositions;
    ArrayList<Integer> yPositions;
    public Minesweeper() {
        xPositions = new ArrayList<Integer>();
        yPositions = new ArrayList<Integer>();
        size = 10;
        bombs = 10;

        random = new Random();
        for (int i = 0; i < bombs; i++) {
            xPositions.add(random.nextInt(size));
            yPositions.add(random.nextInt(size));
        }

        for (int i = 0; i < bombs; i++) {
            for (int j = i + 1; j < bombs; j++) {
                if (xPositions.get(i) == xPositions.get(j) && yPositions.get(i) == yPositions.get(j)) {
                    xPositions.set(j, random.nextInt(size));
                    yPositions.set(j, random.nextInt(size));

                    i =0;
                    j =0; //resetting count to check again through the arraylist
                }
            }
        }
        for (int i = 0; i < bombs; i++) {
            System.out.println("xPositions of "+i+" is"+xPositions.get(i));
            System.out.println("yPositions of "+i+" is"+yPositions.get(i));
        }
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends process of java platform when cross button is pressed
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
        textfield.setForeground(Color.BLUE);
        // panel = new JPanel();
//        frame = new JFrame();
//
//        //frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Treasure Hunt");
//        frame.setSize(500, 500);
//        //frame.pack();
//        frame.setLayout(new GridLayout(4,4,8,8));
//        JButton square1 = new JButton("1");
//        frame.add(square1);
//        square1.addActionListener(this);
//        JButton square2 = new JButton("2");
//        frame.add(square2);
//        JButton square3 = new JButton("3");
//        frame.add(square3);
//        JButton square4 = new JButton("4");
//        frame.add(square4);
//        JButton square5 = new JButton("5");
//        frame.add(square5);
//        JButton square6 = new JButton("6");
//        frame.add(square6);
//        JButton square7 = new JButton("7");
//        frame.add(square7);
//        JButton square8 = new JButton("8");
//        frame.add(square8);
//        JButton square9 = new JButton("9");
//        frame.add(square9);
//        JButton square10 = new JButton("10");
//        frame.add(square10);
//        JButton square11 = new JButton("11");
//        frame.add(square11);
//        JButton square12 = new JButton("12");
//        frame.add(square12);
//        JButton square13 = new JButton("13");
//        frame.add(square13);
//        JButton square14 = new JButton("14");
//        frame.add(square14);
//        JButton square15 = new JButton("15");
//        frame.add(square15);
//        JButton square16 = new JButton("16");
//        frame.add(square16);
//
//        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        textfield.setText("Number of clicks: " + count);
        gold-=10000;

    }
}
