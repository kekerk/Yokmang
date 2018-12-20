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

var1 = int(input("첫번째 수 입력 : "))  
oper = input("계산식 입력 (+,-,*,/,**) : ")
var2 = int(input("두번째 수 입력 : "))

try :
    res = calc(var1,var2,oper)
    print("계산기 : %d %s %d = %d" %(var1,oper,var2,res))
except ZeroDivisionError :
    print("0으로 나눌 수 없어요")
