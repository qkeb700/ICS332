package fswatcher;

import java.io.*;
import java.util.function.*;
import java.util.*;

public class FSWatcherQ3 {
	private static Map<String, Process> mapedWatch = new HashMap<>();
	public void watch(String dirname, Consumer<String> method) {
		
		String[] tokens = ("inotifywait -e create -m " + dirname).split("[ \t\n]+");
		Process p = null;
		ProcessBuilder pb = new ProcessBuilder(tokens);

		try {
			p = pb.start();
			mapedWatch.put(dirname, p);

		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

	}
	
	public void stopWatch(String dirname) {
		mapedWatch.get(dirname).destroy();
	}
}
