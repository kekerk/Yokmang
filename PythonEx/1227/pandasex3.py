'''
Created on 2018. 12. 27.

pandas ?? 
@author: gdj4
'''

import pandas as pd


df = pd.DataFrame({"A":[1,4,7],"B":[2,5,8],"C":[3,6,9]})

print(df)
print(df.iloc[0]) # 0λ²? ?Έ?±?€ κ°μ μ‘°ν
print(df.loc[0])  # 0λ²? ?Έ?±?€ κ°μ μ‘°ν
#print(df.ix[0]) # deprecated ?¨ (μ€μ?κ°? ?¨?΄? Έ κ³? ?¬?Όμ§?)
print("*********************************")

df = pd.DataFrame(data=([[1,2,3],[4,5,6],[7,8,9]]),index=[2,"A",4],columns=[51,52,53])
print(df)
print(df.iloc[2]) # ?Έ?±?€? λ²νΈλ₯? ?λ―?. 3λ²μ§Έ ?? μ‘°ν
print(df.loc[2]) # ?Έ?±?€? κ°μ ?λ―?
print(df.loc["A"])