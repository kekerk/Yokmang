'''
Created on 2018. 12. 21.

classex1.py : ?΄??€ ?? 
@author: gdj4
'''

class Car : 
    color = ""
    speed = 0
    
    # λ©μ?
    def upSpeed(self,value): # self : ?κΈ? ?? ?΄ κ°μ²΄κ°? ?¨. ?λ°μ?? this
        self.speed += value
    # λ©μ?
    def downSpeed(self,value):
        self.speed -= value
        

myCar1 = Car() # κ°μ²΄?
myCar1.color = "λΉ¨κ°"
myCar1.speed = 0
myCar2 = Car()
myCar2.color = "??"
myCar2.speed = 0
myCar3 = Car()
myCar3.color = "?Έ?"
myCar3.speed = 0

myCar1.upSpeed(30)
print("??μ°? 1? ???? %s ?΄λ©?, ??¬ ??? %dkm/h ???€." % (myCar1.color,myCar1.speed))

myCar2.upSpeed(60)
print("??μ°? 2? ???? %s ?΄λ©?, ??¬ ??? %dkm/h ???€." % (myCar2.color,myCar2.speed))

myCar3.upSpeed(10)
print("??μ°? 3? ???? %s ?΄λ©?, ??¬ ??? %dkm/h ???€." % (myCar3.color,myCar3.speed))