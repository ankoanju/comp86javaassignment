// DownButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a down button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DownButton extends JButton implements ActionListener{
	private Model model;

    public DownButton (Model model) {
		this.model = model;
		setText("DOWN");
		addActionListener (this);
    }


    public void actionPerformed (ActionEvent e) {
        model.getCurrent().move_down();
        //model.doAction (Model.ButtonAction.DOWN);
        System.out.println("new y position: " + model.giveLocation(Model.ButtonAction.DOWN));
   
    }

}
