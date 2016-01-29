package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
/**
 * in this class into the view package we creating our basic windows that could serving us for 
 * every project we wants. So he should to be very generic.
 * @author HP
 *
 */
public abstract class BasicWindow implements Runnable{
	/**
	 * Display in our Window.
	 */
	Display display;
	/**
	 * our shell 
	 */
	Shell shell;
	/**
	 * ctor for the class the initialize  our data members and title of the shell.
	 * @param title - the title for the shell.
	 * @param width - the width of the shell.
	 * @param height - the high of the shell.
	 */
 	public BasicWindow(String title, int width,int height) {
 		display=new Display();
 		shell  = new Shell(display);
 		shell.setSize(width,height);
 		shell.setText(title);
	}
	/**
	 * here we making all our different things in our window. running shell and display.
	 */
 	abstract void initWidgets();
	/**
	 * in this method we are starting the thread of the window
	 */
	@Override
	public void run() {
		initWidgets();
		shell.open();
		// main event loop
		 while(!shell.isDisposed()){ // while window isn't closed

		    // 1. read events, put then in a queue.
		    // 2. dispatch the assigned listener
		    if(!display.readAndDispatch()){ 	// if the queue is empty
		       display.sleep(); 			// sleep until an event occurs 
		    }

		 } // shell is disposed

		 display.dispose(); // dispose OS components
	}
}