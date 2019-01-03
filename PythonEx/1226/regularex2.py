'''
Created on 2018. 12. 26.

?��규식?�� ?��?��?��?�� regularex1.py ?? 같�? 결과 ?���?
@author: gdj4
'''

import re  # ?��규식?�� ?��?��?���? ?��?�� 모듈


data = '''
    park 800905-1234567
    kim  700905-1234567
    choi 850101-a123456
'''

'''
  () : 그룹 �??��
  [] : 문자�??��
  {} : �??��
  \d : ?��?�� 
  (\d{6})[-]\d{7} : ?��?�� �??��
  \g<1> : 첫번�? 그룹
  
  * : 0�? ?��?�� 반복 ?���?
     ca*t : a문자�?  0�? ?��?��?�� 경우.
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  + : 1�? ?��?�� 반복 ?���?
     ca+t : a문자�? 1�? ?��?��?�� 경우.
            "ct" : false
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  {n} : n�? 반복
     ca{2}t : a문자�? 2�? 반복
            "ct" : false
            "cat" : false
            "caat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
   ? : 0 ?��?�� 1개인 경우
     ca?t : a문자�? ?��거나 1개인 경우
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
'''
pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******",data))
