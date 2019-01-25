'''
Created on 2019. 1. 16.

@author: gdj4
pandas 자료형 예제
'''

import pandas as pd
tbl = pd.DataFrame({
     "weight" : [80.0,70.4,65.5,45.9,51.2],
     "height" : [170,180,155,145,158],
     "type" : ["f","n","f","t","t"],
     "gender" : ["m","m","f","f","f"]
    })
# 몸무게 목록 추출하기
print("몸무게 목록")
print(tbl["weight"])
# 몸무게와 키 목록 추출하기
print("몸무게와 키 목록")
print(tbl[["weight","height"]])

#필터 설정하기. 행 추출하기
print("키가 160 이상인 목록")
print(tbl[tbl.height >= 160])

# 여성 목록 추출하기
print("여성 목록 추출하기")
print(tbl[tbl.gender == "f"])

# 정렬하기
print("키로 정렬하기")
print(tbl.sort_values(by="height"))

# 몸무게로 정렬하기
print("몸무게로 정렬하기")
print(tbl.sort_values(by="weight",ascending=False))