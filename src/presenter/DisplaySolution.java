package presenter;

/**
 *  * This is the class that presented the DisplaySolution command.
 * This class is presented the DisplaySolution method that display our sol, by convert him to string.
 * @author HP
 *
 */
public class DisplaySolution extends CommonCommand{
	/**
	 *  The ctor of our DisplaySolution class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public DisplaySolution(Presenter presenter) {
		super(presenter);
	}
	/**
	 * In this command we forward the String to the model, and then we are looking for sol for this maze.
	 * @param str- the maze name.
	 */
	@Override
	public void doCommand(String str) {
		presenter.getModel().displaySolution(str);
	}

}