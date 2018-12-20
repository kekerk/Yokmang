'''
Created on 2018. 12. 20.
exam19.py : 파일을 읽어서 라인수와 내용을 화면에 출력하기
@author: gdj4
'''

inFp = None # 입력파일
inStr = "" # 읽어온 문자열
inFp = open("c:/temp/data1.txt","r") # 파일을 읽어옴
count = 0
while True :
    inStr = inFp.readline() # inFp에서 읽어온 파일을 한 행 읽어 inStr에 저장
    count += 1
    if inStr == "" :
        break
    print("%d:%s" % (count,inStr),end='')
inFp.close()