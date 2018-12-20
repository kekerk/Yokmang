'''
Created on 2018. 12. 20.

@author: gdj4
'''

ss = input("문자열 입력 : ")

if ss.isalpha() :
    print("글자입니다.")
elif ss.isdigit() :
    print("숫자입니다")
elif ss.isalnum() :
    print("글자+숫자입니다.")
else :
    print("모르겠습니다.")

if ss.islower() :
    print("소문자입니다.")
elif ss.isupper() :
    print("대문자입니다.")
elif ss.isspace() :
    print("공백입니다.")
else :
    print("구분 못 합니다.")