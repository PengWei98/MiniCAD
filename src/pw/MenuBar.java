package pw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.ArrayList;

public class MenuBar extends JMenuBar {
    JMenu file = new JMenu("file");
    JMenuItem save = new JMenuItem("save");
    JMenuItem open = new JMenuItem("open");

    MenuBar(Canvas canvas){
        add(file);

        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "";
                JFileChooser chooser = new JFileChooser("./");
                chooser.showSaveDialog(null);
                File file =chooser.getSelectedFile();
                fileName = file.getPath();
                if(!fileName.equals("")) {
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
                        out.writeObject(canvas.shapes);
                        out.close();
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "";
                JFileChooser fileChooser = new JFileChooser("./");
//                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fileChooser.showOpenDialog(fileChooser);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    fileName = fileChooser.getSelectedFile().getAbsolutePath();
                }
                if(!fileName.equals("")){
                    try
                    {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
                        canvas.shapes = (ArrayList<Shape>) ois.readObject();
                        canvas.repaint();

                    } catch (Exception error)
                    {
                        error.printStackTrace();
                    }
                }
            }
        });
        file.add(open);
    }
}
