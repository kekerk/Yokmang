'''
Created on 2018. 12. 18.

@author: gdj4
'''

myStr = "??΄?¬ κ³΅λ?μ€μ??€. ??΄?¬?? ?½?΅??€."
strPosList = []
index = 0
while True :
    try :
        index = myStr.index("??΄?¬",index) # ??΄?¬ λ¬Έμ? ?μΉλ?? index κ°? ?΄??? κ²??
        strPosList.append(index) # 0
        index += 1
    except :
        break
print("??΄?¬ λ¬Έμ? ?μΉ? :" ,strPosList)