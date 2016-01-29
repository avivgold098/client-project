package presenter;
/**
 *  * This is the class that presented the display command.
 * This class is presented the display method that display our maze, by convert him to string.
 * 
 * @author HP
 *
 */
public class Display extends CommonCommand{
	/**
	 *   The ctor of our Display class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public Display(Presenter presenter) {
		super(presenter);
	}
	/**
	 * forward the name of  the maze to the model
	 * @param str- the name of the maze.
	 */
	@Override
	public void doCommand(String str) {
		presenter.getModel().display(str);
	}

}