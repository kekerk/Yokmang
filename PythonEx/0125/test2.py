'''
    Created on 2019. 1. 25.
    
    @author: gdj4
    
    화면에서 문자를 여러개 입력받아 각각의 숫자의 2배만큼 * 출력하기

1234

**
****
******
********    
'''
t = input("여러 문자열 입력 : ")

for i in range(0,len(t)) :
    num = int(t[i])
    for j in range(0,num*2) :
        print("*",end="")
    print()