'''
Created on 2018. 12. 21.

@author: gdj4
threadEx1.py : ?€? ? κ΅¬ν?κΈ?
'''
import threading
import time


class RacingCar : 
    carName = ""
    def __init__(self,name):
        self.carName = name
        
    def runCar(self):
        for _ in range(0,3) :
            carStr = self.carName + "~~ ?¬λ¦½λ?€. \n"
            print(carStr,end="")
            time.sleep(0.1)
            
car1 = RacingCar("@??μ°?1")
car2 = RacingCar("#??μ°?2")
car3 = RacingCar("$??μ°?3")
# ?€? ? κ°μ²΄ ??±
# target = car1.runCar : ?€? ?κ°? ?€??΄?Ό ?  λ©μ? μ§?? 
th1 = threading.Thread(target=car1.runCar())
th2 = threading.Thread(target=car2.runCar())
th3 = threading.Thread(target=car3.runCar())

th1.start()
th2.start()
th3.start()
print("?λ‘κ·Έ?¨ μ’λ£")            