'''
Created on 2018. 12. 19.

@author: gdj4
'''
mySet1 = {1,2,3,4,5}
mySet2 = {4,5,6,7}
# set은 중복수가 들어가지 않는다 1219.test1에서 사용함.

# 교집합
print(mySet1 & mySet2) # {4, 5}
print(mySet1.intersection(mySet2))

# 합집합
print(mySet1 | mySet2) # {1, 2, 3, 4, 5, 6, 7}
print(mySet1.union(mySet2))

# 차집합
print(mySet1 - mySet2) # {1, 2, 3}
print(mySet1.difference(mySet2))

# 대칭 차집합
print(mySet1 ^ mySet2) # {1, 2, 3, 6, 7}
print(mySet1.symmetric_difference(mySet2))