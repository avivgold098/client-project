package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Observable;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Presenter;
/**
 * This is the class of CommonModel that shared all the common things to the different models.
 * This class is implements the model interface, and also his type his abstract.
 * Also in This class we have all the common things that should be is some models,
 * for example every for (client - server ) project should have ip, port, socket data members.
 * And you can to see more data member that common for the different models.
 * With this class we can our project more generic, because now all the common things are in one class.
 * @author Aviv gold
 *
 */
public abstract class CommonModel extends Observable implements Model{
	/**
	 * our ip for the connection.
	 */
	String ip;
	/**
	 * our port for connection.
	 */
	int port;
	/**
	 * with this printer Writer we use after we are creating the socket.
	 */
	PrintWriter outToServer;
	/**
	 * with this Buffer Reader we use after we are creating the socket.
	 */
	BufferedReader inFromServer;
	/**
	 * our socket for the connection.
	 */
	Socket theServer;
	/**
	 * with this hash map we saving our mazes
	 */
	HashMap<String, Maze3d> hm;
	/**
	 * with this hash map we save our solution.
	 */
	HashMap<Maze3d, Solution<Position>> hashSolution;
	
	/**
	 * ctor of our class that initialize our data members.
	 * By initialize the socket we get the printer writer and also the buffer reader.
	 * @param String ip - ip for connection.
	 * @param port- the por for the connection.
	 */
		public CommonModel(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			theServer = new Socket(ip,port);
		} catch (UnknownHostException e) {
			setChanged();
			notifyObservers(e.getMessage());
		} catch (IOException e) {
			setChanged();
			notifyObservers(e.getMessage());
		}
		
		try {
			outToServer = new PrintWriter(theServer.getOutputStream());
		} catch (IOException e) {
			setChanged();
			notifyObservers(e.getMessage());
		}
		try {
			inFromServer = new BufferedReader(new InputStreamReader(theServer.getInputStream()));
		} catch (IOException e) {
			setChanged();
			notifyObservers(e.getMessage());
		}
		
		hashSolution = new HashMap<Maze3d,Solution<Position>>();
		hm = new HashMap<String,Maze3d>();
	}
	
	/**
	 * Default ctor for our class
	 * initialize the both hash map.
	 */
	public CommonModel()
	{
		hm = new HashMap<String,Maze3d>();
		hashSolution = new HashMap<Maze3d, Solution<Position>>();
	}
	
	@Override
	public void newConnection(){
		try {
			theServer = new Socket(ip,port);
		} catch (UnknownHostException e) {
			setChanged();
			notifyObservers("Error create connection");
			return;
		} catch (IOException e) {
			setChanged();
			notifyObservers("Error create connection");
			return;
		}
		
		try {
			outToServer = new PrintWriter(theServer.getOutputStream());
		} catch (IOException e) {
			setChanged();
			notifyObservers("Error create connection");
			return;
		}
		try {
			inFromServer = new BufferedReader(new InputStreamReader(theServer.getInputStream()));
		} catch (IOException e) {
			setChanged();
			notifyObservers("Error create connection");
			return;
		}
		
		setChanged();
		notifyObservers("Connection up");
	}
	
	@Override	
	public void displaySolution(String name){
		Solution<Position>	solution = hashSolution.get(hm.get(name));
		if(solution == null)
		{
			setChanged();
			notifyObservers("Not exist solution for '" + name + "' maze");
		}
		else
		{
			setChanged();
			notifyObservers(solution.toString());
		}
	}

	public abstract void dir(String path);
	@Override
	public abstract void generate3dMaze(String name,int y, int z, int x);
	
	@Override
	public abstract void generate3dMaze();
	@Override
	public abstract void display(String name);
	
	@Override
	public abstract void solve(String name,String algorithm);
	
	@Override
	public abstract void solve();
	
	@Override
	public abstract void displayCrossSectionBy(String by, int index, String name);
	
	@Override
	public abstract void saveMaze(String name,String fileName);
	
	@Override
	public abstract void loadMaze(String fileName,String name);
	
	@Override
	public abstract void mazeSize(String name);
	
	@Override
	public abstract void fileSize(String name);
	
	@Override
	public abstract void exit();
	

}