'''
Created on 2018. 12. 19.

@author: gdj4
'''
foods = ["?��볶이","짜장�?","?���?"]
sides = ["?��?��","?��무�?","�?�?"]
for food,side in zip(foods,sides) :
    print(food,'=>',side)
    
# ?�� 개의 리스?���? ?��?��?�� 리스?�� 객체�? ?��?��
tupList = list(zip(foods,sides))
print(tupList)

dic = dict(zip(foods,sides))
print(dic)
