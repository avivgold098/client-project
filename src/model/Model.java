package model;


import presenter.Properties;

/**
 *This is the interface of our model in the mvp.
 *In the mvp the model role is Declare that something happened and then forward this changed to the 
 *Presenter, but here first we are talking with the server and then forward to the presenter.
 *In this interface we Declare on all our methods we are going to use, and also implements 
 * @author Aviv Gold
 */
public interface Model {
	/**
	 * this method doing a safe exit of our server client connection.
	 * and also close all the open files and also saved the files we needs.
	 * @return void
	 */
	void exit();
	/**
	 *  this method is print all the files and and the folders into the path we sent.
	 *  this method is first locate the file and than we can use the method list that
	 *  return to us the path.
	 *  @param path- our path for the method.
	 */
	void dir(String path);
	/**
	 * In This method we forward to the server the maze we want to get solution to him.
	 * After the server end to create the soul, we reading the string of the soul,
	 * and than make a soul from this string.
	 * In the end we forward the soul to the controller.
	 */
	void solve(String name,String algorithm);
	/**
	 * In this method we  display the solution of the maze with his name.
	 * First we checked if the the name of  our hash soul is contains the the soul for this name.
	 * So we sent to the controller notification or the soul to string,  according to the case.
	 * @param name - the name of the maze to get the soul for him.
	 */
	void displaySolution(String name);
	
	/**
	 *  In this method we used the parms of the maze name and his limits.
	 *  First we checked if the maze is exist in our load hash .
	 *  If the maze exist in our hash map we only to sent notification to the controller
	 *  that the maze is ready.
	 *  If the maze is not exist in our load hash, we sent to the server the parm and waiting for the generate
	 *  of the maze.
	 *  After the server done the generate we read the bytes and then create 3dmaze with ctor of the byte[].
	 *  In the end we put the the maze and string in hash of <string,3dmaze>.
	 * @param name - the name of the maze we create/
	 * @param y- the high of our maze.
	 * @param z- the number of lines we in every floor in our maze.
	 * @param x- the length of every floor in our maze.
	 * *  In the end we sent notification according to the case if we succeed to build the maze or 
	 *  not.
	 */
	void generate3dMaze(String name,int y, int z, int x);
	
	/**
	 * This method is getting name of maze and then convert the maze with this name to String,
	 * we are getting the maze from the our hash map of maze and string, or by our properties.
	 * @param name -the name of the maze.
	 */
	void display(String name);
	
	/**
	 * In this method we display any cross section the user wants. By creating int[][] of this 
	 * cross section in our maze.
	 * we distinguish between the different cross section with switch case.
	 * @param by - the section we wants x,y,z.
	 * @param index - the index in this section.
	 * @param name - the name of  the maze we make for him the cross section.
	 */
	void displayCrossSectionBy(String by, int index, String name);
	
	/**
	 * This method save maze into file that we sent his name.
	 * first of all we checked if this maze its exist and then according to the case we forward message
	 * to the controller
	 * @param name- the name of the maze.
	 * @param fileName- the name of the file.
	 */
	void saveMaze(String name,String fileName);
	
	/**
	 * This method load Maze from file that we sent his name.
	 * By reading the bytes we create maze using the ctor of 3dMaze(with byte[]).
	 * @param fileName- the file we are reading from him the maze.
	 * @param name- the name of the maze we loaded.
	 * In the end we sending notification according to the case to the controller.
	 */
	void loadMaze(String fileName,String name);
	
	/**
	 * In this method we calc the Maze3d size, the class side, by getting the name of the maze
	 * in the parm we are getting the maze and then using formula we create we calc the maze size.
	 * In the end we sending 
	 * of the specific maze  message to controller with the maze size or notification that the maze
	 * is not exist.
	 * @param name - the name of the maze.
	 */
	void mazeSize(String name);
	
	/**
	 * In this method we calc the size of the file that contains our maze.
	 * we using the our hash map of maze file for find the file.
	 * and then we calc his size.
	 * In the end we forward to the controller message according to the case if the file found or not.
	 * @param name - The name of the maze.
	 */
	void fileSize(String name);
	/**
	 *  In this method we used the parms of the maze name and his limits.
	 *  First we checked if the maze is exist in our load hash .
	 *  If the maze exist in our hash map we only to sent notification to the controller
	 *  that the maze is ready.
	 *  If the maze is not exist in our load hash, we sent to the server the parm and waiting for the generate
	 *  of the maze.
	 *  After the server done the generate we read the bytes and then create 3dmaze with ctor of the byte[].
	 *  In the end we put the the maze and string in hash of <string,3dmaze>.
	 *  The difference between this type of generate is in this method we using in our
	 *  properties into the mymodel class.
	 *  In the end we sent notification according to the case if we succeed to build the maze or 
	 *  not.
	 */
	void generate3dMaze();
	/**
	 * In This method we forward to the server the maze we want to get solution to him.
	 * The difference between this type of solve is in this method we used our properties.
	 * After the server end to create the soul, we reading the string of the soul,
	 * and than make a soul from this string.
	 * In the end we forward the soul to the controller.
	 */
	void solve();
	/**
	 * In this method we are copied another propertied into our properties data members into
	 * our data member in the class mymodel.
	 * @param properties - the other propertied we copied.
	 */
	void setProperties(Properties properties);
	
	/**
	 * In this method we create a new connection with the client.
	 * First we  Instantiate our sockets and our outToServer and outToServer by using the socket
	 * we create.
	 * In the end we are sending notification if the connection is up or not.
	 */
	void newConnection();


	
}