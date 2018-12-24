'''
Created on 2018. 12. 18.

@author: gdj-4
'''

foods = {"?–¡ë³¶ì´":"?ˆœ??","ì§œì¥ë©?":"ê³ ëŸ‰ì£?","?¼ë©?":"ë§Œë‘","?”¼?":"ë§¥ì£¼","ì¹˜í‚¨":"ë§¥ì£¼","?šŒ":"?†Œì£?","?‚¼ê²¹ì‚´":"?†Œì£?"}
while (True) :
    myfood = input(str(list(foods.keys()))+"ì¤? ì¢‹ì•„?•˜?Š” ?Œ?‹???")
    if (myfood in foods) :
        print("<%s> ê¶í•© ?Œ?‹?? <%s> ?…?‹ˆ?‹¤." % (myfood,foods.get(myfood) ))
    elif (myfood == "?") : #foods?˜ ëª¨ë“  ?‚´?š©?„ ì¶œë ¥?•˜ê¸?
        for i in foods.keys() :
            print("%s : %s" %(i, foods.get(i)))
        break
    else :
        print("ê·¸ëŸ° ?Œ?‹?? ?—†?Šµ?‹ˆ?‹¤.")
        yn = input("ì¢‹ì•„?•˜?Š” ?Œ?‹?œ¼ë¡? ???¥?•˜?‹œê² ìŠµ?‹ˆê¹??(y/n):")
        if(yn == "y") :
            f = input("ê¶í•© ?Œ?‹?? ë¬´ì—‡?…?‹ˆê¹?? : ")
            foods[myfood] = f
        else :
            break
            