'''
Created on 2018. 12. 19.

@author: gdj4
'''

tt = ((1,2,3),
      (4,5,6),
      (7,8,9))

print(tt)

print()

for i in range(0,len(tt)) :
    for j in range(0,len(tt[i])) :
        print(tt[i][j],end = " ")
    print()
for i in range(0,len(tt)) :
        cc = ''.join(str(tt[i]))
        ss = cc.replace(',',' ')
        dd = ss.replace("(", " ")
        ff = dd.replace(")", " ")
        print(ff)