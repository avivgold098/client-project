package presenter;
/**
 * This is the class that presented the LoadMaze command.
 * This class is presented the LoadMaze in this command we craete 3dmaze class from file.
 * @author HP
 *
 */
public class LoadMaze extends CommonCommand{
	/**
	 *  The ctor of our LoadMaze class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public LoadMaze(Presenter presenter) {
		super(presenter);
	}


/**
 * in this method of doCommand we forward to the model method the file name and the maze name 
 * from our string.
 * the method in the model is implements our command.
 * @param str- this str contains the maze name, and the file name both of them sent to the model methods.
 */
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		if(parm.length != 2)
			presenter.setMessage("Invalid Command");
		else
			presenter.getModel().loadMaze(parm[0], parm[1]);
	}

}