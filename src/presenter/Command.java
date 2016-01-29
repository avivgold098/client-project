package presenter;
/**
 * This is the command interface that the one method.
 * With this single method, we implements all the different commands by implements the do command
 * methods different each time for the command we want.
 * @author HP
 *
 */

public interface Command {
	/**
	 * This is the common method for all the different commands.
	 * In this method we implements some command, and then we sent the message according to the case.
	 * @param str - with this string interpret the parms for the command.
	 */
	void doCommand(String str);
}