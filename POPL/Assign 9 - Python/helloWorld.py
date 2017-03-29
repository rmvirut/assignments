#using python 3.5.2 with tkinter library including ttk extension

from tkinter import *
from tkinter import ttk

def close_me():
    exit(0)

root = Tk()
root.minsize(250, 250)
root.maxsize(250, 250)
root.resizable(width=False, height=False)
root.title("Hello World")

mainframe = ttk.Frame(root, width=245, height=245)
mainframe.columnconfigure(0, weight=1)
mainframe.rowconfigure(0, weight=1)
text = ttk.Label(root, text="Hello World").grid(column = 0, row=1)
okButton = ttk.Button(root, text="Ok", command=close_me).grid(column =0, row = 2)
root.mainloop()