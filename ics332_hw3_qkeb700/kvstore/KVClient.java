package kvstore;
import java.rmi.*;

public class KVClient {
	public static void main(String[] args) {
		try {
			KVInterface kvi = (KVInterface)Naming.lookup("rmi://localhost/Server");

			switch(args[0])
			{
				case "insert":
					if(args.length == 3)
					{
						kvi.insert(args[1], args[2]);
					}
					else
					{
						System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
					}
					break;

				case "lookup":
					if(args.length == 2)
					{
						System.out.println(kvi.lookup(args[1]));
					}
					else
					{
						System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
					}
					break;

				case "shutdown":
					if(args.length == 1)
					{
						kvi.shutdown();
					}
					else
					{
						System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
					}
					break;

				default:
	 				System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
					break;
			}
		} catch(Exception e){
			System.out.println("Usage: java kvstore.KVClient [ shutdown | insert <key> <value> | lookup <key> ]");
		}
	}
}

