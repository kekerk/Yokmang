'''
Created on 2018. 12. 18.

@author: gdj4
'''

myStr = "?ŒŒ?´?¬ ê³µë?ì¤‘ì…?‹ˆ?‹¤. ?ŒŒ?´?¬?? ?‰½?Šµ?‹ˆ?‹¤."
strPosList = []
index = 0
while True :
    try :
        index = myStr.index("?ŒŒ?´?¬",index) # ?ŒŒ?´?¬ ë¬¸ì?˜ ?œ„ì¹˜ë?? index ê°? ?´?›„?—?„œ ê²??ƒ‰
        strPosList.append(index) # 0
        index += 1
    except :
        break
print("?ŒŒ?´?¬ ë¬¸ì?˜ ?œ„ì¹? :" ,strPosList)