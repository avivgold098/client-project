package presenter;

import java.io.Serializable;
/**
 * This is the class that presented the properties of our project.
 * In this class we have all the properties we needs from build maze, and all the settings we needs
 * for building our project.
 * It is very useful because now we don't need every compilation update our source code. Now we have only
 * to update our properties and reads them from xml file.
 * @author HP
 *
 */
public class Properties implements Serializable{
	
	private static final long serialVersionUID = 42L;
	/**
	 * the x limit of the maze
	 */
	int x;
	/**
	 * the y limit of the maze
	 */
	int y;
	/**
	 * the z limit of the maze
	 */
	int z;
	/**
	 * the name of the maze
	 */
	String name;
	/**
	 * the user choice between gui and cli.
	 */
	String uc;
	/**
	 * the ip for connection.
	 */
	String ip;
	/**
	 * the port for connection.
	 */
	int port;
	/**
	 * the ctor of the class that set all the class data members.
	 */
	public Properties() {
		this.x = 5;
		this.y = 5;
		this.z = 5;
		this.name = "Maze14";
		this.uc = "GUI";
		this.port = 5400;
		this.ip = "127.0.0.1";
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the uc
	 */
	public String getUc() {
		return uc;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param uc the uc to set
	 */
	public void setUc(String uc) {
		this.uc = uc;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}



	

}