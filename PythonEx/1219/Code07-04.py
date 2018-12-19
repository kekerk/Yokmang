'''
Created on 2018. 12. 19.

@author: gdj4
'''

aa = []
bb = []
num,cnt = 0,0

while True :
    if num % 3 == 0 : # 3의 배수의 값
        aa.append(num)
        cnt+=1
    if cnt >= 200 :
        break
    num+=1

for i in range(0,200):
    bb.append(aa[199-i])
print(bb[0],bb[199])