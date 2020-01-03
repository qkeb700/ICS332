F.q1.20
    4*5(2000/125) + 3600 + 4*5(2000/1250) <- top level tasks 
    + 4*5(2000/1250) + 300 + (2000/125) <- bottom level tasks
    = 3952 + 348 = 4300

F.q1.21
    Execution time from q1.16 = 15100
    Execution time from q1.20 = 4300
    15100/4300 = 3.511..... faster. 

F.q1.22
    Formula of parallel efficiency is (Execution time on single core)/(#cores * Execution time on multiple cores)
    72700/(32 * 4300) = 0.528343.... -> 52.83% 

F.q1.23
    On 4 5 core compute nodes, the parallel efficiency would have been 84.53% because once the number of cores decreased, the parallel efficiency would become more efficent. 

F.q1.24
    No, it is not possible. no matter how many cores you add, the workflow execution time will be the same.

F.q1.25
    The minimum number would be 7 because we have total 21 tasks to execute, so if the minimum number is 7, then we can execute all the tasks at the same time. That is, fastest possible execution time.