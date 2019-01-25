'''
Created on 2019. 1. 9.

@author: gdj4

bmi를 이용하여 마름, 정상, 비만 데이터를 생성하기
'''

import random

def calc_bmi(h,w):
    bmi = w / (h/100) ** 2
    if bmi <18.5 :return "thin"
    if bmi < 25 : return "normal"
    return "fat"

fp = open("bmi.csv","w",encoding="utf-8")
fp.write("height,weight,label\r\n")

cnt = {"thin":0,"normal":0,"fat":0}
for i in range(20000) :
    h = random.randint(120,200) # 키의 범위 지정하는 난수로 선택
    w = random.randint(30,100) # 몸무게의 범위를 지정하는 난수 선택
    label = calc_bmi(h,w)
    cnt[label] += 1
    fp.write("{0},{1},{2}\r\n".format(h,w,label))
fp.close()
print("프로그램 종료")
