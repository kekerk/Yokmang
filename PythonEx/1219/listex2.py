'''
Created on 2018. 12. 19.

@author: gdj4
listex2.py : 컴프리헨?��
'''

# 1�??�� 5까�? 값을 ???��
mylist = []
for i in range(1,6) :
    mylist.append(i)
print(mylist)

# 컴프리헨?�� ?��?���? 구현?���?
mylist = [num for num in range(1,6)]
print(mylist)

# 1�??�� 100까�? ?��?�� �? 3?�� 배수�? ???��?��?�� 리스?�� ?��?��

mylist = []
for i in range(1,101) :
    if i % 3 == 0 :
        mylist.append(i)
print(mylist)

# 컴프리헨?�� ?��?���? 구현?���?
mylist = [num for num in range(1,101)\
          if num % 3 == 0]
print(mylist)