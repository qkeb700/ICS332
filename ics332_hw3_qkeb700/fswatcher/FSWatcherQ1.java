package fswatcher;

import java.io.*;
import java.util.function.*;

public class FSWatcherQ1 {
	public void watch(String dirname, Consumer<String> method) {
		String[] tokens = ("inotifywait -e create -m " + dirname).split("[ \t\n]+");
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

