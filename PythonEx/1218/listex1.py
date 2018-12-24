'''
Created on 2018. 12. 18.

@author: gdj-4
listex1.py : ë¦¬ìŠ¤?Š¸?˜ˆ? œ
'''
myList = [30,10,20] 
print("?˜„?¬ ë¦¬ìŠ¤?Š¸ : %s" % myList)

myList.append(40)
print("append(40) ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

print("pop()?œ¼ë¡? ì¶”ì¶œ?•œ ê°? : %s" % myList.pop()) #?Š¤?ƒì²˜ëŸ¼ ?‚¬?š©
print("pop() ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

myList.sort()
print("sort() ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

myList.reverse()
print("reverse() ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

print("20 ê°’ì˜ ?œ„ì¹? : %d" % myList.index(20)) #20?´?¼?Š” ê°’ì˜ ?œ„ì¹? ë¦¬í„´

myList.insert(2, 222)
print("insert(2,222) ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

myList.remove(222)
print("remove(222) ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

myList.extend([77,88,77]) #list ?Š˜ë¦¬ê¸°
print("extend([77,88,77]) ?›„?˜ ë¦¬ìŠ¤?Š¸ : %s" % myList)

print("77 ê°’ì˜ ê°??ˆ˜ : %d" % myList.count(77)) #77ê°’ì˜ ê°??ˆ˜