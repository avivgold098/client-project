package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Command;

public interface UserChoice {
	/**
	 * set the our view.
	 * @param view
	 */
	void setView(View view);
	/**
	 * start our thread.
	 */
	void start();
	/**
	 * display the message
	 * @param message - the message we show.
	 */
	void setMessage(String message);
	/**
	 * set commands our hash map with another hash map.
	 * @param hashCommand
	 */
	void setHashCommand(HashMap<String, Command> hc);
	/**
	 * display our maze
	 * @param maze the we show.
	 */
	void setMessage(Maze3d maze);
	/**
	 * display our	sol
	 * @param sol - the sol wo shows.
	 */
	void setMessage(Solution<Position> sol);
}