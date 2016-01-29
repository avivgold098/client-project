package view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is presented the every Maze display.
 * so this class is very generic for that. 
 * this class is exerteds canvas because we wants to drawing some maze.
 */
public abstract class MazeDisplayer extends Canvas{
	/**
     * MazeDisplayer ctor that call the super class ctor .
      * @param parent The parent of our shell
	 * @param style - Style of the widget.
     */
	public MazeDisplayer(Composite parent, int style) {
		super(parent, style);
	}
	/**
	 * this method moving up the Character in the maze
	 */
	public abstract void moveUp();
	/**
	 * this method moving down the Character in the maze
	 */
	public abstract  void moveDown();
	/**
	 * this method moving left the Character in the maze
	 */
	public abstract  void moveLeft();
	/**
	 * this method moving right the Character in the maze
	 */
	public  abstract void moveRight();
	/**
	 * this method moving forward the Character in the maze
	 */
	public abstract  void moveForward();
	/**
	 * this method moving back the Character in the maze
	 */
	public  abstract void moveBack();
}