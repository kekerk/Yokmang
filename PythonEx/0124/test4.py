'''
Created on 2019. 1. 24.

@author: gdj4
삼각형의 종류(1,2,3) 입력받기
삼각형의 단계 입력받기(1~10)

형식문자 : < 좌측정렬
        > 우측정렬
        ^ 가운데정렬
'''

t = input("삼각형의 유형을 입력하세요(1,2,3) : ")
if t == "1" :
    r = "{:<11}"
elif t == "2" :
    r="{:^11}"
else :
    r="{:>11}"
for i in range(1,12,2) :
    print(r.format("*"*i))