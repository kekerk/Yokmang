'''
Created on 2018. 12. 20.

@author: gdj4
yieldex1.py : ? œ?„ˆ? ˆ?´?„°??, yield ?˜ˆ?•½?–´
        yield : ?•¨?ˆ˜?˜ ì¢…ë£Œ ?—†?´ ê°’ì„ ë¦¬ìŠ¤?Š¸ë¡? ë°˜í™˜?•¨
'''
def genFun(num):
    for i in range(10,num+10):
        yield i
        print(i, "ê°? ë°˜í™˜")
    
print(list(genFun(5)))

for data in genFun(5) :
    print("main?—?„œ ì¶œë ¥ : " , data)