package laplanh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JLabel;
import static laplanh.FrameScreen.column;
import static laplanh.FrameScreen.row;
import static laplanh.FrameScreen.arr;

public class GameScreen extends JPanel implements ActionListener {

    public static int countY = 0;
    public static int countX = 0;
    public static int count3 = 0;
    public static int countEnd = 0;
    public static int x = 0;
    public static int x1, x2, y1, y2;
    public static int i1, j1, i2, j2;

    JButton button;
    JButton[][] jButton = new JButton[row][column];
    JLabel jLable, jLableEnd;

    public GameScreen() {
//        create2();
        createButton();
        createLable();
    }

    public void createButton() {
        for (int i = 0; i < row; i++) {
            x = i + countY;
            for (int j = 0; j < column; j++) {
                setLayout(null);
                //new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\LapLanh\\image\\hoicham.jpg")
                jButton[i][j] = new JButton();
                add(jButton[i][j]);
                jButton[i][j].setBackground(Color(51, 51, 51));
                jButton[i][j].setBounds(j + countX + 377, x + 150, 110, 110);
                jButton[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                jButton[i][j].setActionCommand(Integer.toString(i) + "" + Integer.toString(j));
                jButton[i][j].addActionListener(this);
                countX += 112;
            }
            countY += 112;
            countX = 0;
        }
    }

    public void create2() {

        JButton button = new JButton(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\LapLanh\\image\\cho1.jpg"));
        add(button);
        setLayout(null);
        button.setBounds(10, 40, 50, 50);

    }

    public void createLable() {
        jLable = new JLabel("Game A");
        jLableEnd = new JLabel("Victory");
        add(jLable);
        jLable.setBounds(468, 15, 300, 100);
        jLable.setFont(new Font("Arial", Font.BOLD, 70));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((Integer.toString(i) + "" + Integer.toString(j)).equals(ae.getActionCommand())) {
                    jButton[i][j].setText(Integer.toString(arr[i][j]));
                    jButton[i][j].setEnabled(false);
                    count3++;
                    if (count3 == 1) {
                        i1 = i;
                        j1 = j;
                    }
                    if (count3 == 2) {
                        i2 = i;
                        j2 = j;
                    }
                    if (count3 == 3) {
                        boolean result = check(arr[i1][j1], arr[i2][j2]);
                        if (result == false) {
                            jButton[i1][j1].setEnabled(true);
                            jButton[i2][j2].setEnabled(true);
                            jButton[i2][j2].setEnabled(true);
                            jButton[i1][j1].setText("");
                            jButton[i2][j2].setText("");
                        } else {
                            jButton[i1][j1].setEnabled(false);
                            jButton[i2][j2].setEnabled(false);
                            countEnd++;
                            if (countEnd == 7) {
                                add(jLableEnd);
                                jLableEnd.setBounds(468, 620, 300, 100);
                                jLableEnd.setFont(new Font("Arial", Font.BOLD, 70));
                            }
                            System.out.println("countEnd = " + countEnd);
                        }
                        i1 = i;
                        j1 = j;
                        count3 = 1;
                    }
                }
            }
        }
    }

    static boolean check(int a, int b) {
        boolean result;
        if (a == b) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    private Color Color(int a1, int a2, int a3) {
        Color a = new Color(a1, a2, a3);
        return a;
    }
//
//    static boolean endGame() {
//        boolean result;
//        System.out.println(countEnd);
//        if (countEnd == 8) {
//            result = true;
//
//        } else {
//            result = false;
//        }
//        return result;
//    }
}

//bug cần giải quyết: không click được 

