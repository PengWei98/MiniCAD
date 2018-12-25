package pw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Canvas extends JPanel {
    ArrayList<Shape> shapes;

    Shape currentShape;

    Shape chosenShape;

    int initX, initY;
    int currX, currY;
    Color color = Color.BLACK;
    float width = 1.0f;
    State state = new idle();

    Canvas(){
        setBackground(Color.WHITE);
        setSize(700, 500);
        setLocation(200,0);
        shapes = new ArrayList<>();
        currentShape = null;
        chosenShape = null;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                state.pressMouse(Canvas.this, e);
            }

            @Override
            public void mouseReleased(MouseEvent e){
                state.releaseMouse(Canvas.this, e);
            }

            @Override
            public void mouseClicked(MouseEvent e){
                state.clickMouse(Canvas.this, e);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                state.dragMouse(Canvas.this, e);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(Shape shape : shapes){
            shape.draw(g);
//            shape.highlight(g);
            if(shape == chosenShape){
               shape.highlight(g);
            }
        }
        if(currentShape != null){
            currentShape.draw(currX, currY, g);
        }
    }
}
