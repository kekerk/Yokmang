'''
Created on 2018. 12. 17.

@author: gdj-4
'''
a,b,hap = 0,0,0

while(True) : #줄을 ?�� 맞춰?��?��?��.
    print("첫번�? ?���? ?��?��?��?��?��")
    a = int(input())
    if a==0 :
        break
    print("?��번째 ?���? ?��?��?��?��?��")
    b = int(input())
    hap = a + b
    print("%d + %d = %d" % (a,b,hap))
print("?��로그?�� 종료")
