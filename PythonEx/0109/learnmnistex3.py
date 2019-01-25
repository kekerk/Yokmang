'''
Created on 2019. 1. 9.

@author: gdj4
이미지 데이터 학습하기
'''

from sklearn import model_selection,svm,metrics

def load_csv(fname):
    labels = [] # 숫자값
    images = [] # 이미지 이진파일
    with open(fname,"r") as f:
        for line in f:
            cols = line.split(",")
            if len(cols)<2 : continue # ,를 이용한 단어수가 1이하인 경우 다음 라인을 읽기
            labels.append(int(cols.pop(0))) # 정답. 숫자값
            vals = list(map(lambda n : int(n)/256,cols)) # cols : 이미지정보 데이터만 존재
            images.append(vals)
        return {"labels":labels,"images":images}
data = load_csv("./mnist/train.csv")
test = load_csv("./mnist/t10k.csv")

clf = svm.SVC()
clf.fit(data["images"],data["labels"])
pre = clf.predict(test["images"])
ac_score = metrics.accuracy_score(test["labels"],pre)
cl_report = metrics.classification_report(test["labels"],pre)
print("정답률 = ",ac_score)
print("리포트 = ")
print(cl_report)
