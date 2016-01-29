package presenter;

public class LoadMaze extends CommonCommand{
	/**
	 * constructor
	 * call super with the Controller that it get
	 * @param controller
	 */
	public LoadMaze(Presenter presenter) {
		super(presenter);
	}



	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		if(parm.length != 2)
			presenter.setMessage("Invalid Command");
		else
			presenter.getModel().loadMaze(parm[0], parm[1]);
	}

}