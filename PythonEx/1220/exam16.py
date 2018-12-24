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

var1 = int(input("ì²«ë²ˆì§? ?ˆ˜ ?…? ¥ : "))  
oper = input("ê³„ì‚°?‹ ?…? ¥ (+,-,*,/,**) : ")
var2 = int(input("?‘ë²ˆì§¸ ?ˆ˜ ?…? ¥ : "))

try :
    res = calc(var1,var2,oper)
    print("ê³„ì‚°ê¸? : %d %s %d = %d" %(var1,oper,var2,res))
except ZeroDivisionError :
    print("0?œ¼ë¡? ?‚˜?ˆŒ ?ˆ˜ ?—†?–´?š”")
