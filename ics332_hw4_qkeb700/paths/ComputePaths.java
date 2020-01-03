package paths;

public class ComputePaths {
	private static Worker worker;
	private static Thread threads[] = new Thread[10];
	public class Worker implements Runnable {
		private int graphSize, graphStart, graphEnd;

		public Worker(int graphSize, int graphStart, int graphEnd) {
			this.graphSize = graphSize;
			this.graphStart = graphStart;
			this.graphEnd = graphEnd;
		}
		public void run() {
			for(int i = graphStart; i < graphEnd; i++) {
				new FloydWarshall(graphSize, i).floydWarshall();
			}
		}		
	}

    	public void compute(int graph_size, int num_threads) {
		int num_divided_threads = 2520/num_threads;
		int dividedStart = 0;
		int[] array = new int[num_threads];
		array[0] = num_divided_threads;
		if(num_threads != 1) {			
		    for(int i = 0; i < num_threads; i++) {
		 	    worker = new Worker(graph_size, dividedStart, num_divided_threads);
			    threads[i] = new Thread(worker);
			    threads[i].start();
			    dividedStart = num_divided_threads;
			    num_divided_threads += array[i];
		    }
	    
		    for(int i = 0; i < num_threads; i++) {
			    try {
				    threads[i].join();
			    } catch (Exception e) {
				   System.err.println("Error occured: " + e);
			    } 
			}
		    } 

		else {			
		    for (long i = 0; i < 2520; i++) {
			    new FloydWarshall(graph_size, i).floydWarshall();
		    }
		}
	}

	public static void main(String[] args) {		        
		if (args.length != 2) {
			System.err.println("Usage: java ComputePaths <graph size> <# threads>");
	  		System.exit(1);
		}

		int graph_size = 0;
		int num_threads = 0;
		try {
			graph_size = Integer.parseInt(args[0]);
			num_threads = Integer.parseInt(args[1]);
			if ((graph_size <= 0) || (num_threads < 1)) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid command-line arguments");
			System.exit(1);
		}

		double now = System.currentTimeMillis();
		new ComputePaths().compute(graph_size, num_threads);
		System.out.println("All graphs computed in " + (System.currentTimeMillis() - now) / 1000 + " seconds");
	}
}
