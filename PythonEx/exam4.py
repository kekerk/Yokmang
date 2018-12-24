'''
Created on 2018. 12. 17.
ë³„ì°ê¸?
@author: gdj-4
'''
star=""
while(True) :
    print("?‚¼ê°í˜•?˜ ì¢…ë¥˜ë¥? ?…? ¥?•˜?„¸?š”(0[ì¢…ë£Œ],1,2,3)")
    a = int(input())
    if(a == 0) : 
        print("?„?˜•???´ ?")
        break
    print("?†’?´ë¥? ?…? ¥?•˜?„¸?š”")
    b = int(input())
    #ì»¤ì??Š” ?‚¼ê°í˜•
    if(a==1) :
        for i1 in range(1,b+1) :
            for j1 in range(1,i1+1) :
                star = star+ "*"
            print(star)    
            star =""
    #?—­ ?‚¼ê°í˜•    
    elif(a==2) :
        for i2 in range(1,b+1) :
            for j2 in range(1,b+2-i2) :
                star += "*"
            print(star)
            star =""
    #?´?“±ë³? ?‚¼ê°í˜•    
    else :
        for i3 in range(1,b+1) :
            for j3 in range(1,(b*2)) :
                if(j3 >= b-(i3-1) and j3 <= b+(i3-1)) :
                    star += "*"
                else :
                    star += " "
            print(star)
            star=""
                     
