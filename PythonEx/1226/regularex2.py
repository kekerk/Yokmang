'''
Created on 2018. 12. 26.

? •ê·œì‹?„ ?´?š©?•˜?—¬ regularex1.py ?? ê°™ì? ê²°ê³¼ ?–»ê¸?
@author: gdj4
'''

import re  # ? •ê·œì‹?„ ?‚¬?š©?•˜ê¸? ?œ„?•œ ëª¨ë“ˆ


data = '''
    park 800905-1234567
    kim  700905-1234567
    choi 850101-a123456
'''

'''
  () : ê·¸ë£¹ ì§?? •
  [] : ë¬¸ìì§?? •
  {} : ê°??ˆ˜
  \d : ?ˆ«? 
  (\d{6})[-]\d{7} : ?Œ¨?„´ ì§?? •
  \g<1> : ì²«ë²ˆì§? ê·¸ë£¹
  
  * : 0ê°? ?´?ƒ ë°˜ë³µ ?˜ë¯?
     ca*t : aë¬¸ìê°?  0ê°? ?´?ƒ?¸ ê²½ìš°.
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  + : 1ê°? ?´?ƒ ë°˜ë³µ ?˜ë¯?
     ca+t : aë¬¸ìê°? 1ê°? ?´?ƒ?¸ ê²½ìš°.
            "ct" : false
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  {n} : nê°? ë°˜ë³µ
     ca{2}t : aë¬¸ìê°? 2ê°? ë°˜ë³µ
            "ct" : false
            "cat" : false
            "caat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
   ? : 0 ?˜?Š” 1ê°œì¸ ê²½ìš°
     ca?t : aë¬¸ìê°? ?—†ê±°ë‚˜ 1ê°œì¸ ê²½ìš°
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
'''
pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******",data))
