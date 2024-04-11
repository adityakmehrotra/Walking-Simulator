import java.util.Random;
import processing.core.PImage;
import java.io.File;

/**
 * This class is public. It uses 'Walker' objects throughout the class.
 * Then, it would animate them so they could move around.
 */

public class WalkingSim {
	
	private static int bgColor;
	private static Random randGen;
	private static PImage[] frames;
	private static Walker[] walkers;
	
	public static void main(String[] args) {
		Utility.runApplication();
	}
	
	/**
	 * This static method is called setup. It is used to initiate all of the important variables.
	 * Also, it is used to build the framework of the main window.
	 */
	
	public static void setup() {
		randGen = new Random();
		bgColor = randGen.nextInt();
		frames = new PImage[Walker.NUM_FRAMES];
		
		for(int i = 0; i < frames.length; i++) {
			frames[i] = Utility.loadImage("images"+File.separator+"walk-"+i+".png");
		}		
			
		walkers = new Walker[8];
		
		for(int j = 0; j < randGen.nextInt(walkers.length+1); j++) {
			walkers[j] = new Walker((randGen.nextFloat(Utility.width())), (randGen.nextFloat(Utility.height())));
		}
	}
	
	/**
	 * This static method is called draw. It creates the window that is used throughout the program.
	 * It also creates the background color in the window. It also creates the Walker characters.
	 */
	
	public static void draw() {
		
		Utility.background(bgColor);

		for(int i = 0; i < walkers.length; i++) {
			if(((walkers[i] != null) && (walkers[i].isWalking() == true))) {
				
				walkers[i].setPositionX(walkers[i].getPositionX() + 3);
				
				if(walkers[i].getPositionX() > Utility.width()) {
					
					walkers[i].setPositionX(0);
				}
			}
			
			if(walkers[i] != null) {
				Utility.image(frames[walkers[i].getCurrentFrame()], walkers[i].getPositionX(), walkers[i].getPositionY());
			}
		}
		
		for(int j = 0; j < walkers.length; j++) {
			
			if((walkers[j] != null) && (walkers[j].isWalking() == true)) {
				
				walkers[j].update();
				
			}
		}
	}
	
	/**
	 * This static function is called isMouseOver and returns a boolean value.
	 * The function's main purpose is to check if the user's mouse
	 * is above a Walker character on the screen.
	 * 
	 * @param walker the Walker object that is desired to be checked for mouse overlay.
	 * @return true if mouse is overlaying the character, false if it is not.
	 */
	
	public static boolean isMouseOver(Walker walker) {
		
		if(Utility.mouseX() > walker.getPositionX() - frames[0].width/2 && Utility.mouseX() < walker.getPositionX() + frames[0].width/2&& Utility.mouseY() > walker.getPositionY() - frames[0].height/2 && Utility.mouseY() < walker.getPositionY() + frames[0].height/2) {
			return true;
		}
		return false;
	}
	
	/**
	 * This static function is called mousePressed and does not return anything.
	 * The function's main purpose is to see if the mouse is pressed. If the mouse is indeed pressed,
	 * then the person will start walking.
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	
	public static void mousePressed() {
		
		for(int j = 0; j < walkers.length; j++) {
			
			if(((walkers[j] != null) && (isMouseOver(walkers[j]) == true))) {	
				
				walkers[j].setWalking(true);
				System.out.println(walkers[j].isWalking());
				
				break;
			}
		}
	}
	
	/**
	 * This static function is called keyPressed and does not return anything.
	 * The function's main purpose is to see if the user presses a/A or s/S.
	 * It checks if the parameter, c, is lower case or upper case a/A or s/S.
	 * If it is a, another person spawns on the screen.
	 * If it is s, the person stops walking.
	 * 
	 * @param char c
	 * @return Nothing
	 */
	
	public static void keyPressed(char c) {
		if((c == 'a') || (c == 'A')) {		
			for(int i = 0; i < walkers.length; i++) {
				if(walkers[i] == null) {
					walkers[i] = new Walker((randGen.nextFloat(Utility.width())), (randGen.nextFloat(Utility.height())));
					break;
				}
			}
		}
		
		if((c == 's') || (c == 'S')) {
			for(int i = 0; i < walkers.length; i++) {
				if(walkers[i] != null) {
					walkers[i].setWalking(false);
				}
			}
		
		}
	}
	

}
