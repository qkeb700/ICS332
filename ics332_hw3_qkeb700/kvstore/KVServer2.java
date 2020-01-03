package kvstore;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.io.*;

public class KVServer2 extends UnicastRemoteObject implements KVInterface {
	
	private static final String serverName = "rmi://localhost/Server";
	HashMap<String, String> kvds = new HashMap<>();
                // Custom constructor that throws the required exception						
   	protected KVServer2() throws RemoteException {				
    		super();												}	
				//                     @Override				
	public void insert(String key, String value) throws RemoteException {							kvds.put(key, value);
	}				
				//                                 @Override	
	public String lookup(String key) throws RemoteException, KeyNotFound {			
		String result;				
		if(kvds.containsKey(key))	
		{
			result = kvds.get(key);
		}else result = "Unknown key";

		return result;
	}
											
	public void shutdown() throws RemoteException  {					
		try{
			// Unregister ourself
			Naming.unbind(serverName);
			// Unexport; this will also remove us from the RMI runtime
			UnicastRemoteObject.unexportObject(this, true);
			System.out.println("KVServer: exiting!");
		} catch(Exception e) {
			// too bad						
		  }	
	}	
	private static Boolean isRmiRunning(){
		Boolean flag = false;
		String[] tokens = ("ps -o pid= -C rmiregistry").split("[ \t\n]+");
		Process p = null;
		ProcessBuilder pb = new ProcessBuilder(tokens);

		try {
			p = pb.start();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

		InputStream sstdout = p.getInputStream();
		BufferedReader stdout = new BufferedReader(new InputStreamReader(sstdout));

		String output_line;
		try {
			output_line = stdout.readLine();
			if(output_line == null) {
				flag = false;
			} else {
			  	flag = true;
			}
		} catch (Exception e) {
		
		}
		return flag;
	}
	
	private static void startingRmi() {
		Process p = null;
		ProcessBuilder pb = new ProcessBuilder("rmiregistry");
		
		try {
		    p = pb.start();
		    Thread.sleep(1000); // sleep for one second
		} catch (Exception e) {
			//Too bad
		}
	}

	public static void main(String[] args) {
		if(isRmiRunning()) {
			System.out.println("KVServer: RMI Registry already running!");
	        } else {
			System.out.println("KVServer: Starting RMI Registry...");
       		        System.out.println("KVServer: RMI Registry started");
			startingRmi();		       
		}

		try {			
			// Register myself to the RMI Registry			
			System.err.println("KVServer: Registering to RMI Registry...");			
			Naming.rebind(serverName, new KVServer());
			System.err.println("KVServer: Registered to RMI Registry...");              
		} catch (Exception e) {						
			System.err.println("KVServer: exception: " + e.toString());
			e.printStackTrace();						
			System.exit(0);				
		}						
	}
}
