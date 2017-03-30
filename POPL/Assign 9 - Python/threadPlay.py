# using python version 3.6.1


import time
import threading

exit = 0


def set_time():
    global k
    time.sleep(0.01)
    k = time.strftime("%H:%M:%S", time.localtime())


def print_time():
    print(k)


while exit == 0:
    # create the two threads
    thread1 = threading.Thread(group=None, target=set_time, name="global")
    thread2 = threading.Thread(group=None, target=print_time, name="local")
    thread1.start()
    time.sleep(0.5)
    thread2.start()
