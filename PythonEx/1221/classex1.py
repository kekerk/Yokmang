'''
Created on 2018. 12. 21.

classex1.py : ?��?��?�� ?��?��
@author: gdj4
'''

class Car : 
    color = ""
    speed = 0
    
    # 메서?��
    def upSpeed(self,value): # self : ?���? ?��?��?�� 객체�? ?��. ?��바에?��?�� this
        self.speed += value
    # 메서?��
    def downSpeed(self,value):
        self.speed -= value
        

myCar1 = Car() # 객체?��
myCar1.color = "빨강"
myCar1.speed = 0
myCar2 = Car()
myCar2.color = "?��?��"
myCar2.speed = 0
myCar3 = Car()
myCar3.color = "?��?��"
myCar3.speed = 0

myCar1.upSpeed(30)
print("?��?���? 1?�� ?��?��?? %s ?���?, ?��?�� ?��?��?�� %dkm/h ?��?��?��." % (myCar1.color,myCar1.speed))

myCar2.upSpeed(60)
print("?��?���? 2?�� ?��?��?? %s ?���?, ?��?�� ?��?��?�� %dkm/h ?��?��?��." % (myCar2.color,myCar2.speed))

myCar3.upSpeed(10)
print("?��?���? 3?�� ?��?��?? %s ?���?, ?��?�� ?��?��?�� %dkm/h ?��?��?��." % (myCar3.color,myCar3.speed))