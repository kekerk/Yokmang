'''
Created on 2018. 12. 20.

@author: gdj4
yieldex1.py : ?��?��?��?��?��??, yield ?��?��?��
        yield : ?��?��?�� 종료 ?��?�� 값을 리스?���? 반환?��
'''
def genFun(num):
    for i in range(10,num+10):
        yield i
        print(i, "�? 반환")
    
print(list(genFun(5)))

for data in genFun(5) :
    print("main?��?�� 출력 : " , data)