'''
Created on 2018. 12. 20.

@author: gdj4
'''

def para_func(* para): # 0�? ?��?�� 매개�??�� �??��
    # para �??��?�� ?��료형?? Tuple?��
    result = 0
    for num in para : 
        result = result + num
    return result

hap = 0
hap = para_func(10,20)
print("para_func(10,20) = %d" % hap)
hap = para_func(10,20,30)
print("para_func(10,20,30) = %d" % hap)
hap = para_func(10,20,30,40,50,60,70,80,90)
print("para_func(10,20,30,40,50,60,70,80,90) = %d" % hap)