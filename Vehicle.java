// Vehicle.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Abstract class for Vehicles.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.image.ImageObserver;

public abstract class Vehicle{


	public abstract void move_right();

	public abstract void move_left();

	public abstract void move_up();

	public abstract void move_down();

	public abstract int getX();

	public abstract void setX(int x);

	public abstract void setDX(int xalter);

	public abstract void setDY(int yalter);
	
	public abstract int getY();

	public abstract void setY(int y);

	public abstract int getWidth();
    
    public abstract int getHeight();

    public abstract Image setImage(Image img);

    public abstract void setImagefromDir(String dir);

    public abstract Image getImage();

    public abstract void draw(Graphics g, boolean isCurrent, ImageObserver obs);

    public abstract void tickmove();

    public abstract void setDir(String s);

    public abstract Rectangle getBounds();

    public abstract void setVisible(Boolean visible);

    public abstract boolean isVisible();

    public abstract boolean isInside(Point p);

}