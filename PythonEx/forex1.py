'''
Created on 2018. 12. 17.

@author: gdj-4
'''
import keyword  # ?λ°μ package import?? κ²κ³Ό λΉμ·
import random  # ? ?Έλ¦¬ν°(κΈ°λ₯)λ₯? ?¬?©?κΈ? ?? κ°μ²΄λ₯? ?κ³? ?€κΈ?.


numbers = [] #λ°°μ΄ ? ?Έ, λ¦¬μ€?Έ ? ?Έ
for num in range(0,10,2) : #0?? 9κΉμ? 1?© μ¦κ??λ©΄μ λ°λ³΅?¨. numbers.length : 10
    numbers.append(random.randrange(0,10)) #0λΆ??° 9κΉμ? ??? κ°μ μ°Ύμ? numbers? μΆκ?
print("??±? λ¦¬μ€?Έ",numbers)

for num in range(0,10,2) :
    if(num not in numbers) : 
        print("?«? %d? λ¦¬μ€?Έ? ??΅??€." % num)

print(keyword.kwlist) #??΄?¬?? ?¬?©?? ??½?΄ λͺ©λ‘ μΆλ ₯?¨.