'''
Created on 2018. 12. 18.

@author: gdj4
'''

infp = open("c:/Temp/data1.txt","rt")

# while True :
#     inStr = infp.readline()
#     if not inStr :
#         break
#     print(inStr, end="")
#     
inStr = ""
inStr = infp.readline()
for s in inStr :
    print(s,end="")
infp.close()