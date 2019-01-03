'''
Created on 2018. 12. 21.

@author: gdj4
multiprocessEx1.py
'''

import multiprocessing
import time


class RacingCar : 
    carName = ""
    def __init__(self,name):
        self.carName = name
        
    def runCar(self):
        for _ in range(0,3) :
            carStr = self.carName + "~~ ?¬λ¦½λ?€. \n"
            print(carStr,end="")
            time.sleep(0.1) # 0.1μ΄λ? ??κΈ?
if __name__ == '__main__' : # ?ΈλΆ??? ? κ·Όν  ? λ©μΈ?? ?λ¦?
                   
    car1 = RacingCar("@??μ°?1")
    car2 = RacingCar("#??μ°?2")
    car3 = RacingCar("$??μ°?3")
# ?€? ? κ°μ²΄ ??±
# target = car1.runCar : ?€? ?κ°? ?€??΄?Ό ?  λ©μ? μ§?? 
    mp1 = multiprocessing.Process(target=car1.runCar())
    mp2 = multiprocessing.Process(target=car2.runCar())
    mp3 = multiprocessing.Process(target=car3.runCar())

    mp1.start() # ?λ‘μΈ?€ ?€? ??
    mp2.start()
    mp3.start()
    mp1.join() # join : mp1 ?λ‘μΈ?€κ°? μ’λ£?  ?κΉμ? main?΄ ??κΈ?
    mp2.join()
    mp3.join()
print("?λ‘κ·Έ?¨ μ’λ£")  