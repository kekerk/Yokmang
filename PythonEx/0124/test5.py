'''
Created on 2019. 1. 24.

@author: gdj4
리스트를 이용하여 10명의 점수를 입력 받아서 점수의 총합 평균 최고점수 최저점수 출력

'''

score = []
while len(score) <10 :
    score.append(int(input(str(len(score)+1)+ "번 점수 입력  :")))
print(score)

sum = 0
for s in score :
    sum+=s
avg = sum/len(score)
print("총점 : ",sum,", 평균 :",avg,", 최고점수 :",max(score),", 최저점수 : ",min(score))
