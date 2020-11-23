
import commandexecutor.RMICommandExecutor;
import fileexplorer.FileExplorer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RMIClient {

    public static void main(String[] args) throws IOException, NotBoundException {

        // determine the machine of the server
        String serverName;
        if (args.length == 0) {
            serverName = "127.0.0.1";
        } else {
            serverName = args[0];
        }
        String rmiName = "rmi://" + serverName + "/CalculatorService";

        System.out.println("Connecting to: " + rmiName);
         RMICommandExecutor c = (RMICommandExecutor) Naming.lookup(rmiName);
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
           
            System.err.print("Write your command here:");
            String name = reader.readLine();
            System.out.println(name);
            System.out.println(c.execute(name));

        }
        
        
        
    }
    public String textToWrite() throws IOException{
        
        BufferedReader newText = new BufferedReader(new InputStreamReader(System.in));
        
        return newText.readLine();
        }
}
