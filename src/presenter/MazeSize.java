package presenter;
/**
 * This is the class that presented the MazeSize command.
 * This class is presented the MazeSize we calc the maze3d class size for specific maze.
 * @author HP
 *
 */
public class MazeSize extends CommonCommand {
	/**
	 *  The ctor of our MazeSize class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public MazeSize(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method of doCommand wew forward to the maze size method into the model the maze name.
	 * @param str- the maze name.
	 */
	@Override
	public void doCommand(String str) {
		presenter.getModel().mazeSize(str);
	}

}