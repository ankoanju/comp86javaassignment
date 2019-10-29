// Canvas.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// This creates a drawing, namely a grid. 
// Also provides the location when the user clicks. 

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.Timer;
import java.awt.Image;
import javax.swing.ImageIcon;


//Canvas object
public class Canvas extends JPanel implements MouseListener {

    private Model model;
    private Draw parent;
    private Color color;
    private Point p;

    public Canvas(Draw parent) {
        this.parent = parent;
        initiateCanvas();
    }

    public void initiateCanvas(){

        Timer timer = new Timer(700, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                revalidate();
                repaint();
            }
        });

        timer.start();

	    addMouseListener (this);
    }

    // Tell parent to do the job
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create the road background
        int w = getSize().width;
        int h = getSize().height;

        Graphics2D g3 = (Graphics2D) g;
        g3.setColor (color.GRAY);
        g3.fillRoundRect(0,0, w, h, 30, 30);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor (color.GREEN);
        g.fillRoundRect(w/8, h/6, w - (w/4) , h - (h/3), 30, 30);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor (color.BLACK);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(w/16, h/12, w/16, h - (h/12));
        g2d.drawLine(w/16, h - h/12, w- w/16, h - (h/12));
        g2d.drawLine(w - w/16, h - (h/12), w - (w/16), h/12);
        g2d.drawLine(w - w/16, (h/12), (w/16), h/12); 

        // Draw bus
        parent.draw_on(g);


    }
    
    
    // MouseListener callbacks
    public void mousePressed (MouseEvent event) {
        System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
        p = event.getPoint();
        parent.mouse_on(p);
        
    }

    public Point current_p(){
        return p;
    }

    // Since MouseListener defines all of the below, we have to supply them (even empty)
    public void mouseReleased (MouseEvent event) {}
    public void mouseClicked (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}

}