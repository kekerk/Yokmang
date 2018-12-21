'''
Created on 2018. 12. 20.

@author: gdj4
'''

# 모듈에서 함수 선언을 하지 않는 부분은 제일 먼저 실행이 된다.
# 함수 부분은 함수가 아닌 부분을 먼저 실행한 후에 실행이 된다.
import sys
import math
def func1():
    print("Module1.py 의 func1() 메서드 실행")
def func2():
    print("Module1.py 의 func2() 메서드 실행")
 
def func3():
    print("Module1.py 의 func3() 메서드 실행")

if __name__ == '__main__' :
    print(sys.builtin_module_names) # 표준 모듈 목록 리턴
    print(dir(__builtins__))
    print(dir(math))