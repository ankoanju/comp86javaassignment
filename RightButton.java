// RightButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a right button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RightButton extends JButton implements ActionListener{
	private Model model;

    public RightButton (Model model) {
		this.model = model;
		setText("RIGHT");
		addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        
        model.getCurrent().move_right();
   		System.out.println("new x position: " + model.giveLocation(Model.ButtonAction.RIGHT));
    }

}
