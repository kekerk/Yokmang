'''
Created on 2018. 12. 21.

@author: gdj4
threadEx1.py : ?��?��?�� 구현?���?
'''
import threading
import time


class RacingCar : 
    carName = ""
    def __init__(self,name):
        self.carName = name
        
    def runCar(self):
        for _ in range(0,3) :
            carStr = self.carName + "~~ ?��립니?��. \n"
            print(carStr,end="")
            time.sleep(0.1)
            
car1 = RacingCar("@?��?���?1")
car2 = RacingCar("#?��?���?2")
car3 = RacingCar("$?��?���?3")
# ?��?��?�� 객체 ?��?��
# target = car1.runCar : ?��?��?���? ?��?��?��?�� ?�� 메서?�� �??��
th1 = threading.Thread(target=car1.runCar())
th2 = threading.Thread(target=car2.runCar())
th3 = threading.Thread(target=car3.runCar())

th1.start()
th2.start()
th3.start()
print("?��로그?�� 종료")            