'''
Created on 2018. 12. 18.

@author: gdj4
'''

num1 = input("?ˆ«?1 ?…? ¥ : ") # ë¬¸ì?—´ ?…? ¥ë°›ê¸°
num2 = input("?ˆ«?2 ?…? ¥ : ") # ë¬¸ì?—´ ?…? ¥ë°›ê¸°

try : 
    num1 = int(num1) # ? •?ˆ˜?˜• ?˜•ë³??™˜
    num2 = int(num2)
    while True :
        res = num1/num2
except ValueError :
    print("ë¬¸ì?—´?? ?ˆ«?ë¡? ë³??™˜?•  ?ˆ˜ ?—†?Šµ?‹ˆ?‹¤.")
except ZeroDivisionError :
    print("0?œ¼ë¡? ?‚˜?ˆŒ ?ˆ˜ ?—†?Šµ?‹ˆ?‹¤.")
except KeyboardInterrupt :
    print("Ctrl + c ?‚¤ë¥? ?ˆŒ???Šµ?‹ˆ?‹¤.")
finally:
    print("?”„ë¡œê·¸?¨ ì¢…ë£Œ")