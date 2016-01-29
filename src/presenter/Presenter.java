package presenter;
/**
 * This is the class of Presenter in our mvp.
 * In the mvp the presenter "know" the model and the view but they now don't "know" him.
 * The presenter now when to work when he gets notification from the model or the view and then
 * he have recognize where the notification is from, and then according to the case he forward the 
 * data object he gets in the parm of the method update.
 * In this class we the hash map that mapping between all the different commands we have in our cli,
 * and also we have in this class view and model date members for Contact with them.
 */
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Dir;
import presenter.Display;
import presenter.DisplayCrossSectionBy;
import presenter.DisplaySolution;
import presenter.Exit;
import presenter.FileSize;
import presenter.Generate3dMaze;
import presenter.LoadMaze;
import presenter.MazeSize;
import presenter.SaveMaze;
import presenter.Solve;
import model.Model;
import view.View;

public class Presenter implements Observer {
	/**
	 * this date member is for Contacting with the view
	 */
	View view;
	/**
	 * this date member is for Contacting with the model
	 */
	Model model;
	/**
	 * in this hash we are mapping all the commands we have into the cli.
	 */
	HashMap<String,Command> hash;
	/**
	 * Presenter ctor that gets model and view for initialize his date members.
	 * Also in this ctor we are creating the hash map and puts into this hash all the commands.
	 * @param model - The other model that copied for our date member.
	 * @param view - The other view that copied for our date member.
	 */
	
	public Presenter(Model model, View view) {
		this.model = model;
		this.view = view;
		
		this.hash = new HashMap<String,Command>();
		hash.put("dir", new Dir(this));
		hash.put("display", new Display(this));
		hash.put("displayCrossSectionBy", new DisplayCrossSectionBy(this));
		hash.put("displaySolution", new DisplaySolution(this));
		hash.put("generate3dMaze", new Generate3dMaze(this));
		hash.put("solve", new Solve(this));
		hash.put("saveMaze", new SaveMaze(this));
		hash.put("loadMaze", new LoadMaze(this));
		hash.put("mazeSize", new MazeSize(this));
		hash.put("fileSize", new FileSize(this));
		hash.put("exit", new Exit(this));
		
		view.setHashCommand(hash);
	}
	/**
	 * in this method we get message and forward the message to the view.
	 * @param message- the message we forward.
	 */	
	public void setMessage(String message) {
		this.view.displayMessage(message);

	}
	/**
	 * in this method we return our model
	 * @return our model.
	 */	
	public Model getModel(){ return model; }
	/**
	 * in this method we return our view
	 * @return our view.
	 */	
	public View getView(){ return view; }
	/**
	 * in this method we distinguish between the different notifications.
	 * in this method we forward things between the model and the view.
	 * and calling to the different methods.
	 * @param o - the observable with this parm we know if the notification came from the view or the model.
	 * @param atr- this is the object that sent with the observable, this is object so can to anything 
	 * and that very usfeul. For example he can be: Maze3d,String,Position and what we wants.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o == view)
		{
			if(((arg.getClass()).getName()).equals("[Ljava.lang.String;")){
				String[] command = (String[]) arg;
				Command com = hash.get(command[0]);	
				if(com != null)
					if(command.length == 1)
						com.doCommand("");
					else
						com.doCommand(command[1]);
				else
					view.displayMessage("Error! Command not exist"); 
			}
			else if (((arg.getClass()).getName()).equals("java.lang.String")){
				String command = (String) arg;
				Command com = hash.get(command);
				if (command.equals("newConnection"))
					model.newConnection();
				else if(com != null)
					com.doCommand("");
				else	
					view.displayMessage("Error! Command not exist");	
			}
			else if (((arg.getClass()).getName()).equals("presenter.Properties")){
				Properties properties = (Properties) arg;
				model.setProperties(properties);
			}
			else
				view.displayMessage("Error! Object not recognized");
			
		}
		if(o == model)
		{
			if(((arg.getClass()).getName()).equals("algorithms.mazeGenerators.Maze3d"))
			{
				Maze3d maze = (Maze3d) arg;
				view.displayMessage(maze);
			}
			else if(((arg.getClass()).getName()).equals("algorithms.search.Solution")){
				@SuppressWarnings("unchecked")
				Solution<Position> sol = (Solution<Position>) arg;
				view.displayMessage(sol);
			}
			else
			{
				String s = (String) arg;
				view.displayMessage(s);
			}
		}
	}

}