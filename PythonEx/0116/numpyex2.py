'''
Created on 2019. 1. 16.

@author: gdj4
'''

import numpy as np

l1 = [0,1,2,3,4,5]
a1 = np.array(l1)
print(a1)
print(a1.dtype,type(a1))

l2 = [0.1,5,4,12,0.5]
a2 = np.array(l2)
print(a2)
print(a2.dtype,type(a2))

a3 = np.array([[1,2,3],[4,5,6],[7,8,9]])
print(a3)
print(a3.dtype,type(a3))

a4 = np.arange(10)
print(a4)

a5 = np.arange(1,11)
print(a5)

print("1부터 100까지 짝수의 합 : ",np.arange(0,101,2).sum())
print("1부터 100까지 짝수의 합 : ",np.arange(1,101,2).sum())

# 2차원 배열로 만들기
# resshape(4,3) : 4행 3열의 배열로 구조를 변경하기
a6 = np.arange(12).reshape(4,3)
print(a6)

print(np.linspace(1,10,10)) # 균등 분할
# np.pi : 원주율
print(np.linspace(0,np.pi,20))# 균등분할

# 1로 초기화 하기
print(np.ones(10))
print(np.ones((3,5)))

# 5행 3열을 0으로 초기화하기
a7 = np.zeros((5,3))
print(a7)

str_a1 = np.array(["1.56","0.123","5.432","9","8"])
print(str_a1)

# 문자열을 실수형으로 변경하여 저장하기
num_a1 = str_a1.astype(float)
print(num_a1)

# 문자열을 정수형으로 변경하여 저장하기
str_a2 = np.array(["1","0","5","9","8"])
num_a2 = str_a2.astype(int)
print(num_a2)
num_a2 = num_a1
print(num_a2)

# np.random.rand : 0 <= x < 1.0 난수 제공
print(np.random.rand(2,3)) # 2행 3열 배열로 저장
print(np.random.rand()) # 한 개 난수 발생
print(np.random.rand(2,5,3)) # 3차원 배열

# np.random.rand : 정수형 난수 제공
print(np.random.randint(10,size=(3,4))) # 0부터 9까지의 임의이 수를 3행 4열로 저장
print(np.random.randint(1,10,size=(3,4))) # 1부터 9까지의 임의이 수를 3행 4열로 저장

# lotto 번호 생성하기
print(np.random.randint(1,46,size=(1,6)))

arr1 = np.array([10,20,30,40,50])
arr2 = np.array([1,2,3,4,5])
print(arr1 + arr2)
print(arr1 - arr2)
print(arr1 * arr2)
print(arr1 / arr2)
print(arr1 * 2)