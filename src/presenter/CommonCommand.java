package presenter;


public abstract class CommonCommand implements Command{
	Presenter presenter;
	/**
	 * constructor
	 * @param controller copy the controller
	 */
	public CommonCommand(Presenter presenter)
	{
		this.presenter = presenter;
	}
	@Override
	public abstract void doCommand(String str);
}