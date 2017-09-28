
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleShell {

    public static final File HOME_DIRECTORY = new File(System.getProperty("user.dir"));
    public static File CURRENT_DIRECTORY = new File(System.getProperty("user.dir"));
    public static ArrayList<ArrayList> history = new ArrayList<>();
    public static final String PREVEXP = "![1-9]{1,}";
    public static final String QUITEXP = "quit|exit";

    public static void main(String[] args) throws java.io.IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // we break out with <control><C>
        while (true) {

            // read what they entered
            System.out.print("jsh>");
            commandLine = console.readLine();

            // if they entered a return, just loop again
            if (commandLine.equals("")) {
                continue;
            }

            //split command into arrays
            ArrayList<String> cmdList = new ArrayList<>(Arrays
                    .asList(commandLine.split(" ")));
            String cmd = cmdList.get(0);

            // close program if quit/exit is entered
            if (cmd.matches("quit|exit")) {
                System.out.println("Terminating Shell...");
                System.exit(0);
            } //run the most recent command
            else if (cmd.matches("!!")) {
                cmdList = history.size() > 0 ? history.get(history.size() - 1) : null;
            } //run the command in this point of history
            else if (cmd.matches(PREVEXP)) {
                int index = Integer.parseInt(cmd.substring(1));
                if (index > history.size()) {
                    continue;
                }
                updateHistory(cmdList = history.get(index - 1));
            } //change directory command
            else if (cmd.matches("cd")) {
                //no directory provided so set to user directory
                if (cmdList.size() == 1) {
                    CURRENT_DIRECTORY = HOME_DIRECTORY;
                } else {//set to new directory given param
                    CURRENT_DIRECTORY = newDirectory(cmdList.get(1));
                }
            }

            //add command and params to the history if not repeated
            if (!lastCmdSame(cmdList) || !cmdList.get(0).matches("!!|" + PREVEXP)) {
                history.add(cmdList);
            }

            if (cmdList.get(0).equals("history")) {
                while (cmdList.get(0).equals("history")) {
                    //execute sub-program for history until new command
                    cmdList = viewHistory(console);
                }
            } else if (cmdList.get(0).matches("!!")) {
                if (history.get(history.size() - 1).equals("history")) {

                    while (cmdList.get(0).equals("!!")) {
                        //execute sub-program for history until new command
                        cmdList = viewHistory(console);
                    }

                } else {
                    cmdList = history.get(history.size() - 1);
                }

            } else if (cmdList.get(0).matches("![0-9]{1,}")) {
                int index = Integer.parseInt(cmdList.get(0).substring(1));
                if (history.get(index).equals("history")) {
                    viewHistory(console);
                } else {
                    cmdList = history.get(index);
                }
            } else {

                try {
                    //create process builder with current directory
                    ProcessBuilder psBuilder = new ProcessBuilder(cmdList)
                            .directory(CURRENT_DIRECTORY);
                    Process ps = psBuilder.start();
                    InputStream is = ps.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String psOutput;
                    while ((psOutput = br.readLine()) != null) {
                        System.out.println(psOutput);
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("You entered an invalid command");
                }
            }
        }
    }

    /**
     * Sets the programs current directory relative the the home directory
     * and/or any new directory the client enters.
     *
     * @param path should be entered as a valid dir/path to a file.
     * "/[location]" or "location" formats are accepted
     * @return the new path as a current directory. defaults to home directory
     * if no path was supplied from user
     */
    public static File newDirectory(String path) {
        String filePath;

        if (path.equals("..") || path.equals("../")) {
            filePath = CURRENT_DIRECTORY.getParent();
        } else {
            filePath = CURRENT_DIRECTORY.getPath()
                    + (path.charAt(0) == '/' ? "" : "/") + path;
        }
        //check if directory exists
        File dir = new File(filePath);
        if (dir.exists()) {
            return dir;
        }
        System.out.println("The directory doesn't exist. Us \"ls\" to view them");
        return CURRENT_DIRECTORY;
    }

    /**
     * View history is a sub-program that allows the user to view and execute a
     * previous command they've already tried.
     *
     * @param console input buffer to read input from user
     * @return if user enters digit, the program returns the cmd at the
     * specified index which was printed beforehand, and if the user enters a
     * different command, then it's added to history and the method closes.
     * @throws IOException
     */
    public static ArrayList<String> viewHistory(BufferedReader console)
            throws IOException {
        int index = 1;
        for (ArrayList<String> cmd : history) {
            System.out.println(index + " " + cmd.toString()
                    .replaceAll("[\\[\\]]", " ")
                    .replaceAll("[,]", ""));
            index++;
        }

        //resume console prompt
        System.out.print("jsh>");
        String choice = console.readLine();

        if (choice.matches("[1-9]{1,}")) {
            //if the choice was a number then pick comman from the history
            return history.get(Integer.parseInt(choice) - 1);
        } else {
            //add the command to history and return to original program
            if (!choice.equals("history") && choice.matches("[A-Za-z]{1,}")) {
                history.add((ArrayList<String>) Arrays.asList(choice.split(" ")));
            } else if (choice.matches("![1-9]{1,}")) {
                int i = Integer.parseInt(choice.substring(1));
                return history.get(i - 1);
            }
            return history.get(history.size() - 1);
        }
    }

    /**
     * Check if the last command in history is the same as the newest
     *
     * @param cmd
     * @return True if the last command in history is the same as the current
     * and False of the history is less than 1 or same as the current
     */
    public static boolean lastCmdSame(ArrayList<String> cmd) {
        if (history.isEmpty()) { //if history is empty return false
            return false;
        }
        return history.get(history.size() - 1).equals(cmd);
    }

    /**
     * Updates the history static variable belonging to the class. Will not
     * change make the change if the last command is same as the current
     *
     * @param cmd current/new command given to the console
     */
    public static void updateHistory(ArrayList<String> cmd) {
        if (lastCmdSame(cmd)) {
            history.add(cmd);
        }
    }

    public static void execCmd(ArrayList<String> cmdList) throws IOException {
        try {
            //create process builder with current directory
            ProcessBuilder psBuilder = new ProcessBuilder(cmdList)
                    .directory(CURRENT_DIRECTORY);
            Process ps = psBuilder.start();
            InputStream is = ps.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String psOutput;
            while ((psOutput = br.readLine()) != null) {
                System.out.println(psOutput);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("You entered an invalid command");
        }
    }
}
