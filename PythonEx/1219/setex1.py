'''
Created on 2018. 12. 19.

@author: gdj4
'''
mySet1 = {1,2,3,4,5}
mySet2 = {4,5,6,7}
# set?? μ€λ³΅?κ°? ?€?΄κ°?μ§? ???€ 1219.test1?? ?¬?©?¨.

# κ΅μ§?©
print(mySet1 & mySet2) # {4, 5}
print(mySet1.intersection(mySet2))

# ?©μ§ν©
print(mySet1 | mySet2) # {1, 2, 3, 4, 5, 6, 7}
print(mySet1.union(mySet2))

# μ°¨μ§?©
print(mySet1 - mySet2) # {1, 2, 3}
print(mySet1.difference(mySet2))

# ??μΉ? μ°¨μ§?©
print(mySet1 ^ mySet2) # {1, 2, 3, 6, 7}
print(mySet1.symmetric_difference(mySet2))