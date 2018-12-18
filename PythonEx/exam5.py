'''
Created on 2018. 12. 17.
암호화/복호화 하기
@author: gdj-4
'''
pCode = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ]
cCode = [ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
                '{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' ]
'''
cipher = ""
print("암호화시킬 문자열을 입력하세요")
text = str(input())
for i in range(0, len(text)) :
    if text[i] in pCode :
        cipher = cipher + cCode[pCode.index(text[i])]
print("암호문 : ", cipher)
cipher = ""
text = ""
print("복호화시킬 문자열을 입력하세요")
cipher = str(input())
for i in range(0, len(cipher)) :
    if cipher[i] in cCode :
        text = text + pCode[cCode.index(cipher[i])]
print("암호문 : ", text)

'''
cipher = ""
while(True) :
    print("암호화[1] / 복호화[2] 선택")
    num = int(input())
    if(num == 1) :
        print("암호화시킬 문자열을 입력하세요")
        text = str(input())
        for i in range(0,len(text)) :
            for j in range(0,len(pCode)) :
                if text[i] == pCode[j] :
                    cipher += cCode[j]
        print("암호화: ",cipher)
        cipher, text = "", ""
    elif(num ==2) :
        print("복호화시킬 문자열을 입력하세요")
        cipher = str(input())
        for i in range(0,len(cipher)) :
            for j in range(0,len(cCode)) :
                if cipher[i] == cCode[j] :
                    text += pCode[j]
        print("복호화: ",text)
        cipher, text = "", ""
    else :
        print("접근 에러. 암호프로그램 강제종료")
        break