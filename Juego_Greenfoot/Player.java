import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private int initialX;
    private int initialY;
    private boolean isMoving = false;
    private int movementSpeed = 5;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        initialX = getX();
        initialY = getY();
        movement();
        System.out.println("X: " + getX() + " Y: " + getY());
    }
    
    public void movement() {
        
        if (Greenfoot.isKeyDown("up") && !isMoving) {
            System.out.println("Moving Up");
            animateMovement(-65, getY());
        }
        if (Greenfoot.isKeyDown("down") && !isMoving) {
            System.out.println("Moving Down");
            animateMovement(65, getY());
        }
    }
    
    public void animateMovement(int vDistance, int initialYPos) {
        int finalY = initialYPos + vDistance;
        if (isInsideTrack(finalY)) {
            System.out.println("In movement range");
            this.isMoving = true;
            while (getY() != finalY) {
                System.out.println("In movement loop");
                if (vDistance >= 0) {
                    setLocation(this.initialX,getY() + this.movementSpeed);
                } else {
                    setLocation(this.initialX,getY() - this.movementSpeed);
                }
                Greenfoot.delay(1);
            }
            this.isMoving = false;
        } else {
                System.out.println("Out of track!");
            }
    }
        
    public boolean isInsideTrack(int value) {
        if (value <= 240 && value >= 110) {
            return true;
        } else {
            return false;
        }
    }

}
