'''
Created on 2018. 12. 17.

@author: gdj-4
'''

i,hap = 0,0
n1,n2,n3 = 0,0,0
n1 =int(input("??κ°? ?? ₯: "))
n2 =int(input("?κ°? ?? ₯: "))
n3 =int(input("μ¦κ?κ°? ?? ₯: "))
for i in range(n1,n2+1,n3) :
    hap = hap+i;
    
print("%d?? %dκΉμ? %d?© μ¦κ???¨ κ°μ ?© : %d" % (n1,n2,n3,hap))