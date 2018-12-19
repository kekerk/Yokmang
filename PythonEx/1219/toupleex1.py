'''
Created on 2018. 12. 19.

@author: gdj4

toupleex1.py : 튜플 예제

리스트 : 순서유지, 배열  => [ ]
딕셔너리 : (key, value) 쌍으로 저장된 객체 = > { }
튜플 : 순서유지 , 수정 불가 리스트 => ( )
'''

def getMean(numbericValue): # 숫자 형태의 값
    return sum(numbericValue)/len(numbericValue)\
        if len(numbericValue) > 0\
        else float("NaN")

my_touple = ("x","y","z")
one,two,three = my_touple
print("output : {0}, {1}, {2}".format(one,two,three))

my_touple2 = (10,20,30,40)
print(my_touple2[0],my_touple2[1],my_touple2[2])
print(my_touple2[1:3])
print(my_touple2[:3])
print(my_touple2[3:])
print(my_touple2[:])

print("output #1(mean) : {!s}".format(getMean(my_touple2)))