'''
Created on 2019. 1. 24.

@author: gdj4

숫자 야구 게임
  a = "369"
  b = "639"
  
  1 strike 2 ball
  
  a.count(b) : a 문자열에  b문자의 갯수 리턴
  a.find(b) : a 문자열에  b문자의 위치 리턴
'''
a = "369"
b = "639"
strike = 0
ball = 0

for n in a :
    if b.count(n) == 1 :
        if b.find(n) == a.find(n) :
            strike += 1
        else :
            ball += 1
print(strike,"strike", ",", ball," ball")