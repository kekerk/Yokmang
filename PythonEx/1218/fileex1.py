'''
Created on 2018. 12. 18.

@author: gdj-4
'''
infp = None
inStr = ""
'''
  open(?��?��?���?, ?��?��?��기모?��)
  
?��?�� ?���? 모드
  "r" : ?���? 모드. 기본�?
  "w" : ?���? 모드. 존재?���? ?��?��??
  "r+" : ?���?/?���? 겸용
  "a" : ?��기모?��, append 모드, 존재?��?�� ?��?��?�� 경우 ?��?��?�� ?��?��.
  "t" : ?��?��?��모드, ?��?��?�� 종류, 기본�?
  "b" : ?��진모?��, 
'''
infp = open("c:/temp/data1.txt","r")
inStr = infp.readline()
print(inStr,end="%")
inStr = infp.readline()
print(inStr,end="*")
inStr = infp.readline()
print(inStr,end="!")
infp.close()
