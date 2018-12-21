'''
Created on 2018. 12. 21.

@author: gdj4
multiprocessEx1.py
'''

import time
import multiprocessing
class RacingCar : 
    carName = ""
    def __init__(self,name):
        self.carName = name
        
    def runCar(self):
        for _ in range(0,3) :
            carStr = self.carName + "~~ 달립니다. \n"
            print(carStr,end="")
            time.sleep(0.1)
            
car1 = RacingCar("@자동차1")
car2 = RacingCar("#자동차2")
car3 = RacingCar("$자동차3")
# 스레드 객체 생성
# target = car1.runCar : 스레드가 실행해야 할 메서드 지정
mp1 = multiprocessing.Process(target=car1.runCar())
mp2 = multiprocessing.Process(target=car2.runCar())
mp3 = multiprocessing.Process(target=car3.runCar())

mp1.start()
mp2.start()
mp3.start()
mp1.join()
mp2.join()
mp3.join()
print("프로그램 종료")  