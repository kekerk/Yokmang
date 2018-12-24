'''
Created on 2018. 12. 17.

@author: gdj-4
'''
a,b,hap = 0,0,0

while(True) : #ì¤„ì„ ?˜ ë§ì¶°?•¼?•œ?‹¤.
    print("ì²«ë²ˆì§? ?ˆ˜ë¥? ?…? ¥?•˜?„¸?š”")
    a = int(input())
    if a==0 :
        break
    print("?‘ë²ˆì§¸ ?ˆ˜ë¥? ?…? ¥?•˜?„¸?š”")
    b = int(input())
    hap = a + b
    print("%d + %d = %d" % (a,b,hap))
print("?”„ë¡œê·¸?¨ ì¢…ë£Œ")
