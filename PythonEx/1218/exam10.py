'''
Created on 2018. 12. 18.

@author: gdj4
'''
infp = open("c:/windows/win.ini","rt")
inStr = infp.readline()

outfp = None
outfp = open("c:/temp/win.bak","wt")
for s in inStr :
        outfp.writelines(s)
infp.close()
outfp.close()
print("?”„ë¡œê·¸?ž¨ ì¢…ë£Œ")
