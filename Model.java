// Model.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// This hols the model data. Allows changes in bus class when button is pressed. 

import java.awt.*;
import java.lang.Math;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.lang.Object;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Model {

    // Enumerated type for which action to take
    public enum ButtonAction {LEFT, RIGHT, UP, DOWN, SUPPORT, ANIMATE, ADDNEW};

    // Model data
    private Police police;
    private Canvas canvas;
    private ArrayList<Vehicle> v_list;
    private Timer timer;
    private String type;
    private String pos;
    private int speed;
    private boolean auto = true;
    private Vehicle current;
    private Point point;
    private int tempo = 0;
    private boolean over = false;
    private Rectangle borderrect;

    public Model (Canvas canvas) {
        this.canvas = canvas;
        //this.bus = new Bus();
        this.police = new Police();
        // Maintain a list of the vehicles
        this.v_list = new ArrayList<Vehicle>();
        v_list.add(police);
        //v_list.add(bus);
        current = v_list.get(0);
        this.point = new Point();
        this.point.setLocation(100, 100);
        
        
    }

    public void draw (Graphics g){
        
        for (Vehicle v: v_list){
            if(v.isVisible())
                v.draw(g, v == current, canvas);
        }
    

        if (auto == true){
			police.tickmove();
        }

        // Check if there are any collisions between current vehicle and animated tupd
        checkCollisions(); 
        
        // Draw game status is game is not over 
        if (over == false){
            g.setColor(Color.WHITE);
            g.drawString("Vehicles OnScreen: " + v_list.size(), 5, 15);
        }else if (over == true){
            Font finale = new Font("Helvetica", Font.BOLD, 50);
            g.setColor(Color.WHITE);
            g.setFont(finale);
            g.drawString("GAME OVER" , 90, 215);
        }

        // Draw a border rectangle on the current one
        if (current != v_list.get(0)){
            Double a = borderrect.getWidth();
            int aa = a.intValue();
            Double b = borderrect.getHeight();
            int bb = b.intValue();
            g.setColor(Color.PINK);
            g.drawRect(current.getX(), current.getY(), aa, bb);
        }
        
    }

    // Move bus when respective button is pressed
    public void doAction (ButtonAction action) {


        if (action == ButtonAction.LEFT){
            current.move_left();
        } else if (action == ButtonAction.RIGHT){ 
            current.move_right();
        } else if (action == ButtonAction.UP){
            current.move_up();
        } else if (action == ButtonAction.DOWN){  
            current.move_down();
        } else if (action == ButtonAction.ANIMATE){
        	if (auto == true){
        		auto = false;
        	} else if (auto == false){
        		auto = true;
        	}
        } else if (action == ButtonAction.ADDNEW){
        	this.createNewVehicle();
        }

        canvas.repaint();
    }

    public void settype(Object e){
    	type = e.toString();
    }

    public void setpos(Object e){
    	pos = e.toString();
    }

    public void setspeed(Object e){
    	String temp = e.toString();
    	speed = Integer.parseInt(temp);	

    }

    public void createNewVehicle(){
    	System.out.println(type);
    
    	if (type == "Shuttle"){
    		Bus userbus = new Bus();
    		userbus.setDX(speed);
    		userbus.setDY(speed);
    		System.out.println(speed);
    		if (pos == "Left Bottom"){
    			userbus.setDir("RIGHT");
    			userbus.setX(70);
    			userbus.setY(340);
    			System.out.println(speed);
    		}else if (pos == "Right Top"){
    			userbus.setDir("LEFT");
                userbus.setImagefromDir("LEFT");
    			userbus.setX(400);
    			userbus.setY(20);
    		}
    		v_list.add(userbus);
            userbus.setVisible(true);
            //current = userbus;
    	} else if (type == "TUPD"){
    		Police usertupd = new Police();
    		usertupd.setDX(speed);
    		usertupd.setDY(speed);
    		if(pos == "Left Bottom"){
    			usertupd.setDir("RIGHT");
    			usertupd.setX(70);
    			usertupd.setY(340);
    		}else if (pos == "Right Top"){
    			usertupd.setDir("LEFT");
                usertupd.setImagefromDir("LEFT");
    			usertupd.setX(400);
    			usertupd.setY(0);
    		}
    		v_list.add(usertupd);
            usertupd.setVisible(true);
            //current = usertupd;
    	}

        for (Vehicle v: v_list){
                System.out.println(v);
            }
    }

    // Print new x or y location to user output
    public int giveLocation (ButtonAction action){
        if (action == ButtonAction.LEFT)
            return current.getX();
        else if (action == ButtonAction.RIGHT)
            return current.getX();
        else if (action == ButtonAction.UP)
            return current.getY();
        else if (action == ButtonAction.DOWN)
            return current.getY();
        else
            return 0;
    }

    
    public void checkCollisions(){
        Rectangle mainrect = current.getBounds();
        for (Vehicle v: v_list){
            for(int i = 0; i < v_list.size(); i++){
                Vehicle temp = v_list.get(i);
                Rectangle subrect = temp.getBounds();
                    if((mainrect.intersects(subrect)) & (current != temp)){
                        current.setVisible(false);
                        v.setVisible(false);
                        over = true;
                        break;

                    }
                break;
            }
        }
    }

    
    public boolean overbool(){
        return over;
    }

    public Vehicle getCurrent(){
        System.out.println("this is current" + current);
        return current;
    }



    public void doMouse(Point p){
        this.point = canvas.current_p();
        for(Vehicle v: v_list){
            for(int i = 0; i < v_list.size(); i++){
                Vehicle temp = v_list.get(i);
                Rectangle temprect = temp.getBounds();
                    if(temprect.contains(this.point)){
                    this.current = v_list.get(i);
                    borderrect = current.getBounds();
                    break;
                    }
            }
        }
    }



}