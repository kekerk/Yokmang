'''
Created on 2018. 12. 17.
?��?��?��/복호?�� ?���?
@author: gdj-4
'''
pCode = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ]
cCode = [ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
                '{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' ]
'''
cipher = ""
print("?��?��?��?��?�� 문자?��?�� ?��?��?��?��?��")
text = str(input())
for i in range(0, len(text)) :
    if text[i] in pCode :
        cipher = cipher + cCode[pCode.index(text[i])]
print("?��?���? : ", cipher)
cipher = ""
text = ""
print("복호?��?��?�� 문자?��?�� ?��?��?��?��?��")
cipher = str(input())
for i in range(0, len(cipher)) :
    if cipher[i] in cCode :
        text = text + pCode[cCode.index(cipher[i])]
print("?��?���? : ", text)

'''
cipher = ""
while(True) :
    print("?��?��?��[1] / 복호?��[2] ?��?��")
    num = int(input())
    if(num == 1) :
        print("?��?��?��?��?�� 문자?��?�� ?��?��?��?��?��")
        text = str(input())
        for i in range(0,len(text)) :
            for j in range(0,len(pCode)) :
                if text[i] == pCode[j] :
                    cipher += cCode[j]
        print("?��?��?��: ",cipher)
        cipher, text = "", ""
    elif(num ==2) :
        print("복호?��?��?�� 문자?��?�� ?��?��?��?��?��")
        cipher = str(input())
        for i in range(0,len(cipher)) :
            for j in range(0,len(cCode)) :
                if cipher[i] == cCode[j] :
                    text += pCode[j]
        print("복호?��: ",text)
        cipher, text = "", ""
    else :
        print("?���? ?��?��. ?��?��?��로그?�� 강제종료")
        break