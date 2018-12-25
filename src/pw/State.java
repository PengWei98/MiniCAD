package pw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public abstract class State {
    abstract void pressMouse(Canvas canvas, MouseEvent e);
    abstract void releaseMouse(Canvas canvas, MouseEvent e);
    abstract void dragMouse(Canvas canvas, MouseEvent e);
    abstract void clickMouse(Canvas canvas,MouseEvent e);
}


class idle extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }
}

class lineChosen extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){
        canvas.chosenShape = null;
        canvas.initX = e.getX();
        canvas.initY = e.getY();
        canvas.currentShape = new Line();
        canvas.currentShape.setColor(canvas.color);
        canvas.currentShape.setWidth(canvas.width);
        canvas.currentShape.init(canvas.initX, canvas.initY);
    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){
        if((((Line)canvas.currentShape).x1 != 0 && ((Line)canvas.currentShape).y1 != 0) && (((Line)canvas.currentShape).x2 != 0 && ((Line)canvas.currentShape).y2 != 0)){
            canvas.shapes.add(canvas.currentShape);
        }
        canvas.currentShape = null;
    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){
        canvas.currX = e.getX();
        canvas.currY = e.getY();
        canvas.repaint();
    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }
}

//
class rectChosen extends State{
    boolean filled = false;
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){
        canvas.chosenShape = null;
        canvas.initX = e.getX();
        canvas.initY = e.getY();
        canvas.currentShape = new Rect();
        if(filled){
            ((Rect) canvas.currentShape).filled = true;
        }
        canvas.currentShape.setColor(canvas.color);
        canvas.currentShape.setWidth(canvas.width);
        canvas.currentShape.init(canvas.initX, canvas.initY);
    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){
        if(((Rect)canvas.currentShape).x1 != 0 && ((Rect)canvas.currentShape).y1 != 0 && ((Rect)canvas.currentShape).x2 != 0 && ((Rect)canvas.currentShape).y2 != 0){
            canvas.shapes.add(canvas.currentShape);
        }
        canvas.currentShape = null;
    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){
        canvas.currX = e.getX();
        canvas.currY = e.getY();
        canvas.repaint();
    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }
}

class elliChosen extends State{
    boolean filled = false;
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){
        canvas.chosenShape = null;
        canvas.initX = e.getX();
        canvas.initY = e.getY();
        canvas.currentShape = new Elli();
        if(filled){
            ((Elli) canvas.currentShape).filled = true;
        }
        canvas.currentShape.setColor(canvas.color);
        canvas.currentShape.setWidth(canvas.width);
        canvas.currentShape.init(canvas.initX, canvas.initY);
    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){
        if(((Elli)canvas.currentShape).x1 != 0 && ((Elli)canvas.currentShape).y1 != 0 && ((Elli)canvas.currentShape).x2 != 0 && ((Elli)canvas.currentShape).y2 != 0){
            canvas.shapes.add(canvas.currentShape);
        }
        canvas.currentShape = null;
//        ((Elli)canvas.currentShape).x1 = 0;
//        ((Elli)canvas.currentShape).x2 = 0;
    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){
        canvas.currX = e.getX();
        canvas.currY = e.getY();
        canvas.repaint();
    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }
}

class polygonChosen extends State{

    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){
        canvas.chosenShape = null;
        if(canvas.currentShape == null){
            canvas.currentShape = new Polygon();
            canvas.currentShape.setColor(canvas.color);
            canvas.currentShape.setWidth(canvas.width);
        }

        int []xs = ((Polygon)canvas.currentShape).xs;
        int []ys = ((Polygon)canvas.currentShape).ys;

        if(e.getClickCount() == 1) {
            xs[((Polygon) canvas.currentShape).points] = e.getX();
            ys[((Polygon) canvas.currentShape).points] = e.getY();
            ((Polygon) canvas.currentShape).points++;
            if ((((Polygon) canvas.currentShape).points) > 1) {
                //drawline
                canvas.repaint();
            }
        }
        if(e.getClickCount() == 2){
            xs[((Polygon)canvas.currentShape).points] = e.getX();
            ys[((Polygon)canvas.currentShape).points] = e.getY();
            ((Polygon)canvas.currentShape).points++;
            canvas.shapes.add(canvas.currentShape);
            canvas.currentShape = null;
            canvas.repaint();
        }
    }
}

class polylineChosen extends State{

    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){
        canvas.chosenShape = null;
        if(canvas.currentShape == null){
            canvas.currentShape = new Polyline();
            canvas.currentShape.setColor(canvas.color);
            canvas.currentShape.setWidth(canvas.width);
        }

        int []xs = ((Polyline)canvas.currentShape).xs;
        int []ys = ((Polyline)canvas.currentShape).ys;

        if(e.getClickCount() == 1) {
            xs[((Polyline) canvas.currentShape).points] = e.getX();
            ys[((Polyline) canvas.currentShape).points] = e.getY();
            ((Polyline) canvas.currentShape).points++;
            if ((((Polyline) canvas.currentShape).points) > 1) {
                //drawline
                canvas.repaint();
            }
        }
        if(e.getClickCount() == 2){
            xs[((Polyline)canvas.currentShape).points] = e.getX();
            ys[((Polyline)canvas.currentShape).points] = e.getY();
            ((Polyline)canvas.currentShape).points++;
            canvas.shapes.add(canvas.currentShape);
            canvas.currentShape = null;
            canvas.repaint();
        }
    }
}

class textChosen extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){
        canvas.chosenShape = null;
        canvas.initX = e.getX();
        canvas.initY = e.getY();
        canvas.currentShape = new Text();
        canvas.currentShape.setColor(canvas.color);
        canvas.currentShape.setWidth(canvas.width);
        canvas.currentShape.init(canvas.initX, canvas.initY);

        JFrame textFrame = new JFrame("Please input your text:");
        textFrame.setLayout(null);
        textFrame.setSize(400, 150);
        // Center the frame
        textFrame.setLocationRelativeTo(null);
        textFrame.setResizable(false);
        JTextField textField = new JTextField();
        textField.setSize(300,30);
        textField.setLocation(50,20);

        JButton OK = new JButton("OK");
        OK.setSize(50,30);
        OK.setLocation(175,80);
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                ((Text)canvas.currentShape).text = text;
                canvas.shapes.add(canvas.currentShape);
                canvas.currentShape = null;
                textFrame.dispose();
                canvas.repaint();
            }
        });

        textFrame.add(textField);
        textFrame.add(OK);
        textFrame.setVisible(true);
    }
}

class choosing extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){
        canvas.currentShape = null;
        Shape shape = choose(canvas, e);
        canvas.chosenShape = shape;
        canvas.repaint();
        if(e.getClickCount() == 2 && shape instanceof Text){
            JFrame textFrame = new JFrame("Please input your text:");
            textFrame.setLayout(null);
            textFrame.setSize(400, 150);
            // Center the frame
            textFrame.setLocationRelativeTo(null);
            textFrame.setResizable(false);
            JTextField textField = new JTextField();
            textField.setSize(300,30);
            textField.setLocation(50,20);

            JButton OK = new JButton("OK");
            OK.setSize(50,30);
            OK.setLocation(175,80);
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    ((Text)shape).text = text;
                    textFrame.dispose();
                    canvas.repaint();
                }
            });

            textFrame.add(textField);
            textFrame.add(OK);
            textFrame.setVisible(true);
        }
    }

    Shape choose(Canvas canvas, MouseEvent e){
        for(Shape shape : canvas.shapes){
            if(Math.abs(shape.getPosition().x - e.getX()) < 50 && Math.abs(shape.getPosition().y - e.getY()) < 50){
                return shape;
            }
        }
        return null;
    }
}

class moving extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){
        canvas.currentShape = null;
        //to do :if no shape are chosen
        if(canvas.chosenShape ==  null){
            JOptionPane.showMessageDialog(null, "No shape is chosen!");
        }
    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){
        Shape shape = canvas.chosenShape;
        if(shape != null){
            //it is not a polygon or a polyline
            if(shape.x1 != 10000) {
                canvas.initX = e.getX();
                canvas.initY = e.getY();
                int width = Math.abs(canvas.chosenShape.x2 - canvas.chosenShape.x1);
                int length = Math.abs(canvas.chosenShape.y2 - canvas.chosenShape.y1);
                canvas.chosenShape.init(canvas.initX, canvas.initY);
                canvas.chosenShape.x2 = canvas.initX + width;
                canvas.chosenShape.y2 = canvas.initY + length;
            }
            //it is a polygon or a polyline
            else{
                int disX[] = new int[shape.points];
                int disY[] = new int[shape.points];
                for(int i = 0; i < shape.points; i++){
                    disX[i] = shape.xs[i] - shape.xs[0];
                    disY[i] = shape.ys[i] - shape.ys[0];
                }
                shape.xs[0] = e.getX();
                shape.ys[0] = e.getY();
                for(int i = 1; i < shape.points; i++){
                    shape.xs[i] = shape.xs[0] + disX[i];
                    shape.ys[i] = shape.ys[0] + disY[i];
                }
            }
        }

        canvas.repaint();
    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }

}

class resizing extends State{
    @Override
    public void pressMouse(Canvas canvas, MouseEvent e){
        canvas.currentShape = null;
        //to do :if no shape are chosen
        if(canvas.chosenShape ==  null){
            JOptionPane.showMessageDialog(null, "No shape is chosen!");
        }
    }

    @Override
    public void releaseMouse(Canvas canvas, MouseEvent e){

    }

    @Override
    public void dragMouse(Canvas canvas, MouseEvent e){
        Shape shape = canvas.chosenShape;
        if(shape != null){
            canvas.chosenShape.x2 = e.getX();
            canvas.chosenShape.y2 = e.getY();
        }
        canvas.repaint();
    }

    @Override
    public void clickMouse(Canvas canvas,MouseEvent e){

    }
}