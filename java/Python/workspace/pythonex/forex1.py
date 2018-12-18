'''
Created on 2018. 12. 17.

@author: gdj-4
'''
import random #유틸리티(기능)를 사용하기 위한 객체를 끌고 오기.
import keyword #자바의 package import하는 것과 비슷

numbers = [] #배열 선언, 리스트 선언
for num in range(0,10,2) : #0에서 9까지 1씩 증가하면서 반복함. numbers.length : 10
    numbers.append(random.randrange(0,10)) #0부터 9까지 임의의 값을 찾아서 numbers에 추가
print("생성된 리스트",numbers)

for num in range(0,10,2) :
    if(num not in numbers) : 
        print("숫자 %d는 리스트에 없습니다." % num)

print(keyword.kwlist) #파이썬에서 사용되는 예약어 목록 출력함.