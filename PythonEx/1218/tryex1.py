'''
Created on 2018. 12. 18.

@author: gdj4
'''

myStr = "?��?��?�� 공�?중입?��?��. ?��?��?��?? ?��?��?��?��."
strPosList = []
index = 0
while True :
    try :
        index = myStr.index("?��?��?��",index) # ?��?��?�� 문자?�� ?��치�?? index �? ?��?��?��?�� �??��
        strPosList.append(index) # 0
        index += 1
    except :
        break
print("?��?��?�� 문자?�� ?���? :" ,strPosList)