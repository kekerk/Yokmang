'''
Created on 2018. 12. 20.

@author: gdj4
yieldex1.py : ? ?? ?΄?°??, yield ??½?΄
        yield : ?¨?? μ’λ£ ??΄ κ°μ λ¦¬μ€?Έλ‘? λ°ν?¨
'''
def genFun(num):
    for i in range(10,num+10):
        yield i
        print(i, "κ°? λ°ν")
    
print(list(genFun(5)))

for data in genFun(5) :
    print("main?? μΆλ ₯ : " , data)