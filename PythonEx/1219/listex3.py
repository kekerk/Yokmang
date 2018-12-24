'''
Created on 2018. 12. 19.

@author: gdj4
'''
foods = ["?–¡ë³¶ì´","ì§œì¥ë©?","?¼ë©?"]
sides = ["?˜¤?…","?‹¨ë¬´ì?","ê¹?ì¹?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
# ?‘ ê°œì˜ ë¦¬ìŠ¤?Š¸ë¥? ?Šœ?”Œ?˜ ë¦¬ìŠ¤?Š¸ ê°ì²´ë¡? ?ƒ?„±
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)
