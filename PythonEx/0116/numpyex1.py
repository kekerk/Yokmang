'''
Created on 2019. 1. 16.

@author: gdj4
numpy 예제
'''

import numpy as np

# v : 0.0으로 설정된 float32 형 데이터 10개를 저장
v = np.zeros(10,dtype=np.float32)
print(v)

v = np.arange(10,dtype=np.uint64)
print(v)

v *= 3
print(v)
print(v[3])
print(v.mean()) # 평균
print(v.sum()) # 합계
print(type(v))

v = np.arange(101,dtype=np.uint64)
print(v.sum())

