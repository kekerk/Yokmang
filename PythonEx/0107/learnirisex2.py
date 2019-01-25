'''
Created on 2019. 1. 7.

@author: gdj4

pandas 를 이용하여 학습데이터와 테스트 데이터 분류하기
'''
import pandas as pd
from sklearn import svm,metrics
from sklearn.model_selection import train_test_split

csv = pd.read_csv("iris.csv")

csv_data=csv[["SepalLength","SepalWidth","PetalLength","PetalWidth"]] # 기본 데이터 부분
csv_label = csv["Name"] # 정답부분, 결과 부분

''' 
train_test_split : 학습데이터와 테스트 데이터 분류하기
                                   기본적으로 25%를 테스트 데이터로 분류함
'''

train_data,test_data,train_label,test_label = \
                     train_test_split(csv_data,csv_label)
                     
clf = svm.SVC()
clf.fit(train_data,train_label)
pre = clf.predict(test_data)

ac_score = metrics.accuracy_score(test_label,pre)
print("정답률 = ",ac_score)