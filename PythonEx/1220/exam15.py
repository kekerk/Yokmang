'''
Created on 2018. 12. 20.

@author: gdj4
'''

ss = input("λ¬Έμ?΄ ?? ₯ : ")

if ss.isalpha() :
    print("κΈ?????€.")
elif ss.isdigit() :
    print("?«????€")
elif ss.isalnum() :
    print("κΈ??+?«????€.")
else :
    print("λͺ¨λ₯΄κ² μ΅??€.")

if ss.islower() :
    print("?λ¬Έμ???€.")
elif ss.isupper() :
    print("??λ¬Έμ???€.")
elif ss.isspace() :
    print("κ³΅λ°±???€.")
else :
    print("κ΅¬λΆ λͺ? ?©??€.")