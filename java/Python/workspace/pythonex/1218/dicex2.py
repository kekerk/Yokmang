'''
Created on 2018. 12. 18.

@author: gdj-4
'''

foods = {"떡볶이":"순대","짜장면":"고량주","라면":"만두","피자":"맥주","치킨":"맥주","회":"소주","삼겹살":"소주"}
while (True) :
    myfood = input(str(list(foods.keys()))+"중 좋아하는 음식은?")
    if (myfood in foods) :
        print("<%s> 궁합 음식은 <%s> 입니다." % (myfood,foods.get(myfood) ))
    elif (myfood == "끝") : #foods의 모든 내용을 출력하기
        for i in foods.keys() :
            print("%s : %s" %(i, foods.get(i)))
        break
    else :
        print("그런 음식은 없습니다.")
        yn = input("좋아하는 음식으로 저장하시겠습니까?(y/n):")
        if(yn == "y") :
            f = input("궁합 음식은 무엇입니까? : ")
            foods[myfood] = f
        else :
            break
            