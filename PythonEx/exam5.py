'''
Created on 2018. 12. 17.
??Έ?/λ³΅νΈ? ?κΈ?
@author: gdj-4
'''
pCode = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ]
cCode = [ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
                '{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' ]
'''
cipher = ""
print("??Έ???¬ λ¬Έμ?΄? ?? ₯??Έ?")
text = str(input())
for i in range(0, len(text)) :
    if text[i] in pCode :
        cipher = cipher + cCode[pCode.index(text[i])]
print("??Έλ¬? : ", cipher)
cipher = ""
text = ""
print("λ³΅νΈ???¬ λ¬Έμ?΄? ?? ₯??Έ?")
cipher = str(input())
for i in range(0, len(cipher)) :
    if cipher[i] in cCode :
        text = text + pCode[cCode.index(cipher[i])]
print("??Έλ¬? : ", text)

'''
cipher = ""
while(True) :
    print("??Έ?[1] / λ³΅νΈ?[2] ? ?")
    num = int(input())
    if(num == 1) :
        print("??Έ???¬ λ¬Έμ?΄? ?? ₯??Έ?")
        text = str(input())
        for i in range(0,len(text)) :
            for j in range(0,len(pCode)) :
                if text[i] == pCode[j] :
                    cipher += cCode[j]
        print("??Έ?: ",cipher)
        cipher, text = "", ""
    elif(num ==2) :
        print("λ³΅νΈ???¬ λ¬Έμ?΄? ?? ₯??Έ?")
        cipher = str(input())
        for i in range(0,len(cipher)) :
            for j in range(0,len(cCode)) :
                if cipher[i] == cCode[j] :
                    text += pCode[j]
        print("λ³΅νΈ?: ",text)
        cipher, text = "", ""
    else :
        print("? κ·? ??¬. ??Έ?λ‘κ·Έ?¨ κ°μ μ’λ£")
        break