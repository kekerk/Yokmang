'''
Created on 2018. 12. 18.

@author: gdj-4
'''

foods = {"?��볶이":"?��??","짜장�?":"고량�?","?���?":"만두","?��?��":"맥주","치킨":"맥주","?��":"?���?","?��겹살":"?���?"}
while (True) :
    myfood = input(str(list(foods.keys()))+"�? 좋아?��?�� ?��?��???")
    if (myfood in foods) :
        print("<%s> 궁합 ?��?��?? <%s> ?��?��?��." % (myfood,foods.get(myfood) ))
    elif (myfood == "?��") : #foods?�� 모든 ?��?��?�� 출력?���?
        for i in foods.keys() :
            print("%s : %s" %(i, foods.get(i)))
        break
    else :
        print("그런 ?��?��?? ?��?��?��?��.")
        yn = input("좋아?��?�� ?��?��?���? ???��?��?��겠습?���??(y/n):")
        if(yn == "y") :
            f = input("궁합 ?��?��?? 무엇?��?���?? : ")
            foods[myfood] = f
        else :
            break
            