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

var1 = int(input("첫번�? ?�� ?��?�� : "))  
oper = input("계산?�� ?��?�� (+,-,*,/,**) : ")
var2 = int(input("?��번째 ?�� ?��?�� : "))

try :
    res = calc(var1,var2,oper)
    print("계산�? : %d %s %d = %d" %(var1,oper,var2,res))
except ZeroDivisionError :
    print("0?���? ?��?�� ?�� ?��?��?��")
