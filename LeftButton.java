// LeftButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a left button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeftButton extends JButton implements ActionListener{
	private Model model;

    public LeftButton (Model model) {
		this.model = model;
		setText("LEFT");
		addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        model.getCurrent().move_left();
        //model.doAction (Model.ButtonAction.LEFT);
        System.out.println("new x position: " + model.giveLocation(Model.ButtonAction.LEFT));
   
    }

}
