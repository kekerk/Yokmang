'''
Created on 2018. 12. 18.

@author: gdj-4
'''
infp = None
inStr = ""
'''
  open(?ŒŒ?¼?´ë¦?, ?ŒŒ?¼?—´ê¸°ëª¨?“œ)
  
?ŒŒ?¼ ?—´ê¸? ëª¨ë“œ
  "r" : ?½ê¸? ëª¨ë“œ. ê¸°ë³¸ê°?
  "w" : ?“°ê¸? ëª¨ë“œ. ì¡´ì¬?•˜ë©? ?®?–´??
  "r+" : ?½ê¸?/?“°ê¸? ê²¸ìš©
  "a" : ?“°ê¸°ëª¨?“œ, append ëª¨ë“œ, ì¡´ì¬?•˜?Š” ?ŒŒ?¼?¸ ê²½ìš° ?´?–´?„œ ?“´?‹¤.
  "t" : ?…?Š¤?Š¸ëª¨ë“œ, ?ŒŒ?¼?˜ ì¢…ë¥˜, ê¸°ë³¸ê°?
  "b" : ?´ì§„ëª¨?“œ, 
'''
infp = open("c:/temp/data1.txt","r")
inStr = infp.readline()
print(inStr,end="%")
inStr = infp.readline()
print(inStr,end="*")
inStr = infp.readline()
print(inStr,end="!")
infp.close()
