
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleShell {

    public static final File HOME_DIRECTORY = new File(System.getProperty("user.dir"));
    public static File CURRENT_DIRECTORY = new File(System.getProperty("user.dir"));

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

            ArrayList<String> cmdList = new ArrayList<>(Arrays
                    .asList(commandLine.split(" ")));
            boolean closeShell = cmdList.get(0).equalsIgnoreCase("exit")
                    || cmdList.get(0).equalsIgnoreCase("quit");

            boolean cdCmd = cmdList.get(0).equals("cd");

            // close program if quit/exit is entered
            if (closeShell) {
                System.out.println("Terminating Shell...");
                System.exit(0);
            }

            //check if it's a cd command
            if (cdCmd) {
                //no directory provided so set to user directory
                if (cmdList.size() == 1) {
                    CURRENT_DIRECTORY = HOME_DIRECTORY;
                } else {//set to new directory given param
                    CURRENT_DIRECTORY = newDirectory(cmdList.get(1));
                }
            } else {

                ProcessBuilder psBuilder = new ProcessBuilder(cmdList)
                        .directory(CURRENT_DIRECTORY);

                try {
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

    public static File newDirectory(String path) {
        String filePath;

        if (path.equals("..") || path.equals("../")) {
            filePath = CURRENT_DIRECTORY.getParent();
        } else {
            filePath = CURRENT_DIRECTORY.getPath()
                    + (path.charAt(0) == '/' ? "" : "/") + path;
        }

        File dir = new File(filePath);
        if (dir.exists()) {
            return dir;
        }
        System.out.println("The directory doesn't exist. Us \"ls\" to view them");
        return CURRENT_DIRECTORY;
    }
}
