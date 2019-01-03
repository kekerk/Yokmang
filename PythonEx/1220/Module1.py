'''
Created on 2018. 12. 20.

@author: gdj4
'''

# ëª¨ë“ˆ?—?„œ ?•¨?ˆ˜ ?„ ?–¸?„ ?•˜ì§? ?•Š?Š” ë¶?ë¶„ì? ? œ?¼ ë¨¼ì? ?‹¤?–‰?´ ?œ?‹¤.
# ?•¨?ˆ˜ ë¶?ë¶„ì? ?•¨?ˆ˜ê°? ?•„?‹Œ ë¶?ë¶„ì„ ë¨¼ì? ?‹¤?–‰?•œ ?›„?— ?‹¤?–‰?´ ?œ?‹¤.
import math
import sys


def func1():
    print("Module1.py ?˜ func1() ë©”ì„œ?“œ ?‹¤?–‰")
def func2():
    print("Module1.py ?˜ func2() ë©”ì„œ?“œ ?‹¤?–‰")
 
def func3():
    print("Module1.py ?˜ func3() ë©”ì„œ?“œ ?‹¤?–‰")

if __name__ == '__main__' :
    print(sys.builtin_module_names) # ?‘œì¤? ëª¨ë“ˆ ëª©ë¡ ë¦¬í„´
    print(dir(__builtins__))
    print(dir(math))