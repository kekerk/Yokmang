'''
Created on 2018. 12. 27.

pandas 예제
@author: gdj4
'''

import pandas as pd

df = pd.DataFrame({"A":[1,4,7],"B":[2,5,8],"C":[3,6,9]})

print(df)
print(df.iloc[0]) # 0번 인덱스 값을 조회
print(df.loc[0])  # 0번 인덱스 값을 조회
#print(df.ix[0]) # deprecated 됨 (중요도가 떨어져 곧 사라짐)
print("*********************************")

df = pd.DataFrame(data=([[1,2,3],[4,5,6],[7,8,9]]),index=[2,"A",4],columns=[51,52,53])
print(df)
print(df.iloc[2]) # 인덱스의 번호를 의미. 3번째 행을 조회
print(df.loc[2]) # 인덱스의 값을 의미
print(df.loc["A"])