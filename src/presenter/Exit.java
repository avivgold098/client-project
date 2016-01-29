package presenter;

public class Exit extends CommonCommand{
	/**
	 * Exit constructor
	 * @param controller - set the controller to work with him
	 */
	public Exit(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String str) {
		presenter.getModel().exit();
	}

}