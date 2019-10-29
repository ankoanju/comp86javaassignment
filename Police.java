// Police.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a police from extending Vehicle class.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.image.ImageObserver;

public class Police extends Vehicle{

	private String name;
	private String direction;
	private int x_pos;
	private int y_pos;
	private int x_move;
	private int y_move;
	private int width;
	private int height;
	private Image image;
	private int dx;
	private int dy;
	private boolean visible;
	
	public Police(){
		
		this.direction = "LEFT";
		this.x_pos = 70;
		this.y_pos = 340;
		this.dx = 20;
		this.dy = 20;
		visible = true;


		if (this.direction == "LEFT"){
			ImageIcon ii = new ImageIcon("tupd_left.png");
			Image im = ii.getImage();
			this.image = im;
			this.direction = "LEFT";	
			this.x_pos = 70;
			this.y_pos = 340;
			this.width = 75;
			this.height = 44;	
			//getWidth();
			//w = im.getWidth(null);
		} else if (this.direction == "RIGHT"){
			ImageIcon ii = new ImageIcon("tupd_right.png");
			Image im = ii.getImage();
			this.image = im;
			this.direction = "RIGHT";
			this.x_pos = 70;
			this.y_pos = 380;
			this.width = 75;
			this.height = 4;
			//h = im.getHeight(null); 
        }

}
	public void move_right(){
		x_pos += dx;
	}

	public void move_left(){
		x_pos -=dx;
	}

	public void move_up(){
		y_pos -= dy;
	}
	public void move_down(){
		y_pos += dy;
	}


	public int getX(){
        return x_pos;
    }

	public void setX(int x){
		x_pos = x;
	}

	// //public void setXratio(int r){
	// 	x_pos += r;

	// }
	public void setDX(int xalter){
		dx = xalter;
	}

	public void setDY(int yalter){
		dy = yalter;
	}
	
	public int getY(){
		return y_pos;
	}

	public void setY(int y){
		y_pos = y;
	}

	public int getWidth(){
		width = 38;
		//width = image.getWidth(null);
        return width;
    }

    
    public int getHeight() {
		height = 22;
		//height = image.getHeight(null);
        return height;
    }    

    public Image setImage(Image img) {
        image = img;
        return image;
    }

    public Image getImage() {
        return image;
    }

    public void setImagefromDir(String dir){
    	if (dir == "RIGHT"){
    		ImageIcon temp = new ImageIcon("tupd_right.png");
    		Image tempi = temp.getImage();
    		setImage(tempi);
    	}else if (dir == "LEFT"){
			ImageIcon temp2 = new ImageIcon("tupd_left.png");
    		Image tempi2 = temp2.getImage();
    		setImage(tempi2);
    	}

    }

    public void draw(Graphics g, boolean isCurrent, ImageObserver obs){
    	Graphics2D g2d = (Graphics2D) g;

    	//if(isCurrent)
        g2d.drawImage(this.getImage(), this.getX(), this.getY(), width, height, obs);

        Toolkit.getDefaultToolkit().sync();	
    }
	
	public void tickmove(){

		System.out.println("X: " + x_pos +  "Y" + y_pos);

		if((x_pos <= 70 || (x_pos > 65 & x_pos < 410)) & (y_pos == 340)){
			setImagefromDir("LEFT");
			this.setDX(20);
			this.move_right();
		}
		if((x_pos > 409 & x_pos < 420) & (y_pos == 400 || y_pos > 25)){
			this.setDY(20);
			this.move_up();
		}
		if((x_pos == 410 || (x_pos < 410 & x_pos > 30)) && (y_pos <= 30)){
			setImagefromDir("RIGHT");
			this.setDX(20);
			this.move_left();
		}
		if((x_pos < 35) & (y_pos >= 20 & y_pos < 340)){
			this.move_down();
		}


	}

	public void setDir(String s){
		this.direction = s;
	}

	public Rectangle getBounds(){
		return new Rectangle (x_pos, y_pos, width, height);
	}

	public void setVisible(Boolean visible){
		this.visible = visible;
	}

	public boolean isVisible(){
		return visible;
	}
	
	public boolean isInside(Point p){
		Rectangle rect = new Rectangle(x_pos, y_pos, width, height);
		return rect.contains(p);
	}
}

