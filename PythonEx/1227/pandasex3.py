'''
Created on 2018. 12. 27.

pandas ?˜ˆ? œ
@author: gdj4
'''

import pandas as pd


df = pd.DataFrame({"A":[1,4,7],"B":[2,5,8],"C":[3,6,9]})

print(df)
print(df.iloc[0]) # 0ë²? ?¸?±?Š¤ ê°’ì„ ì¡°íšŒ
print(df.loc[0])  # 0ë²? ?¸?±?Š¤ ê°’ì„ ì¡°íšŒ
#print(df.ix[0]) # deprecated ?¨ (ì¤‘ìš”?„ê°? ?–¨?–´? ¸ ê³? ?‚¬?¼ì§?)
print("*********************************")

df = pd.DataFrame(data=([[1,2,3],[4,5,6],[7,8,9]]),index=[2,"A",4],columns=[51,52,53])
print(df)
print(df.iloc[2]) # ?¸?±?Š¤?˜ ë²ˆí˜¸ë¥? ?˜ë¯?. 3ë²ˆì§¸ ?–‰?„ ì¡°íšŒ
print(df.loc[2]) # ?¸?±?Š¤?˜ ê°’ì„ ?˜ë¯?
print(df.loc["A"])