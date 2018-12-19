'''
Created on 2018. 12. 19.

@author: gdj4
'''

# \ : 다음줄도 표현
def getMean(numbericValue): # 숫자 형태의 값
    return sum(numbericValue)/len(numbericValue)\
        if len(numbericValue) > 0\
        else float("NaN")

my_list = [2,2,2,4,4,6,6,8,8]
print("output #1(mean) : {!s}".format(getMean(my_list)))

my_empty = []
print("output #1(mean) : {!s}".format(getMean(my_empty)))