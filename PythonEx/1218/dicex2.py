'''
Created on 2018. 12. 18.

@author: gdj-4
'''

foods = {"?‘λ³Άμ΄":"???","μ§μ₯λ©?":"κ³ λμ£?","?Όλ©?":"λ§λ","?Ό?":"λ§₯μ£Ό","μΉν¨":"λ§₯μ£Ό","?":"?μ£?","?Όκ²Ήμ΄":"?μ£?"}
while (True) :
    myfood = input(str(list(foods.keys()))+"μ€? μ’μ?? ?????")
    if (myfood in foods) :
        print("<%s> κΆν© ???? <%s> ???€." % (myfood,foods.get(myfood) ))
    elif (myfood == "?") : #foods? λͺ¨λ  ?΄?©? μΆλ ₯?κΈ?
        for i in foods.keys() :
            print("%s : %s" %(i, foods.get(i)))
        break
    else :
        print("κ·Έλ° ???? ??΅??€.")
        yn = input("μ’μ?? ???Όλ‘? ???₯??κ² μ΅?κΉ??(y/n):")
        if(yn == "y") :
            f = input("κΆν© ???? λ¬΄μ??κΉ?? : ")
            foods[myfood] = f
        else :
            break
            