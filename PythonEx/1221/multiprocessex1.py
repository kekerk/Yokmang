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
            carStr = self.carName + "~~ ?‹¬ë¦½ë‹ˆ?‹¤. \n"
            print(carStr,end="")
            time.sleep(0.1) # 0.1ì´ˆë™?•ˆ ??ê¸?
if __name__ == '__main__' : # ?™¸ë¶??—?„œ ? ‘ê·¼í•  ?•Œ ë©”ì¸?„?„ ?•Œë¦?
                   
    car1 = RacingCar("@??™ì°?1")
    car2 = RacingCar("#??™ì°?2")
    car3 = RacingCar("$??™ì°?3")
# ?Š¤? ˆ?“œ ê°ì²´ ?ƒ?„±
# target = car1.runCar : ?Š¤? ˆ?“œê°? ?‹¤?–‰?•´?•¼ ?•  ë©”ì„œ?“œ ì§?? •
    mp1 = multiprocessing.Process(target=car1.runCar())
    mp2 = multiprocessing.Process(target=car2.runCar())
    mp3 = multiprocessing.Process(target=car3.runCar())

    mp1.start() # ?”„ë¡œì„¸?Š¤ ?‹¤?–‰ ?‹œ?‘
    mp2.start()
    mp3.start()
    mp1.join() # join : mp1 ?”„ë¡œì„¸?Š¤ê°? ì¢…ë£Œ?•  ?•Œê¹Œì? main?´ ??ê¸?
    mp2.join()
    mp3.join()
print("?”„ë¡œê·¸?¨ ì¢…ë£Œ")  