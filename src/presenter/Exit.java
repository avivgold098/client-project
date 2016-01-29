package presenter;
/**
 *  * This is the class that presented the Exit command.
 * This class is presented the Exit that doing safe exit from the connection with client 
 * and then save the proejct files.
 * @author HP
 *
 */
public class Exit extends CommonCommand{
	/**
	 *  The ctor of our Exit class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public Exit(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method we get a "" String and just call the exit methods into the model.
	 * @param str- empty string.
	 */
	@Override
	public void doCommand(String str) {
		presenter.getModel().exit();
	}

}