'''
Created on 2018. 12. 19.

@author: gdj4
'''
# ?κΈΈλ μ£Όλ?Όλ²?Έ ????Όκ³? ?·?λ¦¬λ‘ ??κΈ?
num = "891120-1068234"
print(num[0:6])
print(num[7:])

print()
# μ£Όλ?Όλ²?Έ ?±λ³?
print(num[7:8])

print()

# λ¦¬μ€?Έλ₯? ? ? ¬?κ³? ?­??Όλ‘? μΆλ ₯
lists = [1,3,5,4,2]
lists.sort()
lists.reverse()
print("List = : %s"%lists)

print()

# Life is too shortλ‘? ?©μ³μ μΆλ ₯
life = ['Life','is','short']
life.insert(2,'too')
result = ' '.join(life)
print("%s" % result)

print()

# ?΄?Ή ???λ¦¬μ? Bκ°μ μΆμΆ?κ³? ?­? ?κΈ?
d = {"A":90, "B":80, "C":70}
s = d.pop("B",1)
print("B? κ°? : %s" % s)
del s
print("%s" % d)

print()

# λ¦¬μ€?Έ?? μ€λ³΅? ?«? ? κ±?
e = [1,1,1,2,2,3,3,3,4,4,5]
sets = set(e)
chlist = list(sets)
print(chlist)


# ??΄?¬?? ??½?΄λ‘? ?¬?©?? λ©μ??€?? λ³??λͺμΌλ‘? ?¬?©?? κ²μ μ§????€