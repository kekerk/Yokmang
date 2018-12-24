'''
Created on 2018. 12. 21.

@author: gdj4
classEx4.py : ?ƒ?† ?˜ˆ? œ
'''
class Car :
    speed = 0
    def upSpeed(self,value):
        self.speed += value
        print("?˜„?¬ ?†?„(ë¶?ëª¨í´?˜?Š¤) : %d" % self.speed)
        
class Sedan(Car):
    def upSpeed(self, value):
        self.speed += value
        if self.speed > 150:
            self.speed = 150
            print("?˜„?¬ ?†?„(??‹?´?˜?Š¤) : %d" % self.speed)
            
class Truck(Car):
    pass

sedan1,truck1 = None,None

truck1 = Truck()
sedan1 = Sedan()
print("?Š¸?Ÿ­ -> ",end="")
truck1.upSpeed(200)
print("?Š¹?š©ì°?->",end="")
sedan1.upSpeed(200)