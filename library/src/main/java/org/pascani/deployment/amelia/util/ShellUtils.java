package org.pascani.deployment.amelia.util;

/**
 * This class encapsulates utility methods to work with shell interfaces
 * 
 * @author Miguel Jiménez - Initial contribution and API
 */
public class ShellUtils {

	/**
	 * TODO: Only bash, zsh and dash are supported (not csh)
	 * 
	 * @return The command to recognize the current shell being used by a UNIX
	 *         machine
	 */
	public static String currentShellCommand() {
		return "echo $0 | cut -c 2-";
	}

	/**
	 * Creates a string to set the prompt to a reliable prompt, that is, a
	 * unique string not commonly returned by any process. By changing the
	 * prompt, the probability of mistaken expected outputs is considerably
	 * reduced.
	 * 
	 * TODO: Only bash and zsh are supported
	 * 
	 * @param shell
	 *            The current shell being used in the remote machine
	 * @return a command setting the PS1 environment variable to the Amelia
	 *         prompt
	 */
	public static String ameliaPromptFormat(String shell) {

		// e.g., [Amelia library 2015-09-28 18:54:34 user@grid0:~/Desktop]$
		String bash = "[Amelia library \\D{%F %T} \\u@\\h:\\w]$ ";
		String zsh = "[Amelia library %D{%Y-%m-%d %H:%M:%S} %n% @%m% :%~]$ ";

		String command = "PS1=\"";

		if (shell.contains("bash"))
			command += bash + "\"";
		else
			command += zsh + "\"";

		return command;
	}

	/**
	 * @return the regular expression to recognize the Amelia prompt
	 */
	public static String ameliaPromptRegexp() {
		String date = "(\\d+){4}-(\\d+){2}-(\\d+){2}";
		String time = "(\\d+){2}:(\\d+){2}:(\\d+){2}";
		String user = "([a-z_][a-z0-9_]{0,30})";
		String host = "([a-zA-Z0-9-\\.]{0,24})";
		String directory = "(/)?([^/\0]+(/)?)+";

		StringBuilder regexp = new StringBuilder();

		regexp.append("\\[Amelia library ");
		regexp.append(date + " ");
		regexp.append(time + " ");
		regexp.append(user);
		regexp.append("@");
		regexp.append(host + ":");
		regexp.append(directory);
		regexp.append("\\]\\$ ");

		return regexp.toString();
	}

}
