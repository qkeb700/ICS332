Q1. the graph size that I found is 190, and it runs at 27 sec

Q3. Average execution time
    Thread	1 : 28.17
		2 : 15.182
		3 : 9.818
		4 : 7.434
		5 : 6.065
		6 : 4.836
		7 : 4.212
		8 : 3.676
		9 : 3.341
		10: 3.032
  
    q1. Using 1 thread takes 28.17 whereas using 2 threads takes 15.182. Therefore, using 2 threads 
	when compared to using 1 thread (28.17 / 15.182) is 1.8x faster.

    q2. I have 4 cores on my machine
    
    q3. No, using more threads than the number of physical cores (4 in my case) is not useful. The more 	threads I use, the slightly faster it goes.

    q4. The largest acceleration factor I observer is when I use 2 threads in 1.8x time faster. 
	Threads seem useful when its number doesn't exceed the number of cores on the machine.
