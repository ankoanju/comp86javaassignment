// AddNewButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a support button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewButton extends JButton implements ActionListener{
	private Model model;

    public AddNewButton (Model model) {
		this.model = model;
		setText("AddNew");
		addActionListener (this);
    }


    public void actionPerformed (ActionEvent e) {
        model.doAction (Model.ButtonAction.ADDNEW);
        System.out.println("we're adding you a new vehicle");
   
    }

}
