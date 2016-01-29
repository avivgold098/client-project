package presenter;
/**
 * This is the class that presented the Generate3dMaze command.
 * This class is presented the Generate3dMaze command that generate our maze, so in this class we
 * Implements the important method of create our maze.
 * @author HP
 *
 */
public class Generate3dMaze extends CommonCommand {

	/**
	 *  The ctor of our Generate3dMaze class(type of command).
	 * @param presnter- for calling the super class ctor, and initialize his data member.
	 */
	public Generate3dMaze(Presenter presenter) {
		super(presenter);
	}
	/**
	 * in this method of doCommand we calling to the method of generate into the model.
	 * but first we getting our parms for the generate method (in the model) from the parm str.
	 * @param str- contains the maze name, and his limits
	 * there one time that the str length is 1 and then we call the genretate method that 
	 * used the properties in the model.
	 */
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		
		if(parm.length != 4)
		{
			if(parm.length == 1)
				presenter.getModel().generate3dMaze();
			else
				presenter.setMessage("Invalid Command");
		}
		else{
			int x = 0,y = 0,z = 0;
			try{
				y = Integer.parseInt(parm[1]);
				z = Integer.parseInt(parm[2]);
				x = Integer.parseInt(parm[3]);
			}
			catch (NumberFormatException e){
				presenter.setMessage("Invalid Command");
			}
			
			presenter.getModel().generate3dMaze(parm[0],y, z, x);
		}
	}

}