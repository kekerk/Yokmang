'''
Created on 2018. 12. 18.

@author: gdj-4
'''
infp = None
inStr = ""
'''
  open(파일이름, 파일열기모드)
  
파일 열기 모드
  "r" : 읽기 모드. 기본값
  "w" : 쓰기 모드. 존재하면 덮어씀
  "r+" : 읽기/쓰기 겸용
  "a" : 쓰기모드, append 모드, 존재하는 파일인 경우 이어서 쓴다.
  "t" : 텍스트모드, 파일의 종류, 기본값
  "b" : 이진모드, 
'''
infp = open("c:/temp/data1.txt","r")
inStr = infp.readline()
print(inStr,end="%")
inStr = infp.readline()
print(inStr,end="*")
inStr = infp.readline()
print(inStr,end="!")
infp.close()
