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
  ord(car) : 'A' ? ??€?€μ½λ κ°?
  chr(ord(car)+i) : ??€?€ κ°μ λ¬Έμ?΄λ‘? λ³?κ²?
'''
        push("??μ°? "+chr(ord(car)+i))
    print(parking)
        
    for i in range(0,3) :
        print(pop(),end=",")