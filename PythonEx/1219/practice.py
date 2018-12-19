'''
Created on 2018. 12. 19.

@author: gdj4
'''
#리스트

# a 리스트에서 you too 출력하기
a = ['Life', 'is', 'too', 'short', 'you', 'need', 'python']
b = a[4],a[2]
c = ' '.join(b)
print("%s" % c)

# a 리스트의 사이즈 구하기
a = [1,2,3]
print(len(a))
a.append([4,5]) # append는 list 자체가 추가
print(a)
a = [1,2,3]
a.extend([4,5]) # extend 는 기존에 있던 함수에 list를 더하는 결과
print(a)

# 1,3,5로 출력하기
mlist = [1,2,3,4,5]
mlist.remove(2)
mlist.remove(4)
print(mlist)

# 튜플
foods = ["떡볶이","짜장면","라면"]
sides = ["오뎅","단무지","김치"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)

# 3만을 요소로 가지는 튜플 생성

a = (3)

# 튜플은 처음 생성한 값에서 수정 삭제가 불가능하다. 이를 수정하거나 삭제하려면 리스트로 바꿔준 뒤 다시 튜플로 만들어주어야 함

myTuple = (10,20,30)
print(myTuple)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)

# 딕셔너리

a = {"name":"홍길동","birth":"1128","age":"30"}
print(a)
a = dict()
a["name"]="python"
a[('a',)]="python"
# a[[1]] = 'python' # a[[1]] 이 부분은 리스트인데 키 값은 변경할 수 없는 값이 들어가야 하지만 여기에 들어가는 값은 변경이 가능하다.
a[250] = 'python'
print(a)

# B에 해당하는 값을 추출하고 삭제
a = {'A':90, 'B':80, 'C':70}
print(a.get("B")) # B의 값
a.pop("B")
print(a)

# C라는 키 값이 없을 때 오류 대신 70이라는 값을 얻도록 수정
a = {'A':90, 'B':80}
print(a.get("C", 70))

# 해당 딕셔너리에서 최소값 추출
a = {'A':90, 'B':80, 'C':70}
print(min(a.values()))

# a 리스트를 [('A', 90), ('B', 80), ('C', 70)] 이러한 형태로 저장
a = {'A':90, 'B':80, 'C':70}
b = list(a.items())
print(b)