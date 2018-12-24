'''
Created on 2018. 12. 19.

@author: gdj4
'''
myTuple = (10,20,30)
print(myTuple)
# myTuple.append(40) : ?—?Ÿ¬ ?‚¨ Tuple?—?Š” appendê°? ?—†?‹¤(?ˆ˜? • ë¶ˆê?)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)