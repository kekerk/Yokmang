'''
Created on 2018. 12. 27.

pandas ?��?��
@author: gdj4
'''

import pandas as pd


df = pd.DataFrame({"A":[1,4,7],"B":[2,5,8],"C":[3,6,9]})

print(df)
print(df.iloc[0]) # 0�? ?��?��?�� 값을 조회
print(df.loc[0])  # 0�? ?��?��?�� 값을 조회
#print(df.ix[0]) # deprecated ?�� (중요?���? ?��?��?�� �? ?��?���?)
print("*********************************")

df = pd.DataFrame(data=([[1,2,3],[4,5,6],[7,8,9]]),index=[2,"A",4],columns=[51,52,53])
print(df)
print(df.iloc[2]) # ?��?��?��?�� 번호�? ?���?. 3번째 ?��?�� 조회
print(df.loc[2]) # ?��?��?��?�� 값을 ?���?
print(df.loc["A"])