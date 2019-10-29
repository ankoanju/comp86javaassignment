Anju Ishizaki 
COMP86
Assignment 6
Text file

Game Rules for Users:
RUN! You are about to get caught by TUPD (Tufts Police). You must select your vehicle (shuttle bus or police car), set your location, and set your speed to start your car and start running away. The objective of this game is to run away from the TUPD car. You are able to create more vehicles using the same method you did to create your original car. You can select any car that you have made so that it would move. The car you select is the current car you are in, and you cannot collide let the original real TUPD catch you. If you collide with other cars, that is, your other cars that you have made, it is okay. Similar to the 'flappy bird' game, the game is endless as long as you do not bump into the original TUPD with your current vehicle. However, once you bump into the original TUPD, it is game over. Please close the window and start again. ENJOY!

About the program: For this assignment, I mainly implemented mouse picking and collision detection. I changed the animation to be by the police instead of the shuttle, so that the user would be moving away from the police. I changed my code around so that when the animation is happening the police car does not increase in speed (which happened for the last assignment).

Mouse Picking: I implemented ways for the use to click on an individual vehicle on the screen, and then can use the left, right, up, and down buttons to move that selected vehicle. I created and and set the program to have a 'current' vehicle. It also highlights the selected vehicle so that the user knows which one they are moving (which one the current vehicle is). The original animated police would not be highlighted even pressed. 

Collisions: The program now has a collision detection code in which can determine if the game is over or not. I iterated through all the vehicles in the array list, created a temporary rectangle that has the same x, y, width, and height, and checked if that interferes with the current vehicle. I made it so that this works only for when the current vehicle collides with the animated police. So if there are multiple vehicles, only the program will output "Game Over" when current vehicle collides with animated police. 

Game Rules (for assignment): As mentioned in the first section of this assignment, I added rules to turn this into a game that a user could play. 

State Panel: On the left top corner, it shows the number of vehicles, which is based on the arraylist.   

Layout: Since my background roads are made by computing their ratios, they are resizable. 

Main Program: My main program is the Draw.java file. The constructor sets up the window and initiates Model object.



An outline showing the aggregation hierarchy(which objects contain or own which other objects):

							/|-------- SpCombo
							/|-------- SCombo
							/|-------- VCombo
							/|-------- AddNewButton
							/|-------- AnimateButton
							/|-------- DownButton
							/|-------- UpButton
							/|-------- RightButton
							/|-------- LeftButton
	   /|----------- Model  -|-------- Canvas
Draw  --|----------- Canvas
	   \                   
	   \|----------- Model --|-------- Vehicle ------|-------- Police
	   						\|-------- Canvas 
							\|-------- Bus      




An outline showing the inheritance hierarchy 
	     /|----- JTextfield
	    /-|----- Canvas
JFrame ---|----- JPanel (bottom) -- UpButton and DownButton
	    \-|----- JPanel (left)   -- FindCheckBox, AnimateButton, and LeftButton
             \|----- JPanel (right)  -- VCombo, SCombo, SpCombo, and RightButton


A list showing uses or collaboration relationships (which objects use which other objects to perform functions)
Draw --> uses all objects
Canvas --> uses Draw as parent
Model --> uses Canvas, Objects, ButtonActions, Graphics
Bus, Police --> uses Vehicle
VCombo, SCombo, SpCombo --> uses ItemListener
All buttons --> use ActionListener


The information hiding secrets of each of your classes (i.e., what design decisions are entirely encapsulated within that class)
Draw --> the layout of the panel, that is the grid layout and the border layout
Canvas --> the drawing of the roads
Model --> actions that happen when certain buttons are pressed
All buttons --> ActionListeners
All comboboxes --> ItemListeners
All vehicles --> information about the objects including location, size, etc.


