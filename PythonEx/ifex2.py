'''
Created on 2018. 12. 17.

@author: gdj-4
'''
score = int(input("점수를 입력하세요(0~100):"))
if score>=90 :
    print("A")
else : 
    if score >= 80 :
        print("B")
    else : 
        if score >= 70 :
            print("C")
        else :
            if score >= 60 :
                print("D")
            else : 
                print("F")
        
print("if elif 연습")
if score >= 90 :
    print("A")
elif score >= 80 : #java의 else if와 같다.
    print("B")
elif score >= 70 :
    print("C")
elif score >= 60 :
    print("D")
else :
    print("F")
    
#switch 구문이 없다.
            