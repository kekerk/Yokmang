'''
Created on 2018. 12. 18.
turtleex1.py : GUI �??�� ?��?���?
@author: gdj-4
'''
import random
from tkinter.simpledialog import *
import turtle


inStr = ""
swidth, sheight = 300, 300
tx,ty,txtsize = [0]*3
#GUI ?��?��?�� ?��?��
turtle.title("거북 �??��?���?")
turtle.shape("turtle")
turtle.setup(width=swidth+50,height=sheight+50)
turtle.screensize(swidth, sheight)
turtle.penup() #�??��?���?
#???���? 출력
inStr=askstring("문자?�� ?��?��","거북?���? ?�� 문자?��?�� ?��?��?��?��?��") #tkinter.simpledialog ?��?���??�� 메세�?(dialog�?)
for ch in inStr :
    tx = random.randrange(-swidth/2, swidth/2)
    ty = random.randrange(-sheight/2, sheight/2)
    # random.random() : 0 <= num < 1.0
    r = random.random()
    g = random.random()
    b = random.random()
    txtsize = random.randrange(10,50)
    turtle.goto(tx,ty)
    turtle.pencolor((r,g,b)) # pencolor : ?���??��?�� 255�? 곱한?��.
    turtle.write(ch,font=("맑�? 고딕",txtsize,"bold"))
turtle.done()


