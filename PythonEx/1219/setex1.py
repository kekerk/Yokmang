'''
Created on 2018. 12. 19.

@author: gdj4
'''
mySet1 = {1,2,3,4,5}
mySet2 = {4,5,6,7}
# set?? 중복?���? ?��?���?�? ?��?��?�� 1219.test1?��?�� ?��?��?��.

# 교집?��
print(mySet1 & mySet2) # {4, 5}
print(mySet1.intersection(mySet2))

# ?��집합
print(mySet1 | mySet2) # {1, 2, 3, 4, 5, 6, 7}
print(mySet1.union(mySet2))

# 차집?��
print(mySet1 - mySet2) # {1, 2, 3}
print(mySet1.difference(mySet2))

# ??�? 차집?��
print(mySet1 ^ mySet2) # {1, 2, 3, 6, 7}
print(mySet1.symmetric_difference(mySet2))