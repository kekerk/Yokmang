'''
Created on 2018. 12. 18.
??Όλ³? ?? ? λ³΄λ?? dict ??λ‘? ???₯?κ³?, ??Ό ?΄λ¦μ λ°μ ??λ₯? μΆλ ₯?κΈ?.
?? ??Ό?Έ κ²½μ° dict? ?±λ‘ν μ§? ?¬λΆ? ??Έ ? ?±λ‘?
??Ό ?΄λ¦μ "?" λ¬Έμκ°? ?? ₯?λ©? ??¬ ?±λ‘λ ?΄?©? μΆλ ₯?κ³? μ’λ£?κΈ?
@author: gdj-4
'''
countrys = {"???λ―Όκ΅­":"??Έ","?Όλ³?":"?μΏ?","???€":"?λ¦?","?€????":"??€?λ₯΄λ΄"}
while(True) :
    select = input(str(list(countrys.keys()))+"μ€? ??Όλ₯? ? ???Έ?")
    if (select in countrys):
        print("<%s> ? ??? <%s> ???€." % (select, countrys.get(select)))
    elif (select == "?") :
        for i in countrys.keys() :
            print("%s : %s" %(i, countrys.get(i)))
        break
    else :
        print("?±λ‘λμ§? ??? ??Ό???€.")
        yn = input("??Όλ₯? ?±λ‘ν?κ² μ΅?κΉ??(y/n):")
        if (yn == "y") :
            capital = input(select+"? ??? ?΄???κΉ??")
            countrys[select] = capital
            print("?±λ‘μλ£?")
        else :
            break