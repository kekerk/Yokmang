'''
Created on 2018. 12. 19.

@author: gdj4
'''
#리스?��

# a 리스?��?��?�� you too 출력?���?
a = ['Life', 'is', 'too', 'short', 'you', 'need', 'python']
b = a[4],a[2]
c = ' '.join(b)
print("%s" % c)

# a 리스?��?�� ?��?���? 구하�?
a = [1,2,3]
print(len(a))
a.append([4,5]) # append?�� list ?��체�? 추�?
print(a)
a = [1,2,3]
a.extend([4,5]) # extend ?�� 기존?�� ?��?�� ?��?��?�� list�? ?��?��?�� 결과
print(a)

# 1,3,5�? 출력?���?
mlist = [1,2,3,4,5]
mlist.remove(2)
mlist.remove(4)
print(mlist)

# ?��?��
foods = ["?��볶이","짜장�?","?���?"]
sides = ["?��?��","?��무�?","�?�?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)

# 3만을 ?��?���? �?�??�� ?��?�� ?��?��

a = (3)

# ?��?��?? 처음 ?��?��?�� 값에?�� ?��?�� ?��?���? 불�??��?��?��. ?���? ?��?��?��거나 ?��?��?��?���? 리스?���? 바꿔�? ?�� ?��?�� ?��?���? 만들?��주어?�� ?��

myTuple = (10,20,30)
print(myTuple)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)

# ?��?��?���?

a = {"name":"?��길동","birth":"1128","age":"30"}
print(a)
a = dict()
a["name"]="python"
a[('a',)]="python"
# a[[1]] = 'python' # a[[1]] ?�� �?분�? 리스?��?��?�� ?�� 값�? �?경할 ?�� ?��?�� 값이 ?��?���??�� ?���?�? ?��기에 ?��?���??�� 값�? �?경이 �??��?��?��.
a[250] = 'python'
print(a)

# B?�� ?��?��?��?�� 값을 추출?���? ?��?��
a = {'A':90, 'B':80, 'C':70}
print(a.get("B")) # B?�� �?
a.pop("B")
print(a)

# C?��?�� ?�� 값이 ?��?�� ?�� ?���? ???�� 70?��?��?�� 값을 ?��?���? ?��?��
a = {'A':90, 'B':80}
print(a.get("C", 70))

# ?��?�� ?��?��?��리에?�� 최소�? 추출
a = {'A':90, 'B':80, 'C':70}
print(min(a.values()))

# a 리스?���? [('A', 90), ('B', 80), ('C', 70)] ?��?��?�� ?��?���? ???��
a = {'A':90, 'B':80, 'C':70}
b = list(a.items())
print(b)