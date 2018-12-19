'''
Created on 2018. 12. 19.

@author: gdj4
'''

parking = []

def push(car):
    parking.append(car)
def pop() :
    return parking.pop()

if __name__=='__main__' :
    car='A'
    for i in range(0,3) :
'''
  ord(car) : 'A' 의 아스키코드 값
  chr(ord(car)+i) : 아스키 값을 문자열로 변경
'''
        push("자동차 "+chr(ord(car)+i))
    print(parking)
        
    for i in range(0,3) :
        print(pop(),end=",")