// CheckBox.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates a checkbox and prints message to standard output. 

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckBox extends JCheckBox implements ActionListener{
    private String ans;
    public CheckBox (String label, boolean value){
		setText(label);
		addActionListener(this);
		ans = label;
    }

    public void actionPerformed(ActionEvent e){
		if (this.ans == "SUPPORT"){
			System.out.println("we are calling support, please wait a while!");
		}else if (this.ans == "FIND"){
			System.out.println("you are there");
        }

		}
		
}
    
