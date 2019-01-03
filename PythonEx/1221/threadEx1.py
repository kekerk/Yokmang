'''
Created on 2018. 12. 21.

@author: gdj4
threadEx1.py : ?Š¤? ˆ?“œ êµ¬í˜„?•˜ê¸?
'''
import threading
import time


class RacingCar : 
    carName = ""
    def __init__(self,name):
        self.carName = name
        
    def runCar(self):
        for _ in range(0,3) :
            carStr = self.carName + "~~ ?‹¬ë¦½ë‹ˆ?‹¤. \n"
            print(carStr,end="")
            time.sleep(0.1)
            
car1 = RacingCar("@??™ì°?1")
car2 = RacingCar("#??™ì°?2")
car3 = RacingCar("$??™ì°?3")
# ?Š¤? ˆ?“œ ê°ì²´ ?ƒ?„±
# target = car1.runCar : ?Š¤? ˆ?“œê°? ?‹¤?–‰?•´?•¼ ?•  ë©”ì„œ?“œ ì§?? •
th1 = threading.Thread(target=car1.runCar())
th2 = threading.Thread(target=car2.runCar())
th3 = threading.Thread(target=car3.runCar())

th1.start()
th2.start()
th3.start()
print("?”„ë¡œê·¸?¨ ì¢…ë£Œ")            