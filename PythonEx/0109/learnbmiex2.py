'''
Created on 2019. 1. 9.

@author: gdj4
'''

from sklearn import svm,metrics
from sklearn.model_selection import train_test_split
import pandas as pd

tbl = pd.read_csv("bmi.csv")
# 컬럼별 분류하기
label = tbl["label"]
w = tbl["weight"] / 100
h = tbl["height"] / 200

wh = pd.concat([w,h],axis=1) # [몸무게,키] 쌍으로 데이터를 생성

# train_test_split : 학습데이터와 테스트 데이터 분류하기
data_train,data_test,label_train,label_test = train_test_split(wh,label)

clf = svm.SVC()
clf.fit(data_train,label_train)
pre = clf.predict(data_test)
ac_score = metrics.accuracy_score(label_test,pre)
cl_report = metrics.classification_report(label_test,pre)
print("정답률 = ",ac_score)
print("리포트 = \n",cl_report)