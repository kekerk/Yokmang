'''
Created on 2018. 12. 17.

@author: gdj-4
'''

i,hap = 0,0
n1,n2,n3 = 0,0,0
n1 =int(input("?��?���? ?��?��: "))
n2 =int(input("?���? ?��?��: "))
n3 =int(input("증�?�? ?��?��: "))
for i in range(n1,n2+1,n3) :
    hap = hap+i;
    
print("%d?��?�� %d까�? %d?�� 증�??��?�� 값의 ?�� : %d" % (n1,n2,n3,hap))