package presenter;
/**
 * This is the class that presented the Solve command.
 * This class is presented the Solve in this command we solve maze by using our search problem algos.
 * @author HP
 *
 */
public class Solve extends CommonCommand{
	/**
	 *  The ctor of our Solve class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public Solve(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method of doCommand we gets the the name of the maze and the algo for sol.
	 * and then we forward both of the the solve method in the model.
	 * but if the str length is one we using our properties in the model for creating the sol.
	 * @param str -contains or only the solve command or the algo name and the maze name.
	 */
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		
		if(parm.length != 2)
		{
			if(parm.length == 1)
				presenter.getModel().solve();
			else
				presenter.setMessage("Invalid Command");
		}
		else
			presenter.getModel().solve(parm[0],parm[1]);
	}

}