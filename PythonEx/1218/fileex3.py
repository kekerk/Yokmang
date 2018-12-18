'''
Created on 2018. 12. 18.
fileex3 : utf-8파일 읽기
@author: gdj4
'''

infp = None
inStr = ""
infp = open("c:/temp/data1utf8.txt","r",encoding="utf-8")
while True : 
    inStr = infp.readline()
    if inStr == "" :
        break
    print(inStr,end="")
infp.close()