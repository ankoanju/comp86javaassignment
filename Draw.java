// Draw.java
// Anju Ishizaki 
// COMP86
// Assignment 6
// This is the main file. 
// It creates the window and calls the canvas class to create a drawing. 


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Draw extends JFrame {
	Model model;
    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Draw ();
            }
        });
    }

    public Draw () {

    	// Window setup
		setLocation (100, 100);
		setSize (700, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout (new BorderLayout());

		// Text field at top
		JTextField title = new JTextField ("Assignment 6", 30);
		title.setBorder (new LineBorder(Color.PINK, 3));
		title.setHorizontalAlignment(JTextField.CENTER);
		add (title, BorderLayout.NORTH);

		// Drawing canvas in middle
		Canvas canvas = new Canvas (this); 
		canvas.setBorder (new LineBorder(Color.GRAY, 3));
		add (canvas, BorderLayout.CENTER);

		// Creating the model and its associated buttons
		model = new Model(canvas);

		// Bottom panel at bottom
		JPanel bottom_panel = new JPanel ();
		bottom_panel.setBorder (new LineBorder(Color.PINK, 3));
		bottom_panel.setLayout (new GridLayout (1, 2));

		// Two buttons in the bottom panel
		bottom_panel.add(new UpButton (model));
		bottom_panel.add(new DownButton(model));

		// Plug the bottom panel into the main frame
		add (bottom_panel, BorderLayout.SOUTH);

		//Control panel on the left
		JPanel left_panel = new JPanel ();
		left_panel.setBorder (new LineBorder(Color.PINK, 3));
		left_panel.setLayout (new GridLayout (3, 1));
		
		// One checkbox and one button in a grid layout in the left_panel
		CheckBox left_CB = new CheckBox ("FIND", false);
		left_panel.add (left_CB);

		AddNewButton add = new AddNewButton(model);
		AnimateButton animate = new AnimateButton(model);
		animate.buttonActionListener(add);

		left_panel.add(animate);
		// Add button on left_panel
		left_panel.add (new LeftButton (model));

		// Plug left panel into the main frame
		add(left_panel, BorderLayout.WEST);

		//Control panel on the right
		JPanel right_panel = new JPanel ();
		right_panel.setBorder (new LineBorder(Color.PINK, 3));
		right_panel.setLayout (new GridLayout(5, 1));
		
		right_panel.add(new VCombo(model));
		right_panel.add(new SCombo(model));
		right_panel.add(new SpCombo(model));
		right_panel.add(add);

		// Add Button on the right_panel
		right_panel.add(new RightButton(model));

		// Plug right panel into the main frame
		add(right_panel, BorderLayout.EAST);

		// Show the window
		setVisible (true);


	}

	public void draw_on(Graphics g){
		// Draw calling model
		model.draw(g);

	}

	public void mouse_on(Point p){
		model.doMouse(p);
	}


}
