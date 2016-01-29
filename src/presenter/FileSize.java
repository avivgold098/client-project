package presenter;
/**
 * This is the class that presented the FileSize command.
 * This class is presented the FileSize command that calc the the file size for maze3d.
 * @author HP
 *
 */
public class FileSize extends CommonCommand{

	/**
	 *  The ctor of our FileSize class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public FileSize(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method we forward to the model the name of the maze
	 * that we wants to calc for him the file size.
	 * @param str- the maze name.
	 */
	@Override
	public void doCommand(String str) {
		presenter.getModel().fileSize(str);
	}

}