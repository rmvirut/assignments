#using python version 3.5.2
import time
import threading


# -------------------------
# load this file into python. It creates three threads which print time of day every three seconds.
# They continue to do this until the user enters ^c. That is caught by the main loop which is set to
# receive input from the keyboard. The error trap changes the exit variable from 0 to 1 which causes
# all the threads to exit.
# for more information just google "python threads example"
#-----------------------------

import time
import threading

# --- set up a variable that all parts can use to exit
exit = 0

# --- function that runs in the thread
def print_time(threadName,delta):
   while exit == 0:
      time.sleep(delta)
      print("%s: %s" % ( threadName, time.ctime(time.time()) ))
   print("exiting:"+threadName)

# --- create as many threads as you like
t = []
for i in range(1,3):
   try:
      tName = "Thread"+str(i)
      print("Starting:"+tName)
      x = threading.Thread(name=tName, args=(tName,i), target=print_time)
      x.start()
      t.append(x)
      time.sleep(0.1);
   except:
      print("Error: unable to start thread")

print("============== all threads running ==================")
while exit == 0:
   try:
      time.sleep(1);
      print("Main is looping. Press ^C to exit. Threads are:")
      print(t)
   except:
      print("caught exception")
      exit = 1

print("exiting main")

