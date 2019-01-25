'''
Created on 2019. 1. 16.

@author: gdj4
pandas 예제 2
'''
import pandas as pd
tbl = pd.DataFrame([
    ["A","B","C"],
    ["D","E","F"],
    ["G","H","I"]
    ])

print(tbl)
print("----------------------")
print(tbl.T)
