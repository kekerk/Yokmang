'''
Created on 2018. 12. 17.

@author: gdj-4
'''
a,b,hap = 0,0,0

while(True) : #μ€μ ? λ§μΆ°?Ό??€.
    print("μ²«λ²μ§? ?λ₯? ?? ₯??Έ?")
    a = int(input())
    if a==0 :
        break
    print("?λ²μ§Έ ?λ₯? ?? ₯??Έ?")
    b = int(input())
    hap = a + b
    print("%d + %d = %d" % (a,b,hap))
print("?λ‘κ·Έ?¨ μ’λ£")
