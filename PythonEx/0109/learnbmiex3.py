'''
Created on 2019. 1. 9.

@author: gdj4
bmi.csv 파일을 이용하여 그래프 그리기
'''

import matplotlib.pyplot as plt # x,y 좌표에 점으로 표시
import pandas as pd

tbl = pd.read_csv("bmi.csv",index_col=2)

fig = plt.figure() # 그래프 저장 공간
ax = fig.add_subplot(1,1,1) # 1행 1열 구분하여 1번째 위치에 그래프를 저장

def scatter(lbl,color):
    b = tbl.loc[lbl] # fat 값을 가진 행 선택
    ax.scatter(b["weight"],b["height"],c=color,label=lbl)
    
scatter("fat","red")
scatter("thin","purple")
scatter("normal","yellow")
ax.legend() # 범례를 출력하기
plt.savefig("bmi-test.png") # 그래프 저장