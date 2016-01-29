package presenter;
/**
 * This is the class that presented the SaveMaze command.
 * This class is presented the SaveMaze we save maze into file.
 * @author HP
 *
 */
public class SaveMaze extends CommonCommand{
	/**
	 *  The ctor of our SaveMaze class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public SaveMaze(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method of doCommand we call to the save maze method into the model,
	 * but first we to get the file name and the maze name from the str.
	 * @param str- in this str we have the maze name and the file name.
	 */
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		if(parm.length != 2)
			presenter.setMessage("Invalid Command");
		else
			presenter.getModel().saveMaze(parm[0], parm[1]);
		
		
	}
	
}