'''
Created on 2018. 12. 18.

@author: gdj-4
'''
infp = None
inStr = ""

infp = open("c:/temp/data1.txt","r")
inStr = infp.readline()
print(inStr,end="%")
inStr = infp.readline()
print(inStr,end="*")
inStr = infp.readline()
print(inStr,end="!")
infp.close()
