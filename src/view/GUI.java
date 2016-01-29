package view;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import presenter.Command;
import presenter.Properties;
/**
 * This is the class that presented the gui choice from the user choice.
 * Its mean is that user wants project with gui.
 * In this class we are building the gui options
 * @author HP
 *
 */
public class GUI extends BasicWindow implements UserChoice{
	/**
	 * view data member for calling the methods into the view
	 */
	View view;
	/**
	 * hash map that mapping between the string of command and his command.
	 */
	HashMap <String,Command> hc;
	/**
	 * our 3dMaze display.
	 */
	Maze3dDisplayer mazeDisplay;
	/**
	 * ctor for our class that call to the super type ctor.
	 * @param title - the title of the shell
	 * @param width - the shell width
	 * @param height - the shell height.
	 */
	public GUI(String title, int width, int height) {
		super(title, width, height);
		
	}

	/**
	 * In this method we set our view data member with another one.
	 */
	@Override
	public void setView(View view) {
		this.view = view;
	}
	/**
	 * In this method we just calling to run the method.
	 */
	@Override
	public void start() {
		run();
		
	}
	/**
	 * in this method we passing the str we gets the view notifyme
	 * @param str - the str[] for passing to the view methods.
	 */
	public void notifyMe(String[] str) {
		view.notifyMe(str);
		
	}
	/**
	* in this method we passing the str we gets the view notifyme
	 * @param str - the str for passing to the view methods.
	 */
	public void notifyMe(String str) {
		view.notifyMe(str);
		
	}
	/**
	 * In this mehod we call to the set Maze method into the view and we are passing the maze from the parm.
	 * @param Maze3d - the maze we are passing to the view.
	 */
	@Override
	public void setMessage(Maze3d maze) {
		mazeDisplay.setMaze(maze);
	}
	/**
	 * in this method this method we setting the message of the dialog message.
	 * and after we are setting the message we are sending the message into the initialize the
	 * dialog Message.
	 */
	@Override
	public void setMessage(String message) {
		String temp = new String(message);
		String[] newMessage = temp.split(" ",2);
		if(newMessage[0].equals("Maze"))
		{
			DialogMessage dm = new DialogMessage(shell, message+"\nClick one of the arrows to start!");
			dm.open();
			return;
		}
		else if(newMessage[0].equals("Loaded"))
		{
			DialogMessage dm = new DialogMessage(shell, message+"\nTo play on this maze follow this:\n1.Choose \"Generate Maze\" in the tool bar\n2.Choose \"Custom generate\"\n3.Write this name in the \"Maze name\" with arbitary numbers");
			dm.open();
			return;
		}
		DialogMessage dm = new DialogMessage(shell, message);
		dm.open();
		
	}
	/**
	 * this method is redraw our maze. every we have an update we in the mazw we should to call this mehod.
	 */
	public void redraw() {
		mazeDisplay.redraw();	
	}
	/**
	 * In this method we set our HashMap hc data member with another one.
	 */
	@Override
	public void setHashCommand(HashMap<String, Command> hc) {
		this.hc = hc;
		
	}
	/**
	 * here we making all our different things in our window. running shell and display.
	 * for example we creating all our menu items. and sets their texts.
	 * and all the texts of the all the dialog messages we wants to show into the screen.
	 */
	@Override
	void initWidgets() {

		shell.setLayout(new GridLayout(3, false));

		Menu menuBar, fileMenu, gameMenu,infoMenu;
		MenuItem fileMenuHeader, gameMenuHeader,saveMazeItem,loadMazeItem, generateItem,
		hintItem,infoMenuHeader,floorNumberItem,solveItem, stopSolveItem, openPropertiesItem, 
		exitItem,instructionsItem,aboutItem, newConnection;
		
		menuBar = new Menu(shell,SWT.BAR);
		
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&Menu");
		
		fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);
		
		openPropertiesItem = new MenuItem(fileMenu, SWT.PUSH);
		openPropertiesItem.setText("&Open Properties");
		
		newConnection = new MenuItem(fileMenu, SWT.PUSH);
		newConnection.setText("&New Connection");
		instructionsItem = new MenuItem(fileMenu,SWT.PUSH);
		instructionsItem.setText("&Instructions");
		
		aboutItem = new MenuItem(fileMenu,SWT.PUSH);
		aboutItem.setText("&About");
		
		exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");
		
		gameMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		gameMenuHeader.setText("&Game Options");
		
		gameMenu = new Menu(shell, SWT.DROP_DOWN);
		gameMenuHeader.setMenu(gameMenu);
		
		
		generateItem = new MenuItem(gameMenu, SWT.PUSH);
		generateItem.setText("&Generate maze");
			
		solveItem = new MenuItem(gameMenu, SWT.PUSH);
		solveItem.setText("&Solve maze");
		
		stopSolveItem = new MenuItem(gameMenu, SWT.PUSH);
		stopSolveItem.setText("&Stop solve");
		
		
		saveMazeItem = new MenuItem(gameMenu, SWT.PUSH);
		saveMazeItem.setText("&Save Maze");
		
		loadMazeItem = new MenuItem(gameMenu, SWT.PUSH);
		loadMazeItem.setText("&Load Maze");
		
		infoMenuHeader = new MenuItem(menuBar,SWT.CASCADE);
		infoMenuHeader.setText("&Information");
		
		infoMenu = new Menu(shell,SWT.DROP_DOWN);
		infoMenuHeader.setMenu(infoMenu);
		
		floorNumberItem = new MenuItem(infoMenu,SWT.READ_ONLY);
		floorNumberItem.setText("&Floor Number : 0");
		
		hintItem = new MenuItem(infoMenu,SWT.PUSH);
		hintItem.setText("&Hint");
		
		shell.setMenuBar(menuBar);
				
		mazeDisplay = new Maze3dDisplayer(shell, SWT.BORDER,floorNumberItem);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 7));
		view.notifyMe("generate3dMaze");
		mazeDisplay.draw();
		GUI g=this;
		Listener generateListener = new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				mazeDisplay.newSolve(false);
				GenerateWindow gw = new GenerateWindow(g,shell);
				gw.open();
			}
			
		};
		
		Listener exitListener = new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				mazeDisplay.setRunning(false);
				view.notifyMe("exit");
				shell.dispose();
			}
		};
		
		Listener propertiesListener = new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
		        fd.setText("Open Properties");
		        try {
					fd.setFilterPath(new java.io.File( "." ).getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
		        String[] filterExt = { "*.xml" };
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        if(selected != null){
		        	XMLDecoder d;
		    		Properties properties = new Properties();
		    		try {
		    			d = new XMLDecoder(new BufferedInputStream(new FileInputStream(selected)));
		    			properties = (Properties) d.readObject();
		    			d.close();
		    		} catch (FileNotFoundException e) {
		    			e.printStackTrace();
		    		}
		    		view.notifyMe(properties);
		        }
		        	
			}
		};

		Listener solveListener =new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				view.notifyMe("solve");			
			}
		};
		
		Listener stopSolveListener = new Listener(){
			@Override
			public void handleEvent(Event arg0) {
				mazeDisplay.newSolve(false);			
			}
		};
		
		Listener instructionsListener = new Listener(){
			@Override
			public void handleEvent(Event arg0) {
				DialogMessage dm = new DialogMessage(shell,  "The instructions are:use your arrows \nand page up and down to move and\nhelp to superman find wonderwoman");
				dm.open();
			}
		};
		
		Listener aboutListener = new Listener(){
			@Override
			public void handleEvent(Event arg0) {
				DialogMessage dm = new DialogMessage(shell,"It is aviv gold 3dMaze Game enjoy!");
				dm.open();
			};
		
		};
		Listener hintItemListener = new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				DialogMessage dm = new DialogMessage(shell,"Wonder woman in floor:"+mazeDisplay.getExitY());
				dm.open();
			}
			
		};
		Listener saveMazeItemListener = new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				SaveLoadMazeDialog slm = new SaveLoadMazeDialog(g,shell,"Save Maze","Enter the maze name here:","Enter the file name here:");
				slm.open();
			}
			
		};
		Listener loadMazeItemListener = new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				SaveLoadMazeDialog slm = new SaveLoadMazeDialog(g,shell,"Load Maze","Enter the file name here:","Enter the maze name here:");
				slm.open();
			}
			
		};
		
		Listener newConnectionListener = new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				view.notifyMe("newConnection");
			}
		};
		
		newConnection.addListener(SWT.Selection, newConnectionListener);
		loadMazeItem.addListener(SWT.Selection,loadMazeItemListener);
		saveMazeItem.addListener(SWT.Selection,saveMazeItemListener);
		hintItem.addListener(SWT.Selection, hintItemListener);
		aboutItem.addListener(SWT.Selection, aboutListener);
		instructionsItem.addListener(SWT.Selection, instructionsListener);
		shell.addListener(SWT.Close, exitListener);
		exitItem.addListener(SWT.Selection, exitListener);
		generateItem.addListener(SWT.Selection, generateListener);
		openPropertiesItem.addListener(SWT.Selection, propertiesListener);
		solveItem.addListener(SWT.Selection, solveListener);
		stopSolveItem.addListener(SWT.Selection, stopSolveListener);
		shell.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent key) {
				if(!mazeDisplay.isSolving())
					switch(key.keyCode)
					{
					case SWT.ARROW_DOWN:
						mazeDisplay.moveBack();
						break;
					case SWT.ARROW_UP:
						mazeDisplay.moveForward();
						break;
					case SWT.ARROW_LEFT:
						mazeDisplay.moveLeft();
						break;
					case SWT.ARROW_RIGHT:
						mazeDisplay.moveRight();
						break;
					case SWT.PAGE_UP:
						mazeDisplay.moveUp();
						break;
					case SWT.PAGE_DOWN:
						mazeDisplay.moveDown();
						break;
					}	
			}
		});
		shell.addMouseWheelListener(new MouseWheelListener(){

			@Override
			public void mouseScrolled(MouseEvent arg0) {
				if((arg0.stateMask & SWT.CTRL)!=0){ 
					mazeDisplay.setScale(mazeDisplay.getScale()+(arg0.count/3)/10.0);
					mazeDisplay.redraw();
				}	
			}
		});
	}

	/**
	 * In this mehod we call to the set Solution method into the view and we are passing
	 *  the Solution from the parm.
	 * @param Solution<Position> - the Solution we are passing to the view.
	 */
	@Override
	public void setMessage(Solution<Position> sol) {
		mazeDisplay.displaySolution(sol);
		
	}

}