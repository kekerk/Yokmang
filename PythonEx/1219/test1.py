'''
Created on 2018. 12. 19.

@author: gdj4
'''
# ?��길동 주�?�번?�� ?��?��?��?���? ?��?��리로 ?��?���?
num = "891120-1068234"
print(num[0:6])
print(num[7:])

print()
# 주�?�번?�� ?���?
print(num[7:8])

print()

# 리스?���? ?��?��?���? ?��?��?���? 출력
lists = [1,3,5,4,2]
lists.sort()
lists.reverse()
print("List = : %s"%lists)

print()

# Life is too short�? ?��쳐서 출력
life = ['Life','is','short']
life.insert(2,'too')
result = ' '.join(life)
print("%s" % result)

print()

# ?��?�� ?��?��?��리에?�� B값을 추출?���? ?��?��?���?
d = {"A":90, "B":80, "C":70}
s = d.pop("B",1)
print("B?�� �? : %s" % s)
del s
print("%s" % d)

print()

# 리스?��?��?�� 중복?�� ?��?�� ?���?
e = [1,1,1,2,2,3,3,3,4,4,5]
sets = set(e)
chlist = list(sets)
print(chlist)


# ?��?��?��?��?�� ?��?��?���? ?��?��?��?�� 메서?��?��?? �??��명으�? ?��?��?��?�� 것을 �??��?��?��