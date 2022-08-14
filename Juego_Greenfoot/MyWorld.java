import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(811, 381, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,65,175);
        player.setLocation(65,175);
    }
    
    public void act() {
        despawnObstacles();
    }
    
    private void despawnObstacles() {
        java.util.List<Obstacle> obstacleList = getObjects(Obstacle.class);
        if (!obstacleList.isEmpty()) {
            for (Obstacle o : obstacleList) {
                if(o.isAtEdge()) {
                    removeObject(o);
                }
            }
        }
        
    }
}
