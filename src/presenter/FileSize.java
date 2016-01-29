package presenter;

public class FileSize extends CommonCommand{

	/**
	 * FileSize constructor
	 * @param controller - get the Controller to work with him
	 */
	public FileSize(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String str) {
		presenter.getModel().fileSize(str);
	}

}