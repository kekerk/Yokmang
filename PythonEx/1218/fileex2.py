'''
Created on 2018. 12. 18.

@author: gdj4
'''
outfp = None
outfp = open("c:/temp/data2.txt","w")
while True :
    outStr = input("?ด?ฉ?? ฅ: ")
    if outStr != "" :
        outfp.writelines(outStr + "\n")
    else :
        break
outfp.close()
print("?๋ก๊ทธ?จ ์ข๋ฃ")