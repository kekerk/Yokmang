'''
Created on 2018. 12. 18.
turtleex1.py : GUI ê´?? ¨ ?Œ¨?‚¤ì§?
@author: gdj-4
'''
import random
from tkinter.simpledialog import *
import turtle


inStr = ""
swidth, sheight = 300, 300
tx,ty,txtsize = [0]*3
#GUI ?œˆ?„?š° ?„¤? •
turtle.title("ê±°ë¶ ê¸???“°ê¸?")
turtle.shape("turtle")
turtle.setup(width=swidth+50,height=sheight+50)
turtle.screensize(swidth, sheight)
turtle.penup() #ê¸???“°ê¸?
#???™”ì°? ì¶œë ¥
inStr=askstring("ë¬¸ì?—´ ?…? ¥","ê±°ë¶?´ê°? ?“¸ ë¬¸ì?—´?„ ?…? ¥?•˜?„¸?š”") #tkinter.simpledialog ?Œ¨?‚¤ì§??˜ ë©”ì„¸ì§?(dialogì°?)
for ch in inStr :
    tx = random.randrange(-swidth/2, swidth/2)
    ty = random.randrange(-sheight/2, sheight/2)
    # random.random() : 0 <= num < 1.0
    r = random.random()
    g = random.random()
    b = random.random()
    txtsize = random.randrange(10,50)
    turtle.goto(tx,ty)
    turtle.pencolor((r,g,b)) # pencolor : ?‚´ë¶??—?„œ 255ë¥? ê³±í•œ?‹¤.
    turtle.write(ch,font=("ë§‘ì? ê³ ë”•",txtsize,"bold"))
turtle.done()


