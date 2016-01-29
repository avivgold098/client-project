package presenter;
public class Dir extends CommonCommand{
	/**
	 * Dir constructor
	 * @param controller - get the controller to work with him
	 */
	public Dir(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String str) {
		this.presenter.getModel().dir(str);
	}

}