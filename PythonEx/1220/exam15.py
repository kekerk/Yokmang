'''
Created on 2018. 12. 20.

@author: gdj4
'''

ss = input("문자?�� ?��?�� : ")

if ss.isalpha() :
    print("�??��?��?��?��.")
elif ss.isdigit() :
    print("?��?��?��?��?��")
elif ss.isalnum() :
    print("�??��+?��?��?��?��?��.")
else :
    print("모르겠습?��?��.")

if ss.islower() :
    print("?��문자?��?��?��.")
elif ss.isupper() :
    print("??문자?��?��?��.")
elif ss.isspace() :
    print("공백?��?��?��.")
else :
    print("구분 �? ?��?��?��.")