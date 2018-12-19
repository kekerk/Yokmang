'''
Created on 2018. 12. 19.

@author: gdj4
'''
# 홍길동 주민번호 생년월일과 뒷자리로 나누기
num = "891120-1068234"
print(num[0:6])
print(num[7:])

print()
# 주민번호 성별
print(num[7:8])

print()

# 리스트를 정렬하고 역순으로 출력
lists = [1,3,5,4,2]
lists.sort()
lists.reverse()
print("List = : %s"%lists)

print()

# Life is too short로 합쳐서 출력
life = ['Life','is','short']
life.insert(2,'too')
result = ' '.join(life)
print("%s" % result)

print()

# 해당 딕셔너리에서 B값을 추출하고 삭제하기
d = {"A":90, "B":80, "C":70}
s = d.pop("B",1)
print("B의 값 : %s" % s)
del s
print("%s" % d)

print()

# 리스트에서 중복된 숫자 제거
e = [1,1,1,2,2,3,3,3,4,4,5]
sets = set(e)
chlist = list(sets)
print(chlist)


# 파이썬에서 예약어로 사용되는 메서드들은 변수명으로 사용하는 것을 지양한다