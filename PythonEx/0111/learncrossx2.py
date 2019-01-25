'''
Created on 2019. 1. 11.

@author: gdj4
pandas를 이용하여 cross validation 구현하기
'''
import pandas as pd
from sklearn import svm,metrics,model_selection
import random,re

csv = pd.read_csv("iris.csv")
data = csv[["SepalLength","SepalWidth","PetalLength","PetalWidth"]]
label = csv["Name"]

clf = svm.SVC() # 기계어 학습 객체
scores = model_selection.cross_val_score(clf,data,label,cv=3)
print("각각의 정답률 = ",scores)
print("평균 정답률 = ",scores.mean())