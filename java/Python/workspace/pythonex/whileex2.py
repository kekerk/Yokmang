'''
Created on 2018. 12. 17.

@author: gdj-4
'''
a,b,hap = 0,0,0

while(True) : #줄을 잘 맞춰야한다.
    print("첫번째 수를 입력하세요")
    a = int(input())
    if a==0 :
        break
    print("두번째 수를 입력하세요")
    b = int(input())
    hap = a + b
    print("%d + %d = %d" % (a,b,hap))
print("프로그램 종료")
