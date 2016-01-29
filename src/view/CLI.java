package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Command;
/**
 * This class the class that presented the option of cli (Command line interface).
 * In this class we have the methods for calling the different commands and also the data members
 * for writing message and reading the commands from file.
 * @author HP
 *
 */
public class CLI implements UserChoice{
	/**
	 * with this data members we gets our inputs.
	 */
	private BufferedReader in;
	/**
	 * with this data member we write to the files.
	 */
	private PrintWriter out;
	/**
	 * the hash map that mapping between the commands name and their "real" commands.
	 */
	private HashMap<String,Command> hm;
	/**
	 * View data members for calling the methods in the view
	 */
	private View view;
	/**
	 * CLI ctor in this ctor we initialize our data members.
	 * @param out - the other PrintWriter for copied.
	 * @param in - the other BufferedReader for copied.
	 */
	public CLI(BufferedReader in,PrintWriter out)
	{
		this.out = out;
		this.in = in;
	}
	/**
	 * In this method we start the thread of the cli.
	 * In this thread we are getting each time command and then doing this command. until we get the 
	 * exit command.
	 * This is the method that starts our program.
	 */
	@Override
	public void start() {
		new Thread(new Runnable() {
		String s = null;
			@Override
			public void run() {
				try {
					while ((s = in.readLine()).equals("exit") != true) {
						String[] command = s.split(" ",2);		
						if(s.equals("newConnection"))
							view.notifyMe(s);
						else if(hm.containsKey(command[0]) == true)
							view.notifyMe(command);
						else
						{
							out.println("Error");
							out.flush();
						}
					}
					}catch (IOException e) {
					e.printStackTrace();
				}
				view.notifyMe(s);
			}
		}).start();
	}
	/**
	 * in this method we initialize our view data member
	 * @param view- the view that copied to our view.
	 */
	@Override
	public void setView(View view){ 
		this.view = view;
	}
	/**
	 * in this method we initialize our HashCommand data member
	 * @param hc- HashCommand view that copied to our view.
	 */
	@Override
	public void setHashCommand(HashMap<String,Command> hc) {
		this.hm = hc;
	}
	/**
	 * in this method we print message into file.
	 * @param str- the message we print into the file.
	 */
	@Override
	public void setMessage(String str){
		out.println(str);
		out.flush();
	}
	/**
	 * in this method we setting message with this message is Maze3d
	 */
	@Override
	public void setMessage(Maze3d maze){
	}
	/**
	 * in this method we setting message with this message is Solution
	 */
	@Override
	public void setMessage(Solution<Position> sol) {	
	}
}