'''
Created on 2018. 12. 20.

@author: gdj4
'''
import turtle

t = turtle.Pen()

for x in range(1,30,1):
    t.forward(20*x)
    t.left(90)
    t.speed(50)

turtle.done()
