// AnimateButton.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// Creates an animate button

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimateButton extends JButton implements ActionListener{
	private Model model;
    private AddNewButton button;
    private boolean animated = false;
    private int num = 1;

    public AnimateButton (Model model) {
		this.model = model;
		setText("ANIMATE");
		addActionListener (this);
    }

    public void buttonActionListener(AddNewButton button){
        this.button = button;
    }

    public void actionPerformed (ActionEvent e) {
        if(num > 1){
            if(animated == false){
                  button.setEnabled(false);
                  animated = true;
              }else{
                button.setEnabled(true);
                animated = false;
              }
        }

        num+=2;
        
        model.doAction (Model.ButtonAction.ANIMATE);
        System.out.println("it is animating!");
   
    }

}
