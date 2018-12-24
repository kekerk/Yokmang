'''
Created on 2018. 12. 19.

@author: gdj4
'''
mySet1 = {1,2,3,4,5}
mySet2 = {4,5,6,7}
# set?? ì¤‘ë³µ?ˆ˜ê°? ?“¤?–´ê°?ì§? ?•Š?Š”?‹¤ 1219.test1?—?„œ ?‚¬?š©?•¨.

# êµì§‘?•©
print(mySet1 & mySet2) # {4, 5}
print(mySet1.intersection(mySet2))

# ?•©ì§‘í•©
print(mySet1 | mySet2) # {1, 2, 3, 4, 5, 6, 7}
print(mySet1.union(mySet2))

# ì°¨ì§‘?•©
print(mySet1 - mySet2) # {1, 2, 3}
print(mySet1.difference(mySet2))

# ??ì¹? ì°¨ì§‘?•©
print(mySet1 ^ mySet2) # {1, 2, 3, 6, 7}
print(mySet1.symmetric_difference(mySet2))