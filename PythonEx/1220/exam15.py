'''
Created on 2018. 12. 20.

@author: gdj4
'''

ss = input("ë¬¸ì?—´ ?…? ¥ : ")

if ss.isalpha() :
    print("ê¸???…?‹ˆ?‹¤.")
elif ss.isdigit() :
    print("?ˆ«??…?‹ˆ?‹¤")
elif ss.isalnum() :
    print("ê¸??+?ˆ«??…?‹ˆ?‹¤.")
else :
    print("ëª¨ë¥´ê² ìŠµ?‹ˆ?‹¤.")

if ss.islower() :
    print("?†Œë¬¸ì?…?‹ˆ?‹¤.")
elif ss.isupper() :
    print("??ë¬¸ì?…?‹ˆ?‹¤.")
elif ss.isspace() :
    print("ê³µë°±?…?‹ˆ?‹¤.")
else :
    print("êµ¬ë¶„ ëª? ?•©?‹ˆ?‹¤.")