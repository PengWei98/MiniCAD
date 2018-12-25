package pw;

import javax.swing.*;

public class MiniCAD{

    private JFrame frame = new JFrame("MiniCAD");
    private Canvas panel = new Canvas();
    private StatusBar statusBar = new StatusBar(panel);
    private MenuBar menuBar = new MenuBar(panel);


    private void showGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setSize(900, 500);
        // Center the frame
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(panel);

        frame.add(statusBar);

        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        MiniCAD miniCAD = new MiniCAD();
        miniCAD.showGUI();
    }
}