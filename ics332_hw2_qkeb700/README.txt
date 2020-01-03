Exercise1

q1. The reason why the main process is not blocked is because when the fork() is called, the main process gets copied itself called child process. And, they run independently. Parents processes return its child's PID, and child processes return 0 when fork() is called.

q2. No zombie is left over because wait() blocks the calling process until one of its child processes exits or a signal is received. 

Exercise2

q1. 40sec
q2. 50sec
q3. 11
q4. 11
q5. 30sec
q6. 20sec
q7. 89
q8. 11
q9. 11, 89, 123