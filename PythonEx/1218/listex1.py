'''
Created on 2018. 12. 18.

@author: gdj-4
listex1.py : 리스?��?��?��
'''
myList = [30,10,20] 
print("?��?�� 리스?�� : %s" % myList)

myList.append(40)
print("append(40) ?��?�� 리스?�� : %s" % myList)

print("pop()?���? 추출?�� �? : %s" % myList.pop()) #?��?��처럼 ?��?��
print("pop() ?��?�� 리스?�� : %s" % myList)

myList.sort()
print("sort() ?��?�� 리스?�� : %s" % myList)

myList.reverse()
print("reverse() ?��?�� 리스?�� : %s" % myList)

print("20 값의 ?���? : %d" % myList.index(20)) #20?��?��?�� 값의 ?���? 리턴

myList.insert(2, 222)
print("insert(2,222) ?��?�� 리스?�� : %s" % myList)

myList.remove(222)
print("remove(222) ?��?�� 리스?�� : %s" % myList)

myList.extend([77,88,77]) #list ?��리기
print("extend([77,88,77]) ?��?�� 리스?�� : %s" % myList)

print("77 값의 �??�� : %d" % myList.count(77)) #77값의 �??��