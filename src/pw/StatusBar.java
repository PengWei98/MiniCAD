package pw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatusBar extends JLabel {

    Canvas canvas;
    StatusBar(Canvas canvas){
        super();
        this.canvas = canvas;
        setSize(200,500);
        setLocation(0,0);

        JButton line = new JButton("line");
        line.setSize(60,30);
        line.setLocation(0,10);
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new lineChosen();
            }
        });
        add(line);


        JButton rect = new JButton("rect");
        rect.setSize(60,30);
        rect.setLocation(65,10);
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new rectChosen();
            }
        });
        add(rect);

        JButton filledRect = new JButton("filled rect");
        filledRect.setSize(190,30);
        filledRect.setLocation(0,90);
        filledRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new rectChosen();
                ((rectChosen) StatusBar.this.canvas.state).filled = true;
            }
        });
        add(filledRect);

        JButton elli = new JButton("elli");
        elli.setSize(60,30);
        elli.setLocation(130,10);
        elli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new elliChosen();
            }
        });
        add(elli);

        JButton filledElli = new JButton("filled elli");
        filledElli.setSize(190,30);
        filledElli.setLocation(0,120);
        filledElli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new elliChosen();
                ((elliChosen) StatusBar.this.canvas.state).filled = true;
            }
        });
        add(filledElli);

        JButton polygon = new JButton("polygon");
        polygon.setSize(90,30);
        polygon.setLocation(0,35);
        polygon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new polygonChosen();
            }
        });
        add(polygon);

        JButton polyline = new JButton("polyline");
        polyline.setSize(90,30);
        polyline.setLocation(100,35);
        polyline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new polylineChosen();
            }
        });
        add(polyline);

        JButton text = new JButton("text");
        text.setSize(190,30);
        text.setLocation(0,60);
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new textChosen();
            }
        });
        add(text);

        JButton choosing = new JButton("choose");
        choosing.setSize(190,30);
        choosing.setLocation(0,150);
        choosing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new choosing();
            }
        });
        add(choosing);

        JButton mov = new JButton("move");
        mov.setSize(190,30);
        mov.setLocation(0, 180);
        mov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state =  new moving();
            }
        });
        add(mov);

        JButton res = new JButton("resize");
        res.setSize(190,30);
        res.setLocation(0,210);
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.state = new resizing();
            }
        });
        add(res);

        JButton del = new JButton("delete");
        del.setSize(190,30);
        del.setLocation(0,240);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StatusBar.this.canvas.chosenShape != null){
                    StatusBar.this.canvas.shapes.remove(StatusBar.this.canvas.chosenShape);
                    StatusBar.this.canvas.repaint();
                }
                else{
//                    System.out.println("No shape is chosen!");
                    JOptionPane.showMessageDialog(null, "No shape is chosen!");
                }
            }
        });
        add(del);

        JPanel col = new JPanel();
        col.setBackground(canvas.color);
        col.setSize(20,20);
        col.setLocation(10,425);
        col.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame colorFrame = new JFrame("Setting Color");
                colorFrame.setLayout(null);
                colorFrame.setSize(340, 160);
                // Center the frame
                colorFrame.setLocationRelativeTo(null);
                colorFrame.setResizable(false);

                JLabel label = new JLabel("current width : " + canvas.color.toString());
                label.setBounds(0,0,340,50);
                colorFrame.add(label);

                JPanel bla = new JPanel();
                bla.setBackground(Color.black);
                bla.setSize(20,20);
                bla.setLocation(20,60);
                bla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.black);
                        canvas.color = Color.black;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(bla);

                JPanel blu = new JPanel();
                blu.setBackground(Color.blue);
                blu.setSize(20,20);
                blu.setLocation(60,60);
                blu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.blue);
                        canvas.color = Color.blue;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(blu);

                JPanel red = new JPanel();
                red.setBackground(Color.red);
                red.setSize(20,20);
                red.setLocation(100,60);
                red.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.red);
                        canvas.color = Color.red;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(red);

                JPanel yel = new JPanel();
                yel.setBackground(Color.yellow);
                yel.setSize(20,20);
                yel.setLocation(140,60);
                yel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.yellow);
                        canvas.color = Color.yellow;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(yel);

                JPanel gre = new JPanel();
                gre.setBackground(Color.green);
                gre.setSize(20,20);
                gre.setLocation(180,60);
                gre.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.green);
                        canvas.color = Color.green;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(gre);

                JPanel ora = new JPanel();
                ora.setBackground(Color.orange);
                ora.setSize(20,20);
                ora.setLocation(220,60);
                ora.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.orange);
                        canvas.color = Color.orange;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(ora);

                JPanel pin = new JPanel();
                pin.setBackground(Color.pink);
                pin.setSize(20,20);
                pin.setLocation(260,60);
                pin.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.pink);
                        canvas.color = Color.pink;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(pin);

                JPanel gra = new JPanel();
                gra.setBackground(Color.GRAY);
                gra.setSize(20,20);
                gra.setLocation(300,60);
                gra.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        col.setBackground(Color.gray);
                        canvas.color = Color.gray;
                        label.setText("current width : " + canvas.color.toString());
                    }
                });
                colorFrame.add(gra);

                JButton OK = new JButton("OK");
                OK.setSize(60,30);
                OK.setLocation(140,100);
                OK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        colorFrame.dispose();
                    }
                });
                colorFrame.add(OK);

                colorFrame.setVisible(true);
            }
        });
        add(col);

        JButton wid = new JButton("mid-width");
        wid.setSize(190,30);
        wid.setLocation(0,390);
        wid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame widthFrame = new JFrame("Setting Width");
                widthFrame.setLayout(null);
                widthFrame.setSize(400, 180);
                // Center the frame
                widthFrame.setLocationRelativeTo(null);
                widthFrame.setResizable(false);

                JLabel label = new JLabel("current width : " + wid.getText());
                label.setBounds(30,0,200,50);
                widthFrame.add(label);

                JButton thin = new JButton("thin");
                thin.setSize(90,30);
                thin.setLocation(10,60);
                thin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.width = 0.5f;
                        wid.setText("thin");
                        label.setText("current width : " + wid.getText());
                    }
                });
                widthFrame.add(thin);


                JButton medium = new JButton("mid-width");
                medium.setSize(90,30);
                medium.setLocation(150,60);
                medium.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.width = 1.0f;
                        wid.setText("mid-width");
                        label.setText("current width : " + wid.getText());
                    }
                });
                widthFrame.add(medium);

                JButton thick = new JButton("thick");
                thick.setSize(90,30);
                thick.setLocation(290,60);
                thick.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.width = 1.5f;
                        wid.setText("thick");
                        label.setText("current width : " + wid.getText());
                    }
                });
                widthFrame.add(thick);

                JButton OK = new JButton("OK");
                OK.setSize(60,30);
                OK.setLocation(180,120);
                OK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        widthFrame.dispose();
                    }
                });
                widthFrame.add(OK);

                widthFrame.setVisible(true);
            }
        });
        add(wid);

        JButton changeCol = new JButton("change to current color");
        changeCol.setSize(190,30);
        changeCol.setLocation(0,290);
        changeCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StatusBar.this.canvas.chosenShape != null){
                    StatusBar.this.canvas.chosenShape.setColor(StatusBar.this.canvas.color);
                    StatusBar.this.canvas.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No shape is chosen!");
                }
            }
        });
        add(changeCol);

        JButton changeWid = new JButton("change to current width");
        changeWid.setSize(190,30);
        changeWid.setLocation(0,320);
        changeWid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StatusBar.this.canvas.chosenShape != null){
                    StatusBar.this.canvas.chosenShape.setWidth(StatusBar.this.canvas.width);
                    StatusBar.this.canvas.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No shape is chosen!");
                }
            }
        });
        add(changeWid);

        JButton clear = new JButton("clear");
        clear.setSize(190,30);
        clear.setLocation(0,350);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatusBar.this.canvas.shapes.clear();
                StatusBar.this.canvas.repaint();
            }
        });
        add(clear);
    }
}
