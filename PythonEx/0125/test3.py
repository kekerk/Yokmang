'''
Created on 2019. 1. 25.

@author: gdj4

ex = [1,2,3,4,5] 각각의 요소를 제곱하여 출력하기

2. 컴프리헨션 방식을 람다식으로 변경하기
'''

ex = [1,2,3,4,5]

for i in range(0,len(ex)):
    sum = int(ex[i]*ex[i])
    print(sum," ",end="")
print()

for e in ex :
    print(e ** 2,end= " ")
print()
print([value ** 2 for value in ex]) # 컴프리헨션 방식

# 람다 : 함수 객체
f = lambda x : x**2
result = list(map(f,ex))
print(result)