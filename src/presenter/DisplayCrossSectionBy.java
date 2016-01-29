package presenter;

/**
 *  * This is the class that presented the DisplayCrossSectioBy command.
 * This class is presented the DisplayCrossSectioBy method that display 
 * for us specific section in our 3d maze.
 * 
 * 
 * @author HP
 *
 */
public class DisplayCrossSectionBy extends CommonCommand{
	/**
	 * The ctor of our DisplayCrossSectionBy class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public DisplayCrossSectionBy(Presenter presenter) {
		super(presenter);
	}
	/**
	 * In this method of do command we get parm from the string and then
	 * sent we are calling to the methods in the model wit the parm from the string.
	 * @param str- the string with the parm of the cross section, index, the maze name.
	 */
	@Override
	public void doCommand(String str) {
		String[] parm =str.split(" ");
		if(parm.length != 3)
			presenter.setMessage("Invalid Command");
		else
		{
		  int index=Integer.parseInt(parm[1]);
		  presenter.getModel().displayCrossSectionBy(parm[0], index, parm[2]);
		}
	}
	
}