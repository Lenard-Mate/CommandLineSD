
import commandexecutor.CLIExecutor;
import commandexecutor.RMICommandExecutor;
import fileexplorer.FileExplorerImpl;
import fileexplorer.FileExplorer;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NodeServer {

    public static void main(String args[]) {

        try {

            Registry registry = LocateRegistry.createRegistry(1099);

            RMICommandExecutor commandExecutor = new CLIExecutor(new FileExplorerImpl());
            Naming.rebind("rmi://localhost:1099/CalculatorService", commandExecutor);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }

    }
}
