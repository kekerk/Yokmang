'''
Created on 2018. 12. 20.

@author: gdj4
'''
def calc(v1,v2,op):
    result = 0
    if op == '+' :
        result = v1 + v2
    elif op == '-' :
        result = v1 - v2
    elif op == '*' :
        result = v1 * v2
    elif op == '/' :
        result = v1 / v2
    elif op == "**":
        result = v1 ** v2
        
    return result

res = 0
var1, var2, oper = 0,0,""

var1 = int(input("μ²«λ²μ§? ? ?? ₯ : "))  
oper = input("κ³μ°? ?? ₯ (+,-,*,/,**) : ")
var2 = int(input("?λ²μ§Έ ? ?? ₯ : "))

try :
    res = calc(var1,var2,oper)
    print("κ³μ°κΈ? : %d %s %d = %d" %(var1,oper,var2,res))
except ZeroDivisionError :
    print("0?Όλ‘? ?? ? ??΄?")
