// SpCombo.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates an combobox for the speed 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Note: On older versions of Java, use "JComboBox" not "JComboBox<String>"
public class SpCombo extends JComboBox<String> implements ItemListener {
	private Model model;

    public SpCombo (Model model) {

    	this.model = model;
		addItem ("10");
		addItem ("15");

		addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
	   		model.setspeed(e.getItem());
	    //System.out.println ("SpCombo: " + e.getItem());
	}
    }
}