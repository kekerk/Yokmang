'''
Created on 2018. 12. 17.
별찍�?
@author: gdj-4
'''
star=""
while(True) :
    print("?��각형?�� 종류�? ?��?��?��?��?��(0[종료],1,2,3)")
    a = int(input())
    if(a == 0) : 
        print("?��?��???�� ?��")
        break
    print("?��?���? ?��?��?��?��?��")
    b = int(input())
    #커�??�� ?��각형
    if(a==1) :
        for i1 in range(1,b+1) :
            for j1 in range(1,i1+1) :
                star = star+ "*"
            print(star)    
            star =""
    #?�� ?��각형    
    elif(a==2) :
        for i2 in range(1,b+1) :
            for j2 in range(1,b+2-i2) :
                star += "*"
            print(star)
            star =""
    #?��?���? ?��각형    
    else :
        for i3 in range(1,b+1) :
            for j3 in range(1,(b*2)) :
                if(j3 >= b-(i3-1) and j3 <= b+(i3-1)) :
                    star += "*"
                else :
                    star += " "
            print(star)
            star=""
                     
