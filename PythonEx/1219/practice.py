'''
Created on 2018. 12. 19.

@author: gdj4
'''
#λ¦¬μ€?Έ

# a λ¦¬μ€?Έ?? you too μΆλ ₯?κΈ?
a = ['Life', 'is', 'too', 'short', 'you', 'need', 'python']
b = a[4],a[2]
c = ' '.join(b)
print("%s" % c)

# a λ¦¬μ€?Έ? ?¬?΄μ¦? κ΅¬νκΈ?
a = [1,2,3]
print(len(a))
a.append([4,5]) # append? list ?μ²΄κ? μΆκ?
print(a)
a = [1,2,3]
a.extend([4,5]) # extend ? κΈ°μ‘΄? ?? ?¨?? listλ₯? ??? κ²°κ³Ό
print(a)

# 1,3,5λ‘? μΆλ ₯?κΈ?
mlist = [1,2,3,4,5]
mlist.remove(2)
mlist.remove(4)
print(mlist)

# ??
foods = ["?‘λ³Άμ΄","μ§μ₯λ©?","?Όλ©?"]
sides = ["?€?","?¨λ¬΄μ?","κΉ?μΉ?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)

# 3λ§μ ??λ‘? κ°?μ§?? ?? ??±

a = (3)

# ???? μ²μ ??±? κ°μ? ??  ?­? κ°? λΆκ??₯??€. ?΄λ₯? ?? ?κ±°λ ?­? ?? €λ©? λ¦¬μ€?Έλ‘? λ°κΏμ€? ?€ ?€? ??λ‘? λ§λ€?΄μ£Όμ΄?Ό ?¨

myTuple = (10,20,30)
print(myTuple)
myList = list(myTuple)
print(myList)
myList.append(40)
print(myList)
myTuple = tuple(myList)
print(myTuple)

# ???λ¦?

a = {"name":"?κΈΈλ","birth":"1128","age":"30"}
print(a)
a = dict()
a["name"]="python"
a[('a',)]="python"
# a[[1]] = 'python' # a[[1]] ?΄ λΆ?λΆμ? λ¦¬μ€?Έ?Έ?° ?€ κ°μ? λ³?κ²½ν  ? ?? κ°μ΄ ?€?΄κ°??Ό ?μ§?λ§? ?¬κΈ°μ ?€?΄κ°?? κ°μ? λ³?κ²½μ΄ κ°??₯??€.
a[250] = 'python'
print(a)

# B? ?΄?Ή?? κ°μ μΆμΆ?κ³? ?­? 
a = {'A':90, 'B':80, 'C':70}
print(a.get("B")) # B? κ°?
a.pop("B")
print(a)

# C?Ό? ?€ κ°μ΄ ?? ? ?€λ₯? ???  70?΄?Ό? κ°μ ?»?λ‘? ?? 
a = {'A':90, 'B':80}
print(a.get("C", 70))

# ?΄?Ή ???λ¦¬μ? μ΅μκ°? μΆμΆ
a = {'A':90, 'B':80, 'C':70}
print(min(a.values()))

# a λ¦¬μ€?Έλ₯? [('A', 90), ('B', 80), ('C', 70)] ?΄?¬? ??λ‘? ???₯
a = {'A':90, 'B':80, 'C':70}
b = list(a.items())
print(b)