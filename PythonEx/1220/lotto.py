'''
Created on 2018. 12. 20.

@author: gdj4
'''

import random


def getNumber():
    return random.randrange(1,46)

num = 0
lotto = []

print("λ‘λ μΆμ²¨ ??")

while True :
    num = getNumber()
    
    if lotto.count(num) == 0:
        lotto.append(num)
    if len(lotto) >= 6 :
        break
print("λ‘λ λ²νΈ : ",end='')
lotto.sort()
for i in range(0,6):
    print("%d "%lotto[i],end='')