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
            carStr = self.carName + "~~ ?��립니?��. \n"
            print(carStr,end="")
            time.sleep(0.1) # 0.1초동?�� ??�?
if __name__ == '__main__' : # ?���??��?�� ?��근할 ?�� 메인?��?�� ?���?
                   
    car1 = RacingCar("@?��?���?1")
    car2 = RacingCar("#?��?���?2")
    car3 = RacingCar("$?��?���?3")
# ?��?��?�� 객체 ?��?��
# target = car1.runCar : ?��?��?���? ?��?��?��?�� ?�� 메서?�� �??��
    mp1 = multiprocessing.Process(target=car1.runCar())
    mp2 = multiprocessing.Process(target=car2.runCar())
    mp3 = multiprocessing.Process(target=car3.runCar())

    mp1.start() # ?��로세?�� ?��?�� ?��?��
    mp2.start()
    mp3.start()
    mp1.join() # join : mp1 ?��로세?���? 종료?�� ?��까�? main?�� ??�?
    mp2.join()
    mp3.join()
print("?��로그?�� 종료")  