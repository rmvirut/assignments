Testing
=======
Case 1: What if a philosopher comes late? Are they starved?

The function randTime() for the Philosopher class used together with the functions think() and eat()
to produce variable eating and thinking times. Visual observation of the results shows non single
Philosopher goes without a turn at the table.

Case 2: Are the results constant or do they vary at each runtime?

Beyond the start when all Philosophers begin to think and get hungry, they are not always hungry at
the same time. This again is due the the inclusion of the randTime() method which ensures variable
execution time. Eg P1 may get hungry after 2 seconds but on the next cycle, this may be after 10 seconds
but this does not stop the adjacent Philosophers P0 and P2 from eating since they share forks.

Case 3: Is a Philosopher being starved for too long?

With randomness removed by setting the eating and thinking time to a fixed value (2000) for a more consistent
result, no Philosopher was starved for "too long" which I defined to be having your adjacent Philosophers go
past you in the waiting queue more than once.

Case 4: Is there a deadlock?

No. No deadlocks were observed during testing and before submission of the work.

Case 5: Can any pair of adjacent philosophers be found eating at the same time?

Edit code to cause all other philosophers besides 0 and 1 to pause and leave the two such that they have to share the fork between them
and P0's left fork is also P1's right fork.
During testing, there was never a case where the fork was being used by both Philosophers and no one went ahead of the other.


Screen shots
============
There is a pdf file included in the files with a sample output of the program