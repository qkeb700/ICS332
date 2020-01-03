package fswatcher;

import java.io.*;
import java.util.function.*;

public class FSWatcherQ2 {
    
	public class Worker implements Runnable {
		private BufferedReader stdout;
		private Consumer<String> method;

		public Worker(BufferedReader stdout, Consumer<String> method) {
			this.stdout = stdout;
			this.method = method;
		}

		public void run() {
			String output_line;

			while(true) {
				try {
					output_line = stdout.readLine();
					if(output_line == null) {
						break;
					} else {
						method.accept(output_line);
					}
				} catch (IOException e) {
				
				}
			}
		}
	}

	public void watch(String dirname, Consumer<String> method) {

		Worker workers;
		Thread threads;
		String[] tokens = ("inotifywait -e create -m " + dirname).split("[ \t\n]+");
		Process p = null;
		ProcessBuilder pb = new ProcessBuilder(tokens);

		try {
			p = pb.start();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		InputStream sstout = p.getInputStream();
		BufferedReader stdout = new BufferedReader(new InputStreamReader(sstout));

		workers = new Worker(stdout, method);
		threads = new Thread(workers);
		threads.start();
	}
}


	       	
