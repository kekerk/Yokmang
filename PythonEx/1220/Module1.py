'''
Created on 2018. 12. 20.

@author: gdj4
'''

import sys
import math
def func1():
    print("Module1.py 의 func1() 메서드 실행")
def func2():
    print("Module1.py 의 func2() 메서드 실행")
def func3():
    print("Module1.py 의 func3() 메서드 실행")

print(sys.builtin_module_names) # 표준 모듈 목록 리턴
print(dir(__builtins__))
print(dir(math))