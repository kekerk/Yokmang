'''
Created on 2018. 12. 18.

@author: gdj-4
listex1.py : λ¦¬μ€?Έ?? 
'''
myList = [30,10,20] 
print("??¬ λ¦¬μ€?Έ : %s" % myList)

myList.append(40)
print("append(40) ?? λ¦¬μ€?Έ : %s" % myList)

print("pop()?Όλ‘? μΆμΆ? κ°? : %s" % myList.pop()) #?€?μ²λΌ ?¬?©
print("pop() ?? λ¦¬μ€?Έ : %s" % myList)

myList.sort()
print("sort() ?? λ¦¬μ€?Έ : %s" % myList)

myList.reverse()
print("reverse() ?? λ¦¬μ€?Έ : %s" % myList)

print("20 κ°μ ?μΉ? : %d" % myList.index(20)) #20?΄?Ό? κ°μ ?μΉ? λ¦¬ν΄

myList.insert(2, 222)
print("insert(2,222) ?? λ¦¬μ€?Έ : %s" % myList)

myList.remove(222)
print("remove(222) ?? λ¦¬μ€?Έ : %s" % myList)

myList.extend([77,88,77]) #list ?λ¦¬κΈ°
print("extend([77,88,77]) ?? λ¦¬μ€?Έ : %s" % myList)

print("77 κ°μ κ°?? : %d" % myList.count(77)) #77κ°μ κ°??