'''
Created on 2019. 1. 7.
붓꽃데이터 사용하기
http://github.com/pydata/pandas/blob/master/pandas/tests/data/iris.csv
@author: user
'''
from sklearn import svm,metrics
import random,re # 난수발생모듈, 정규 표현식 관련 모듈

csv = []
with open("iris.csv","r",encoding="utf-8") as fp :
    for line in fp :
        line = line.strip() # 공백을 제거
        cols = line.split(",") # , 로 구분하기, 단어 구분
        # r'^[0-9\.]+$' :
        # [0-9\.] : 0부터 9까지, .
        # ^ : 시작문자
        # +$ : 종료문자
        fn = lambda n:float(n) if re.match(r'^[0-9\.]+$',n) else n
        cols = list(map(fn,cols))
        csv.append(cols) # iris.csv 파일을 자료형에 맞도록 저장

del csv[0] # Header 부분 삭제.
# csv 리스트 : data만 저장됨
random.shuffle(csv) # csv 데이터 섞기
total_len = len(csv)
train_len = int(total_len * 2 / 3) # 학습 데이터 갯수
train_data = [] # 학습데이터
train_label = [] # 학습데이터의 정답
test_data = [] # 테스트 데이터
test_label = [] # 테스트 데이터의 정답

for i in range(total_len) :
    data = csv[i][0:4]
    label = csv[i][4]
    if i < train_len :
        train_data.append(data)
        train_label.append(label)
    else :
        test_data.append(data)
        test_label.append(label)
clf = svm.SVC()
clf.fit(train_data, train_label) #학습하기
pre = clf.predict(test_data) # test하기

# 정확도 결과 출력
ac_score = metrics.accuracy_score(test_label,pre)
print("정답률=",ac_score)