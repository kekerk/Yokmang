'''
Created on 2018. 12. 17.
?•”?˜¸?™”/ë³µí˜¸?™” ?•˜ê¸?
@author: gdj-4
'''
pCode = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ]
cCode = [ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
                '{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' ]
'''
cipher = ""
print("?•”?˜¸?™”?‹œ?‚¬ ë¬¸ì?—´?„ ?…? ¥?•˜?„¸?š”")
text = str(input())
for i in range(0, len(text)) :
    if text[i] in pCode :
        cipher = cipher + cCode[pCode.index(text[i])]
print("?•”?˜¸ë¬? : ", cipher)
cipher = ""
text = ""
print("ë³µí˜¸?™”?‹œ?‚¬ ë¬¸ì?—´?„ ?…? ¥?•˜?„¸?š”")
cipher = str(input())
for i in range(0, len(cipher)) :
    if cipher[i] in cCode :
        text = text + pCode[cCode.index(cipher[i])]
print("?•”?˜¸ë¬? : ", text)

'''
cipher = ""
while(True) :
    print("?•”?˜¸?™”[1] / ë³µí˜¸?™”[2] ?„ ?ƒ")
    num = int(input())
    if(num == 1) :
        print("?•”?˜¸?™”?‹œ?‚¬ ë¬¸ì?—´?„ ?…? ¥?•˜?„¸?š”")
        text = str(input())
        for i in range(0,len(text)) :
            for j in range(0,len(pCode)) :
                if text[i] == pCode[j] :
                    cipher += cCode[j]
        print("?•”?˜¸?™”: ",cipher)
        cipher, text = "", ""
    elif(num ==2) :
        print("ë³µí˜¸?™”?‹œ?‚¬ ë¬¸ì?—´?„ ?…? ¥?•˜?„¸?š”")
        cipher = str(input())
        for i in range(0,len(cipher)) :
            for j in range(0,len(cCode)) :
                if cipher[i] == cCode[j] :
                    text += pCode[j]
        print("ë³µí˜¸?™”: ",text)
        cipher, text = "", ""
    else :
        print("? ‘ê·? ?—?Ÿ¬. ?•”?˜¸?”„ë¡œê·¸?¨ ê°•ì œì¢…ë£Œ")
        break