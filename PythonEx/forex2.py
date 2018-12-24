'''
Created on 2018. 12. 17.

@author: gdj-4
'''

i,hap = 0,0
n1,n2,n3 = 0,0,0
n1 =int(input("?‹œ?‘ê°? ?…? ¥: "))
n2 =int(input("?ê°? ?…? ¥: "))
n3 =int(input("ì¦ê?ê°? ?…? ¥: "))
for i in range(n1,n2+1,n3) :
    hap = hap+i;
    
print("%d?—?„œ %dê¹Œì? %d?”© ì¦ê??‹œ?‚¨ ê°’ì˜ ?•© : %d" % (n1,n2,n3,hap))