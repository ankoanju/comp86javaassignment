// VCombo.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates an combobox for the vehicle type

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Note: On older versions of Java, use "JComboBox" not "JComboBox<String>"
public class VCombo extends JComboBox<String> implements ItemListener {
	private Model model;
	private String selected;

    public VCombo (Model model) {

    	this.model = model;
		addItem ("Shuttle");
		addItem ("TUPD");
		addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			model.settype(e.getItem());
		}
		
    }

}
//     public String vtype(){
    	
//     	System.out.println (selected);
//     	return selected;
//     }
// }