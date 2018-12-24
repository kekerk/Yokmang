'''
Created on 2018. 12. 19.

@author: gdj4
listex2.py : ì»´í”„ë¦¬í—¨?…˜
'''

# 1ë¶??„° 5ê¹Œì? ê°’ì„ ???¥
mylist = []
for i in range(1,6) :
    mylist.append(i)
print(mylist)

# ì»´í”„ë¦¬í—¨?…˜ ?˜•?ƒœë¡? êµ¬í˜„?•˜ê¸?
mylist = [num for num in range(1,6)]
print(mylist)

# 1ë¶??„° 100ê¹Œì? ?ˆ«? ì¤? 3?˜ ë°°ìˆ˜ë§? ???¥?•˜?Š” ë¦¬ìŠ¤?Š¸ ?ƒ?„±

mylist = []
for i in range(1,101) :
    if i % 3 == 0 :
        mylist.append(i)
print(mylist)

# ì»´í”„ë¦¬í—¨?…˜ ?˜•?ƒœë¡? êµ¬í˜„?•˜ê¸?
mylist = [num for num in range(1,101)\
          if num % 3 == 0]
print(mylist)