Exercise #1
    Question #1
  
    q1. It would be a job B for one infinitely long CPU burst becasuse the job B takes the  majority of the time quantum.

    q2. Job D

    q3. I think that job A is a text editor because it is an example of an interactive process with short CPU bursts which is job A.


    Question #2
  
    q1. IoIoIo IoCCo IoIoIo IoCCo IoIoIo IoCCo

    q2. The number of consecutive milliseconds an I/O bound job spends in the READY state is 5m/s because each I/O bound job has 1ms CPU burst and twice 1ms of execution of the CPU bound job. Thus, the time each job spends in READY state is 5ms. i.e. one job finishs burst and go to ready state and waits for 3 more jobs and 2 CPU bound to finish. then, come back to burst.

    q3. original context-switching overhead in this question is 1ms (0.1ms * 10) and the total time(I + C + o) is 13ms. So, 1/13 * 100 = approximately 7%, but we want this overhead to be 2%. Therefore, 5o/6+5o * 100 = 2% => o = 0.024ms

Exercise #2
    Question #1
   
    q1. Job A ends up to mid queue
	Job B ends up to high queu
	Job C ends up to mid queue
	Job D ends up to low queue
	Job E ends up to low queue

    q2. AAAA BB CCCC DDDD EEEE Since A begins its CPU burst at time 0, Job D is placed in the mid queue at 14 because it begins its CPU burst from at 10 to at 13 but didn't finish. so, it moved down to lower queue.

    Question #2

    q1. AA BBBB AA B AA B AA B because job A's CPU burst is 2ms and I/O burst is 1ms. Thus, job A begins its CPU burst and job B begins its CPU burst during job A's I/O burst. Job b's CPU burst is infinite, so it begins 4ms in the high queue and moves down to the mid queue. While its processing, Job A is ready to begin again. Then, job B only begins one time because it's in the lower queue than job A(I/O 1ms).  

    q2. Yes, it does run job B more than 25%. In the long run, we assume that AA B is repeated 50times. Job A is 100, Job B is 50. So, the total time is 150. Therefore, 50/150 * 100 = aproximately 33%.

    q3. AABBBBAABAAB AABBBBAABAAB AABBBBAABAAB AABBB... repetition