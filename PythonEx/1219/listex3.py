'''
Created on 2018. 12. 19.

@author: gdj4
'''
foods = ["?‘λ³Άμ΄","μ§μ₯λ©?","?Όλ©?"]
sides = ["?€?","?¨λ¬΄μ?","κΉ?μΉ?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
# ? κ°μ λ¦¬μ€?Έλ₯? ??? λ¦¬μ€?Έ κ°μ²΄λ‘? ??±
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)
