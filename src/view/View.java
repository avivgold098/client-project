package view;



import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Command;
import presenter.Properties;
/**
 * This is the interface of the view into our mvp.
 * here we have all the methods of show something. and doing something.
 * @author HP
 *
 */
public interface View {
	/**
	 * this method starts our program
	 */
	void start();
	/**
	 * this method show our sol into file.
	 * @param sol - the sol we want to show into the file.
	 */
	void displayMessage(Solution<Position> sol);
	/**
	 * this method show our maze into file.
	 * @param maze - the maze we want to show into the file.
	 */
	void displayMessage(Maze3d maze);
	/**
	 * this method show our message into file.
	 * @param message - the message we want to show into the file.
	 */
	void displayMessage(String message);
	/**
	 * this method set the hash command for the cli.
	 * @param hc the hash command for copied.
	 */
	void setHashCommand(HashMap<String,Command> hc);
	/**
	 * this method the  notification with string[] to the presnter.
	 * @param str - the str[] for the forward to the presnter.
	 */
	void notifyMe(String[] str);
	/**
	 * this method the  notification with string to the presnter.
	 * @param str - the str for the forward to the presnter.
	 */
	void notifyMe(String str);
	/**
	 * this method the  notification with properties to the presnter.
	 * @param properties - the properties for the forward to the presnter.
	 */
	void notifyMe(Properties properties);
}