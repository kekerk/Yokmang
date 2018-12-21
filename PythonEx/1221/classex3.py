'''
Created on 2018. 12. 21.

@author: gdj4
classex3.py : 인스턴스 변수, 클래스 변수
 인스턴스 변수, 클래스 변수는 선언부분에 차이가 없다.
 인스턴스 변수 : self.변수명
 클래스 변수 : 클래스명.변수명
'''
class Car :
    color = ""
    speed = 0
    count = 0
    
    def __init__(self):
        self.color = 0 # 인스턴스 변수
        Car.count += 1 # 클래스 변수
    
    def printMessage(self):
        print("테스트 메세지 입니다.")
 
myCar1,myCar2 = None,None
myCar1 = Car()
myCar1.speed = 30
print("자동차 1의 속도는 %dkm/h 이며, 생산된 차는 총 %d대 입니다." % (myCar1.speed,myCar1.count))
myCar2 = Car()
myCar2.speed = 60
print("자동차 2의 속도는 %dkm/h 이며, 생산된 차는 총 %d대 입니다." % (myCar2.speed,myCar2.count))