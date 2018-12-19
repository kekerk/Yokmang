'''
Created on 2018. 12. 19.

@author: gdj4
'''
myTuple = (10,20,30)
print(myTuple)
# myTuple.append(40) : 에러 남 Tuple에는 append가 없다(수정 불가)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)