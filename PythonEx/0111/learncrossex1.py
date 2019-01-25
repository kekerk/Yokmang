'''
Created on 2019. 1. 11.

@author: gdj4
cross validation 기법 예쩨
'''

from sklearn import svm,metrics
import random,re
from macpath import split

lines = open("iris.csv","r",encoding="utf-8").read().split("\n")
'''
  [0-9\,] : 0부터 9까지 숫자나 . 중 한개
  ^ : startswith 메서드의 의미
  $ : endswith 메서드의 의미
  + : 1개 이상
  
  re.match(r"^[0-9\.]+$","123.5") : true
  re.match(r"^[0-9\.]+$","123a.5") : false
'''
f_tonum = lambda n : float(n) if re.match(r"[0-9\.]*$",n) else n
f_cols = lambda li : list(map(f_tonum,li.strip().split(",")))
csv = list(map(f_cols,lines))
del csv[0] # csv의 첫번째 레코드 제거
random.shuffle(csv) # csv의 내용을 섞기

k=5
csvk = [ [] for i in range(k)]
for i in range(len(csv)) :
    csvk[i%k].append(csv[i])
    
def split_data_label(rows):
    data = []
    label = []
    for row in rows :
        data.append(row[0:4])
        label.append(row[4])
    return (data,label)

def calc_score(test,train):
    test_f,test_l = split_data_label(test)
    train_f,train_l = split_data_label(train)
    
    clf = svm.SVC()
    clf.fit(train_f,train_l)
    pre = clf.predict(test_f)
    return metrics.accuracy_score(test_l,pre)

score_list = []
for testc in csvk : # testc : csvk[i]
    trainc = []
    for i in csvk :
        if i != testc : trainc += i # 테스트데이터와 학습데이터를 교차로 생성하기
    
    sc = calc_score(testc, trainc)
    score_list.append(sc)
    
print("각각의 정답률 = ",score_list)
print("평균 정답률 = ",sum(score_list)/len(score_list))