'''
Created on 2018. 12. 19.

@author: gdj4
'''
# ?™ê¸¸ë™ ì£¼ë?¼ë²ˆ?˜¸ ?ƒ?…„?›”?¼ê³? ?’·?ë¦¬ë¡œ ?‚˜?ˆ„ê¸?
num = "891120-1068234"
print(num[0:6])
print(num[7:])

print()
# ì£¼ë?¼ë²ˆ?˜¸ ?„±ë³?
print(num[7:8])

print()

# ë¦¬ìŠ¤?Š¸ë¥? ? •? ¬?•˜ê³? ?—­?ˆœ?œ¼ë¡? ì¶œë ¥
lists = [1,3,5,4,2]
lists.sort()
lists.reverse()
print("List = : %s"%lists)

print()

# Life is too shortë¡? ?•©ì³ì„œ ì¶œë ¥
life = ['Life','is','short']
life.insert(2,'too')
result = ' '.join(life)
print("%s" % result)

print()

# ?•´?‹¹ ?”•?…”?„ˆë¦¬ì—?„œ Bê°’ì„ ì¶”ì¶œ?•˜ê³? ?‚­? œ?•˜ê¸?
d = {"A":90, "B":80, "C":70}
s = d.pop("B",1)
print("B?˜ ê°? : %s" % s)
del s
print("%s" % d)

print()

# ë¦¬ìŠ¤?Š¸?—?„œ ì¤‘ë³µ?œ ?ˆ«? ? œê±?
e = [1,1,1,2,2,3,3,3,4,4,5]
sets = set(e)
chlist = list(sets)
print(chlist)


# ?ŒŒ?´?¬?—?„œ ?˜ˆ?•½?–´ë¡? ?‚¬?š©?˜?Š” ë©”ì„œ?“œ?“¤?? ë³??ˆ˜ëª…ìœ¼ë¡? ?‚¬?š©?•˜?Š” ê²ƒì„ ì§??–‘?•œ?‹¤