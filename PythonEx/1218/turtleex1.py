'''
Created on 2018. 12. 18.
turtleex1.py : GUI κ΄?? ¨ ?¨?€μ§?
@author: gdj-4
'''
import random
from tkinter.simpledialog import *
import turtle


inStr = ""
swidth, sheight = 300, 300
tx,ty,txtsize = [0]*3
#GUI ???° ?€? 
turtle.title("κ±°λΆ κΈ???°κΈ?")
turtle.shape("turtle")
turtle.setup(width=swidth+50,height=sheight+50)
turtle.screensize(swidth, sheight)
turtle.penup() #κΈ???°κΈ?
#???μ°? μΆλ ₯
inStr=askstring("λ¬Έμ?΄ ?? ₯","κ±°λΆ?΄κ°? ?Έ λ¬Έμ?΄? ?? ₯??Έ?") #tkinter.simpledialog ?¨?€μ§?? λ©μΈμ§?(dialogμ°?)
for ch in inStr :
    tx = random.randrange(-swidth/2, swidth/2)
    ty = random.randrange(-sheight/2, sheight/2)
    # random.random() : 0 <= num < 1.0
    r = random.random()
    g = random.random()
    b = random.random()
    txtsize = random.randrange(10,50)
    turtle.goto(tx,ty)
    turtle.pencolor((r,g,b)) # pencolor : ?΄λΆ??? 255λ₯? κ³±ν?€.
    turtle.write(ch,font=("λ§μ? κ³ λ",txtsize,"bold"))
turtle.done()


