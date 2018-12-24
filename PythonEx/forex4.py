'''
Created on 2018. 12. 17.

@author: gdj-4
'''
i,kt=0,0
s = ""
t = []
for i in range(2,10,1):
    s= s+("    %d?‹¨             " % i)
print(s)
s=""
for i in range(2,10,1):
    for k in range(2,10,1) :
        s = s+("%d x %d = %2d " % (k,i,i*k))
    print(s)
    s=""
print("")