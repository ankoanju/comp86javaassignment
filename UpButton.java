// UpButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a up button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpButton extends JButton implements ActionListener{
	private Model model;

    public UpButton (Model model) {
		this.model = model;
		setText("UP");
		addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        model.getCurrent().move_up();
        //model.doAction (Model.ButtonAction.UP);
        System.out.println("new y position: " + model.giveLocation(Model.ButtonAction.UP));
   
    }

}
