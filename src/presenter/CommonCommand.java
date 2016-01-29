package presenter;

/**
 * This class that shared all the common things for the commands.
 * Like the command interface( implements him) we have the common methods of doCommand.
 * For every command we needs presenter  data member for sent message or forward message.
 * @author HP
 *
 */
public abstract class CommonCommand implements Command{
	/**
	 * Data member for forward messages to the model or the view.
	 */
	Presenter presenter;
	/**
	 * ctor of our class that initialize our presenter
	 * @param presenter - the other presenter for copied.
	 */
	public CommonCommand(Presenter presenter)
	{
		this.presenter = presenter;
	}
	@Override
	public abstract void doCommand(String str);
}