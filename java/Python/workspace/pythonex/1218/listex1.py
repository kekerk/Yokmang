'''
Created on 2018. 12. 18.

@author: gdj-4
listex1.py : 리스트예제
'''
myList = [30,10,20] 
print("현재 리스트 : %s" % myList)

myList.append(40)
print("append(40) 후의 리스트 : %s" % myList)

print("pop()으로 추출한 값 : %s" % myList.pop()) #스택처럼 사용
print("pop() 후의 리스트 : %s" % myList)

myList.sort()
print("sort() 후의 리스트 : %s" % myList)

myList.reverse()
print("reverse() 후의 리스트 : %s" % myList)

print("20 값의 위치 : %d" % myList.index(20)) #20이라는 값의 위치 리턴

myList.insert(2, 222)
print("insert(2,222) 후의 리스트 : %s" % myList)

myList.remove(222)
print("remove(222) 후의 리스트 : %s" % myList)

myList.extend([77,88,77]) #list 늘리기
print("extend([77,88,77]) 후의 리스트 : %s" % myList)

print("77 값의 갯수 : %d" % myList.count(77)) #77값의 갯수