'''
Created on 2018. 12. 26.

정규식을 이용하여 regularex1.py 와 같은 결과 얻기
@author: gdj4
'''

import re  # 정규식을 사용하기 위한 모듈

data = '''
    park 800905-1234567
    kim  700905-1234567
    choi 850101-a123456
'''

'''
  () : 그룹 지정
  [] : 문자지정
  {} : 갯수
  \d : 숫자 
  (\d{6})[-]\d{7} : 패턴 지정
  \g<1> : 첫번째 그룹
  
  * : 0개 이상 반복 의미
     ca*t : a문자가  0개 이상인 경우.
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  + : 1개 이상 반복 의미
     ca+t : a문자가 1개 이상인 경우.
            "ct" : false
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : true
  {n} : n개 반복
     ca{2}t : a문자가 2개 반복
            "ct" : false
            "cat" : false
            "caat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
   ? : 0 또는 1개인 경우
     ca?t : a문자가 없거나 1개인 경우
            "ct" : true
            "cat" : true
            "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat" : false
'''
pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******",data))
