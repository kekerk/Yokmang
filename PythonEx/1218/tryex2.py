'''
Created on 2018. 12. 18.

@author: gdj4
'''

num1 = input("?«?1 ?? ₯ : ") # λ¬Έμ?΄ ?? ₯λ°κΈ°
num2 = input("?«?2 ?? ₯ : ") # λ¬Έμ?΄ ?? ₯λ°κΈ°

try : 
    num1 = int(num1) # ? ?? ?λ³??
    num2 = int(num2)
    while True :
        res = num1/num2
except ValueError :
    print("λ¬Έμ?΄?? ?«?λ‘? λ³???  ? ??΅??€.")
except ZeroDivisionError :
    print("0?Όλ‘? ?? ? ??΅??€.")
except KeyboardInterrupt :
    print("Ctrl + c ?€λ₯? ????΅??€.")
finally:
    print("?λ‘κ·Έ?¨ μ’λ£")