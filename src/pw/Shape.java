package pw;


import java.awt.*;

public abstract class Shape implements java.io.Serializable {
    int x1, x2, y1, y2;
    float width;
    Color color;
    int xs[] = new int[10];
    int ys[] = new int[10];
    int points = 0;

    void init(int x, int y){
        x1 = x;
        y1 = y;
    }
    abstract void draw(int x, int y, Graphics g);
    abstract void draw(Graphics g);
    void setColor(Color color){
        this.color = color;
    }

    abstract void highlight(Graphics g);
    abstract Point getPosition();
    void setWidth(float width){
        this.width = width;
    }
}

class Line extends Shape{

    @Override
    public void draw(int x, int y, Graphics g){
        x2 = x;
        y2 = y;

        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    @Override
    public Point getPosition(){
        Point p = new Point((x1 + x2) /2, (y1 + y2)/2);
        return p;
    }
}

class Rect extends Shape{
    boolean filled = false;

    @Override
    public void draw(int x, int y, Graphics g){
        x2 = x;
        y2 = y;

        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        if(filled){
            g2.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        else {
            g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void draw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        if(filled){
            g2.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        else {
            g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    @Override
    public Point getPosition(){
        Point p = new Point((x1 + x2) /2, (y1 + y2)/2);
        return p;
    }
}

class Elli extends Shape{
    boolean filled = false;

    @Override
    public void draw(int x, int y, Graphics g){
        x2 = x;
        y2 = y;

        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        if(filled){
            g2.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        else{
            g2.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void draw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        if(filled){
            g2.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        else{
            g2.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    @Override
    public Point getPosition(){
        Point p = new Point((x1 + x2) /2, (y1 + y2)/2);
        return p;
    }
}

class Text extends Shape{
    String text = new String("");

    @Override
    public void draw(int x, int y, Graphics g){
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);

        g2.setColor(color);
        int size = 1;
        if(x2 == 0 && y2 == 0){
            g2.setFont(new Font ("SansSerif", Font.BOLD, 16));
            FontMetrics fm = g2.getFontMetrics();
            x2 = x1 + fm.stringWidth(text);
            y2 = y1 + fm.getAscent();
        }
        else{
            int textWidth = Math.abs(x2 - x1);

            g2.setFont(new Font ("SansSerif", Font.BOLD, size));
            FontMetrics fm = g2.getFontMetrics();
            while(fm.stringWidth(text) < textWidth ){
                size++;
                g2.setFont(new Font ("SansSerif", Font.BOLD, size));
                fm = g2.getFontMetrics();
            }
        }
        FontMetrics fm2 = g2.getFontMetrics();
        g2.drawString(text, Math.min(x1, x2), Math.min(y1, y2) + fm2.getAscent());
    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    @Override
    public Point getPosition(){
        Point p = new Point((x1 + x2) /2, (y1 + y2)/2);
        return p;
    }
}

class Polygon extends Shape{
    @Override
    public void draw(int x, int y, Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolyline(xs, ys, points);
    }

    @Override
    public void draw(Graphics g){
        x1 = 10000;
        y1 = 10000;
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolygon(xs, ys, points);
    }

    @Override
    public void init(int x, int y) {

    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolygon(xs, ys, points);
    }

    @Override
    public Point getPosition(){
        int sumX=0;
        int sumY=0;
        for(int x : xs){
            sumX += x;
        }
        for(int y: ys){
            sumY += y;
        }
        Point p = new Point(sumX/points,sumY/points);
        return p;
    }
}

class Polyline extends Shape{
    @Override
    public void draw(int x, int y, Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolyline(xs, ys, points);
    }

    @Override
    public void draw(Graphics g){
        x1 = 10000;
        y1 = 10000;
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 1, 0, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolyline(xs, ys, points);
    }

    @Override
    public void init(int x, int y) {

    }

    @Override
    public void highlight(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Stroke dash = new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 3.5f, new float[] { 15, 10, },
                0f);
        g2.setStroke(dash);
        g2.setColor(color);
        g2.drawPolyline(xs, ys, points);
    }

    @Override
    public Point getPosition(){
        int sumX=0;
        int sumY=0;
        for(int x : xs){
            sumX += x;
        }
        for(int y: ys){
            sumY += y;
        }
        Point p = new Point(sumX/points,sumY/points);
        return p;
    }
}
