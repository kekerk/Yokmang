'''
test2.py : ?λ£ν
λ³?? ? ?Έ?΄ κ°??₯?μ§?λ§? ?? ??€. ?μ§?λ§? λ³??λ₯? λ―Έλ¦¬ ? ?Έ?? κ²μ΄ ? ?¨?¨? .


@author: gdj-4
'''
from ctypes.wintypes import DOUBLE


a=100
b=50
#a,b = 100,50 (?΄?? κ°μ? ??λ‘? λ³?? ? ?Έ κ°??₯)
print("""a+b=""",a+b)
print(type(a))

#μ½μ?? ?? ₯λ°μ a λ³??? ???₯?κΈ?
a = int(input("μ²«λ²μ§Έμ«?"))
b = int(input("?λ²μ§Έ?«?"))
result = a+b
print(a,"+",b,"=",result)
result = a-b
print(a,"-",b,"=",result)
result = a*b
print(a,"*",b,"=",result)
result = a/b
print(a,"/",b,"=",result)
result = a%b
print(a,"%",b,"=",result)

# ** : ? κ³?
# // : λͺ?(??κΈ? ?΄?? ???  ? κ±?)

print("9**2",a//b)
print("9? ? κ³?",9**2,", ??κΈ? ? ?κ°?:",a//b)
print("a"+"b"+"c")
print("abc"*3)