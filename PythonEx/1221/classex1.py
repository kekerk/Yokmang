'''
Created on 2018. 12. 21.

classex1.py : ?´?˜?Š¤ ?˜ˆ? œ
@author: gdj4
'''

class Car : 
    color = ""
    speed = 0
    
    # ë©”ì„œ?“œ
    def upSpeed(self,value): # self : ?ê¸? ??‹ ?´ ê°ì²´ê°? ?¨. ?ë°”ì—?„œ?˜ this
        self.speed += value
    # ë©”ì„œ?“œ
    def downSpeed(self,value):
        self.speed -= value
        

myCar1 = Car() # ê°ì²´?™”
myCar1.color = "ë¹¨ê°•"
myCar1.speed = 0
myCar2 = Car()
myCar2.color = "?ŒŒ?‘"
myCar2.speed = 0
myCar3 = Car()
myCar3.color = "?…¸?‘"
myCar3.speed = 0

myCar1.upSpeed(30)
print("??™ì°? 1?˜ ?ƒ‰?ƒ?? %s ?´ë©?, ?˜„?¬ ?†?„?Š” %dkm/h ?…?‹ˆ?‹¤." % (myCar1.color,myCar1.speed))

myCar2.upSpeed(60)
print("??™ì°? 2?˜ ?ƒ‰?ƒ?? %s ?´ë©?, ?˜„?¬ ?†?„?Š” %dkm/h ?…?‹ˆ?‹¤." % (myCar2.color,myCar2.speed))

myCar3.upSpeed(10)
print("??™ì°? 3?˜ ?ƒ‰?ƒ?? %s ?´ë©?, ?˜„?¬ ?†?„?Š” %dkm/h ?…?‹ˆ?‹¤." % (myCar3.color,myCar3.speed))