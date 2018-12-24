'''
Created on 2018. 12. 21.

@author: gdj4
classEx5.py : ?´?˜?Š¤?—?„œ ?‚¬?š©?˜?Š” ì§?? •?œ ?Š¹ë³„í•œ ë©”ì„œ?“œ
'''
class Line :
    length = 0
    def __init__(self,length): # ?ƒ?„±? ê°ì²´ ?ƒ?„± ?‹œ ?˜¸ì¶œë˜?Š” ë©”ì„œ?“œ
        self.length = length
        print(self.length,"ê¸¸ì´?˜ ?„ ?´ ?ƒ?„±?˜?—ˆ?Šµ?‹ˆ?‹¤.")
    def __del__(self): # ?†Œë©¸ì : ê°ì²´ ? œê±°ì‹œ ?˜¸ì¶œë˜?Š” ë©”ì„œ?“œ
        print(self.length,"ê¸¸ì´?˜ ?„ ?´ ? œê±? ?˜?—ˆ?Šµ?‹ˆ?‹¤.")
    def __repr__(self): # ?ë°”ì˜ toStringê°™ì? ê¸°ëŠ¥?„ ê°?ì§?. ê°ì²´?˜ ì¶œë ¥ ?‹´?‹¹?•˜?Š” ë©”ì„œ?“œ
        return "?„ ?˜ ê¸¸ì´ : "+str(self.length)
    def __add__(self,other): # ?”?•˜ê¸? ?—°?‚°? ?‚¬?š©?‹œ ?˜¸ì¶œë˜?Š” ë©”ì„œ?“œ
        return self.length + other.length
    def __lt__(self,other):
        return self.length < other.length
    def __eq__(self,other):
        return self.length == other.length
    
myLine1 = Line(100) # ê°ì²´?™”, ?ƒ?„±? ?˜¸ì¶?
myLine2 = Line(200)
print(myLine1)
print(myLine2)

print("?‘ ?„ ?˜ ê¸¸ì´?˜ ?•© : ",myLine1 + myLine2)
## ?”„ë¡œê·¸?¨ ì¢…ë£Œ : ?ƒ?„±?œ ê°ì²´ê°? ??™?œ¼ë¡? ?†Œë©¸ë¨. ?†Œë©¸ìê°? ?˜¸ì¶?

if myLine1 < myLine2 :
    print("myLine2ê°? ?” ê¹ë‹ˆ?‹¤.")
elif myLine1 == myLine2 :
    print("?‘ ?„ ?˜ ê¸¸ì´ê°? ê°™ìŠµ?‹ˆ?‹¤.")
else :
    print("myLine1?´ ?” ê¹ë‹ˆ?‹¤.")