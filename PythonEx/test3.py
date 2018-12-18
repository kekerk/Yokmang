'''
Created on 2018. 12. 17.

@author: gdj-4
'''

a = 10,20,30,40,50 
print(a[0:])
print(a)
print("안녕하세요")
print("안녕하세요"[0])
print("안녕하세요"[1])
print("안녕하세요"[2])
print("안녕하세요"[3])
print("안녕하세요"[4])
print("안녕하세요"[-1])
print("안녕하세요"[-2])
print("안녕하세요"[-3])
print("안녕하세요"[-4])
print("안녕하세요"[-5])
print("안녕하세요"[1:3]) #인덱스1부터 인덱스3의 앞까지 가져온다(1~2)
print("안녕하세요"[:3]) #인덱스0부터 인덱스3의 앞까지 가져온다(0~2)
print("안녕하세요"[2:]) #인덱스2부터 인덱스의 마지막까지 가져온다(2~4)

print("자료형 조회하기 : type")
s = "반갑습니다."
print(type(s))
print(type(len(s)))

arr = [10,20,30,40,50,60,70]
print(arr[:2])
print(arr[::2])
print(arr[::-2])
print(arr[::-1]) #역순 찍기