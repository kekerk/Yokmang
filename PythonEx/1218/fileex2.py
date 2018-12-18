'''
Created on 2018. 12. 18.

@author: gdj4
'''
outfp = None
outfp = open("c:/temp/data2.txt","w")
while True :
    outStr = input("내용입력: ")
    if outStr != "" :
        outfp.writelines(outStr + "\n")
    else :
        break
outfp.close()
print("프로그램 종료")