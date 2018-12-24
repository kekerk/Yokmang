'''
Created on 2018. 12. 17.

@author: gdj-4
'''
import keyword  # ?ë°”ì˜ package import?•˜?Š” ê²ƒê³¼ ë¹„ìŠ·
import random  # ?œ ?‹¸ë¦¬í‹°(ê¸°ëŠ¥)ë¥? ?‚¬?š©?•˜ê¸? ?œ„?•œ ê°ì²´ë¥? ?Œê³? ?˜¤ê¸?.


numbers = [] #ë°°ì—´ ?„ ?–¸, ë¦¬ìŠ¤?Š¸ ?„ ?–¸
for num in range(0,10,2) : #0?—?„œ 9ê¹Œì? 1?”© ì¦ê??•˜ë©´ì„œ ë°˜ë³µ?•¨. numbers.length : 10
    numbers.append(random.randrange(0,10)) #0ë¶??„° 9ê¹Œì? ?„?˜?˜ ê°’ì„ ì°¾ì•„?„œ numbers?— ì¶”ê?
print("?ƒ?„±?œ ë¦¬ìŠ¤?Š¸",numbers)

for num in range(0,10,2) :
    if(num not in numbers) : 
        print("?ˆ«? %d?Š” ë¦¬ìŠ¤?Š¸?— ?—†?Šµ?‹ˆ?‹¤." % num)

print(keyword.kwlist) #?ŒŒ?´?¬?—?„œ ?‚¬?š©?˜?Š” ?˜ˆ?•½?–´ ëª©ë¡ ì¶œë ¥?•¨.