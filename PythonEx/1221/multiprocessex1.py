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
            time.sleep(0.1) # 0.1초동안 대기
if __name__ == '__main__' : # 외부에서 접근할 때 메인임을 알림
                   
    car1 = RacingCar("@자동차1")
    car2 = RacingCar("#자동차2")
    car3 = RacingCar("$자동차3")
# 스레드 객체 생성
# target = car1.runCar : 스레드가 실행해야 할 메서드 지정
    mp1 = multiprocessing.Process(target=car1.runCar())
    mp2 = multiprocessing.Process(target=car2.runCar())
    mp3 = multiprocessing.Process(target=car3.runCar())

    mp1.start() # 프로세스 실행 시작
    mp2.start()
    mp3.start()
    mp1.join() # join : mp1 프로세스가 종료할 때까지 main이 대기
    mp2.join()
    mp3.join()
print("프로그램 종료")  