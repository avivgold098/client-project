
package view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MenuItem;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
/**
 * This is the class that draw our 3dmaze and his character  .
 * in this class we drawing our maze.So for that we all the the data members we needs for draw maze.
 * @author HP
 *
 */
public class Maze3dDisplayer extends MazeDisplayer{


	Maze3d maze;
	int characterX;
	int characterY;
	int characterZ;
	int exitX;
	int exitY;
	int exitZ;
	ExecutorService threadSolve;
	Thread solve;
	Thread run;
	boolean running;
	MenuItem mi;
	double scale;
	 /**
     * DisplayMaze3D ctor that call the super class ctor and also create thread pool.
      * @param parent The parent of our shell
	 * @param style - Style of the widget.
     */
	public Maze3dDisplayer(Composite parent, int style,MenuItem mi) {
		super(parent, style);
		threadSolve = Executors.newFixedThreadPool(1);
		this.mi = mi;
	}	
	/**
     * this method return our correct maze.
     * @return maze- our maze.
     */
	public Maze3d getMaze() {
		return maze;
	}
	/**
     * This method is setting our maze with another maze.
     * Also this method update the data members into the class for being correct for the new maze.
     * @param maze- the another maze for copied.
     */
	public void setMaze(Maze3d maze) {
		this.maze = maze;
		characterX = maze.getStartPosition().getX();
		characterY = maze.getStartPosition().getY();
		characterZ = maze.getStartPosition().getZ();
		
		exitX = maze.getGoalPosition().getX();
		exitY = maze.getGoalPosition().getY();
		exitZ = maze.getGoalPosition().getZ();
	}
	/**
	 * get the scale that the responsible number for the zoom in or out.
	 * @return our scale.
	 */
     public double getScale() {
		return scale;
	}
    /**
     * set our scale with another one. 
     * @param scale the other scale.
     */
	public void setScale(double scale) {
		this.scale = scale;
	}
	/**
      * In this method we running on our maze 3d arr. and then we are draw him.
      * first we loading our images from the resources lib into the project.
      * and we always update the cell with the correct image.
      */
	public void draw(){
		Image image = new Image(getDisplay(), "resources/walls.jpg");
		Image charachter = new Image(getDisplay(), "resources/runne.jpg");
		Image endGame = new Image(getDisplay(), "resources/EndGame.jpg");
		Image theEnd = new Image(getDisplay(), "resources/theend.jpg");
		Image up = new Image(getDisplay(), "resources/up.png");
		Image down = new Image(getDisplay(), "resources/down.png");
		Image upAndDown = new Image(getDisplay(), "resources/upanddown.jpg");
		setBackground(new Color(null, 255, 255, 255));
		scale = 0;
		setBackgroundImage(image);
    	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				   e.gc.setForeground(new Color(null,255,255,255));
				   e.gc.setBackground(new Color(null,255,255,255));
				   
				   if (scale < 0) {
					   scale = 0;
				   }
				   int width=getSize().x;
				   int height=getSize().y;
				   
				   int w = (int) (((width)/maze.getMaze()[0][0].length)*(1+scale));
				   int h = (int) (((height)/maze.getMaze()[0].length)*(1+scale));
				   
				   if(characterX == exitX && characterZ == exitZ && characterY == exitY)
					   e.gc.drawImage(endGame, 0, 0, 1900, 900, 0, 0, getSize().x, getSize().y);

				   else
					   for(int i=0;i<maze.getMaze()[0].length;i++)
						      for(int j=0;j<maze.getMaze()[0][0].length;j++){
						    	  mi.setText("&Floor Number :"+characterY);
						          int x=j*w;
						          int y=i*h;
						          //if(maze.getMaze()[characterY][i][j] == 1)
						        	//  e.gc.drawImage(image,0,0,263,192, x, y,w,h);
						          if(maze.getMaze()[characterY][i][j] == 0)
						              e.gc.fillRectangle(x,y,w,h);  
						          if(characterY+1 < maze.getMaze().length)
						        	  if(maze.getMaze()[characterY][i][j] == 0 && maze.getMaze()[characterY+1][i][j] == 0)
						        		  e.gc.drawImage(up, 0, 0, 500,500 , x, y, w, h);
						          if(characterY-1>= 0)
						        	  	if(maze.getMaze()[characterY][i][j] == 0 && maze.getMaze()[characterY-1][i][j] == 0)
						        	  		e.gc.drawImage(down, 0, 0, 225,225 , x, y, w, h);
						          if(characterY +1< maze.getMaze().length && characterY-1 >= 0)
						        	  if(maze.getMaze()[characterY][i][j] == 0 && maze.getMaze()[characterY+1][i][j] == 0 && maze.getMaze()[characterY-1][i][j] == 0)
						        		  e.gc.drawImage(upAndDown, 0, 0, 380,314 , x, y, w, h);
						          if(j == characterX && i == characterZ){
						        	  e.gc.drawImage(charachter, 0, 0, 1200,768 , x, y, w, h);
						          }
						          if(characterY == exitY)
						          {
						        	  e.gc.drawImage(theEnd, 0, 0, 182,276 , exitX*w, exitZ*h, w, h);
						          }
						      }
			}
				  
		});
	}
	/**
	 * In this method we move our Character from cells.
	 * @param x - the x position of the Character
	 * @param y -the y position of the Character
	 * @param z the z position of the Character
	 */
	private void moveCharacter(int y,int z, int x){
		if(characterX == exitX && characterZ == exitZ && characterY == exitY)
      	  return;
		
		if(y>=0 && y < maze.getMaze().length && z>=0 && z<maze.getMaze()[0].length && x>=0 && x<maze.getMaze()[0][0].length && maze.getMaze()[y][z][x] == 0){
			characterX=x;
			characterY=y;
			characterZ=z;

			run=new Thread(new Runnable() {
				
				@Override
				public void run() {
					redraw();
				}
			});
			getDisplay().syncExec(run);
		
		}
	}
	/**
	 * this method moving up the Character in the maze
	 */
	@Override
	public void moveUp() {
		
		moveCharacter(this.characterY+1, this.characterZ, this.characterX);
	}
	/**
	 * this method moving down the Character in the maze
	 */
	@Override
	public void moveDown() {
		
		moveCharacter(this.characterY-1, this.characterZ, this.characterX);
	}
	/**
	 * this method moving left the Character in the maze
	 */
	@Override
	public void moveLeft() {
		
		moveCharacter(this.characterY, this.characterZ, this.characterX-1);
	}
	/**
	 * this method moving right the Character in the maze
	 */
	@Override
	public void moveRight() {
		
		moveCharacter(this.characterY, this.characterZ, this.characterX+1);
	}
	/**
	 * this method forward right the Character in the maze
	 */
	@Override
	public void moveForward() {
		
		moveCharacter(this.characterY, this.characterZ-1, this.characterX);
	}
	/**
	 * this method moving back the Character in the maze
	 */
	@Override
	public void moveBack() {
		
		moveCharacter(this.characterY, this.characterZ+1, this.characterX);
	}
	/**
	 * This method is display our sol of the maze.
	 * between every step in the sol we are sleeping the thread for 0.5 sec.
	 * @param sol-the Sol that using us.
	 */
	public void displaySolution(Solution<Position> sol)
	{
		this.running = true;
		solve=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(running)
				{
				String[] position=sol.toString().split("\n");
				int x,y,z;
				for(int i=position.length-1; running && i>=1; i--)
				{
					String[] numbers = position[i].split(" ");
					y=Integer.parseInt(numbers[0]);
					z=Integer.parseInt(numbers[1]);
					x=Integer.parseInt(numbers[2]);
					  moveCharacter(y,z,x);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {}
				}
				}
			}
		});
		threadSolve.execute(solve);
	}
	
	/**
	 * set the running value with another one value.
	 * @param running- the other value.
	 */
	public void setRunning(boolean running){ 
		
		if(!running)
		{
			this.running=running;
			if(run != null)
				while(run.isAlive());
			threadSolve.shutdown();
		}
	}
	/**
	 * set that new solve is occur
	 * @param running
	 */
	public void newSolve(boolean running){ 
		
		if(!running)
			this.running=running;
	}
	/**
	 * get the x position of the character
	 * @return character x position
	 */
	public int getCharacterX() {
		return characterX;
	}
	/**
	 * get the y position of the character
	 * @return character y position
	 */
	public int getCharacterY() {
		return characterY;
	}
	/**
	 * get the z position of the character
	 * @return character z position
	 */
	public int getCharacterZ() {
		return characterZ;
	}
	/**
	 * get the y position of the exit of the end of the maze
	 * @return character y position
	 */
	public int getExitY(){
		return exitY;
	}
	/**
	 * return if thread is still sloving the maze
	 * @return boolean running
	 */
	public boolean isSolving() { return running; }
	


}
