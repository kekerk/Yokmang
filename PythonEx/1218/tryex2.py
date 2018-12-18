'''
Created on 2018. 12. 18.

@author: gdj4
'''

num1 = input("숫자1 입력 : ") # 문자열 입력받기
num2 = input("숫자2 입력 : ") # 문자열 입력받기

try : 
    num1 = int(num1) # 정수형 형변환
    num2 = int(num2)
    while True :
        res = num1/num2
except ValueError :
    print("문자열은 숫자로 변환할 수 없습니다.")
except ZeroDivisionError :
    print("0으로 나눌 수 없습니다.")
except KeyboardInterrupt :
    print("Ctrl + c 키를 눌렀습니다.")