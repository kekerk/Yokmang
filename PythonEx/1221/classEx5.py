'''
Created on 2018. 12. 21.

@author: gdj4
classEx5.py : ?΄??€?? ?¬?©?? μ§?? ? ?Ήλ³ν λ©μ?
'''
class Line :
    length = 0
    def __init__(self,length): # ??±? κ°μ²΄ ??± ? ?ΈμΆλ? λ©μ?
        self.length = length
        print(self.length,"κΈΈμ΄? ? ?΄ ??±???΅??€.")
    def __del__(self): # ?λ©Έμ : κ°μ²΄ ? κ±°μ ?ΈμΆλ? λ©μ?
        print(self.length,"κΈΈμ΄? ? ?΄ ? κ±? ???΅??€.")
    def __repr__(self): # ?λ°μ toStringκ°μ? κΈ°λ₯? κ°?μ§?. κ°μ²΄? μΆλ ₯ ?΄?Ή?? λ©μ?
        return "? ? κΈΈμ΄ : "+str(self.length)
    def __add__(self,other): # ??κΈ? ?°?°? ?¬?©? ?ΈμΆλ? λ©μ?
        return self.length + other.length
    def __lt__(self,other):
        return self.length < other.length
    def __eq__(self,other):
        return self.length == other.length
    
myLine1 = Line(100) # κ°μ²΄?, ??±? ?ΈμΆ?
myLine2 = Line(200)
print(myLine1)
print(myLine2)

print("? ? ? κΈΈμ΄? ?© : ",myLine1 + myLine2)
## ?λ‘κ·Έ?¨ μ’λ£ : ??±? κ°μ²΄κ°? ???Όλ‘? ?λ©Έλ¨. ?λ©Έμκ°? ?ΈμΆ?

if myLine1 < myLine2 :
    print("myLine2κ°? ? κΉλ?€.")
elif myLine1 == myLine2 :
    print("? ? ? κΈΈμ΄κ°? κ°μ΅??€.")
else :
    print("myLine1?΄ ? κΉλ?€.")