package presenter;
/**
 * This is the class that presented the dir command.
 * This command is manage is making message with the list and the files into folder.
 * @author HP
 *
 */
public class Dir extends CommonCommand{
	/**
	 * The ctor of our Dir class(type of command).
	 * @param presnter- for calling the super class ctor. and initialize his data member.
	 */
	public Dir(Presenter presenter) {
		super(presenter);
	}
	/**
	 * forward the string to the model
	 * @param str- the file name.
	 */
	@Override
	public void doCommand(String str) {
		this.presenter.getModel().dir(str);
	}

}