'''
Created on 2019. 1. 25.

@author: gdj4

score = [
 [88,76,92,88],
 [68,66,75,98],
 [68,86,52,78]
]

1번학생 : 총점  : xxx, 평균 : 99.99
2번학생 : 총점  : xxx, 평균 : 99.99
3번학생 : 총점  : xxx, 평균 : 99.99
'''
from numpy.lib.function_base import average
score = [
 [88,76,92,88],
 [68,66,75,98],
 [68,86,52,78]
]
print("1번학생 총점 :",sum(score[0]),"평균 : ",average(score[0]))
print("2번학생 총점 :",sum(score[1]),"평균 : ",average(score[1]))
print("3번학생 총점 :",sum(score[2]),"평균 : ",average(score[2]))
print("전체 평균 :" ,average(score))