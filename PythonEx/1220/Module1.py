'''
Created on 2018. 12. 20.

@author: gdj4
'''

# λͺ¨λ?? ?¨? ? ?Έ? ?μ§? ?? λΆ?λΆμ? ? ?Ό λ¨Όμ? ?€??΄ ??€.
# ?¨? λΆ?λΆμ? ?¨?κ°? ?? λΆ?λΆμ λ¨Όμ? ?€?? ?? ?€??΄ ??€.
import math
import sys


def func1():
    print("Module1.py ? func1() λ©μ? ?€?")
def func2():
    print("Module1.py ? func2() λ©μ? ?€?")
 
def func3():
    print("Module1.py ? func3() λ©μ? ?€?")

if __name__ == '__main__' :
    print(sys.builtin_module_names) # ?μ€? λͺ¨λ λͺ©λ‘ λ¦¬ν΄
    print(dir(__builtins__))
    print(dir(math))