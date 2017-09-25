import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleShell {

    public static void main(String[] args) throws java.io.IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // we break out with <control><C>
        while (true) {
            // read what they entered
            System.out.print("jsh>");
            commandLine = console.readLine();

            // if they entered a return, just loop again
            if (commandLine.equals(""))
                continue;

            ArrayList<String> cmdList = new ArrayList<String>(Arrays.asList(commandLine.split(" ")));
            boolean closeShell = cmdList.get(0).equalsIgnoreCase("exit") || cmdList.get(0).equalsIgnoreCase("quit");

            // close program if quit/exit is entered
            if (closeShell) {
                System.out.println("Terminating Shell...");
                System.exit(0);
            }


            ProcessBuilder psBuilder = new ProcessBuilder(cmdList);
            try {
                Process ps = psBuilder.start();
                InputStream is = ps.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String psOutput;
                while((psOutput = br.readLine()) != null){
                    System.out.println(psOutput);
                }
            } catch (IOException e) {
                System.out.println("You entered an invalid command");
            }

            /**
             The steps are:
             (1) parse the input to obtain the command
             and any parameters
             (2) create a ProcessBuilder object
             (3) start the process
             (4) obtain the output stream
             (5) output the contents returned by the command
             */

        }
    }
}
