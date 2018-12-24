'''
Created on 2018. 12. 19.

@author: gdj4
'''
#ë¦¬ìŠ¤?Š¸

# a ë¦¬ìŠ¤?Š¸?—?„œ you too ì¶œë ¥?•˜ê¸?
a = ['Life', 'is', 'too', 'short', 'you', 'need', 'python']
b = a[4],a[2]
c = ' '.join(b)
print("%s" % c)

# a ë¦¬ìŠ¤?Š¸?˜ ?‚¬?´ì¦? êµ¬í•˜ê¸?
a = [1,2,3]
print(len(a))
a.append([4,5]) # append?Š” list ?ì²´ê? ì¶”ê?
print(a)
a = [1,2,3]
a.extend([4,5]) # extend ?Š” ê¸°ì¡´?— ?ˆ?˜ ?•¨?ˆ˜?— listë¥? ?”?•˜?Š” ê²°ê³¼
print(a)

# 1,3,5ë¡? ì¶œë ¥?•˜ê¸?
mlist = [1,2,3,4,5]
mlist.remove(2)
mlist.remove(4)
print(mlist)

# ?Šœ?”Œ
foods = ["?–¡ë³¶ì´","ì§œì¥ë©?","?¼ë©?"]
sides = ["?˜¤?…","?‹¨ë¬´ì?","ê¹?ì¹?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)

# 3ë§Œì„ ?š”?†Œë¡? ê°?ì§??Š” ?Šœ?”Œ ?ƒ?„±

a = (3)

# ?Šœ?”Œ?? ì²˜ìŒ ?ƒ?„±?•œ ê°’ì—?„œ ?ˆ˜? • ?‚­? œê°? ë¶ˆê??Š¥?•˜?‹¤. ?´ë¥? ?ˆ˜? •?•˜ê±°ë‚˜ ?‚­? œ?•˜? ¤ë©? ë¦¬ìŠ¤?Š¸ë¡? ë°”ê¿”ì¤? ?’¤ ?‹¤?‹œ ?Šœ?”Œë¡? ë§Œë“¤?–´ì£¼ì–´?•¼ ?•¨

myTuple = (10,20,30)
print(myTuple)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)

# ?”•?…”?„ˆë¦?

a = {"name":"?™ê¸¸ë™","birth":"1128","age":"30"}
print(a)
a = dict()
a["name"]="python"
a[('a',)]="python"
# a[[1]] = 'python' # a[[1]] ?´ ë¶?ë¶„ì? ë¦¬ìŠ¤?Š¸?¸?° ?‚¤ ê°’ì? ë³?ê²½í•  ?ˆ˜ ?—†?Š” ê°’ì´ ?“¤?–´ê°??•¼ ?•˜ì§?ë§? ?—¬ê¸°ì— ?“¤?–´ê°??Š” ê°’ì? ë³?ê²½ì´ ê°??Š¥?•˜?‹¤.
a[250] = 'python'
print(a)

# B?— ?•´?‹¹?•˜?Š” ê°’ì„ ì¶”ì¶œ?•˜ê³? ?‚­? œ
a = {'A':90, 'B':80, 'C':70}
print(a.get("B")) # B?˜ ê°?
a.pop("B")
print(a)

# C?¼?Š” ?‚¤ ê°’ì´ ?—†?„ ?•Œ ?˜¤ë¥? ???‹  70?´?¼?Š” ê°’ì„ ?–»?„ë¡? ?ˆ˜? •
a = {'A':90, 'B':80}
print(a.get("C", 70))

# ?•´?‹¹ ?”•?…”?„ˆë¦¬ì—?„œ ìµœì†Œê°? ì¶”ì¶œ
a = {'A':90, 'B':80, 'C':70}
print(min(a.values()))

# a ë¦¬ìŠ¤?Š¸ë¥? [('A', 90), ('B', 80), ('C', 70)] ?´?Ÿ¬?•œ ?˜•?ƒœë¡? ???¥
a = {'A':90, 'B':80, 'C':70}
b = list(a.items())
print(b)