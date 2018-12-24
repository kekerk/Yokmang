'''
Created on 2018. 12. 21.

@author: gdj4
classEx5.py : ?��?��?��?��?�� ?��?��?��?�� �??��?�� ?��별한 메서?��
'''
class Line :
    length = 0
    def __init__(self,length): # ?��?��?�� 객체 ?��?�� ?�� ?��출되?�� 메서?��
        self.length = length
        print(self.length,"길이?�� ?��?�� ?��?��?��?��?��?��?��.")
    def __del__(self): # ?��멸자 : 객체 ?��거시 ?��출되?�� 메서?��
        print(self.length,"길이?�� ?��?�� ?���? ?��?��?��?��?��.")
    def __repr__(self): # ?��바의 toString같�? 기능?�� �?�?. 객체?�� 출력 ?��?��?��?�� 메서?��
        return "?��?�� 길이 : "+str(self.length)
    def __add__(self,other): # ?��?���? ?��?��?�� ?��?��?�� ?��출되?�� 메서?��
        return self.length + other.length
    def __lt__(self,other):
        return self.length < other.length
    def __eq__(self,other):
        return self.length == other.length
    
myLine1 = Line(100) # 객체?��, ?��?��?�� ?���?
myLine2 = Line(200)
print(myLine1)
print(myLine2)

print("?�� ?��?�� 길이?�� ?�� : ",myLine1 + myLine2)
## ?��로그?�� 종료 : ?��?��?�� 객체�? ?��?��?���? ?��멸됨. ?��멸자�? ?���?

if myLine1 < myLine2 :
    print("myLine2�? ?�� 깁니?��.")
elif myLine1 == myLine2 :
    print("?�� ?��?�� 길이�? 같습?��?��.")
else :
    print("myLine1?�� ?�� 깁니?��.")