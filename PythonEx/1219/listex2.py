'''
Created on 2018. 12. 19.

@author: gdj4
listex2.py : μ»΄νλ¦¬ν¨?
'''

# 1λΆ??° 5κΉμ? κ°μ ???₯
mylist = []
for i in range(1,6) :
    mylist.append(i)
print(mylist)

# μ»΄νλ¦¬ν¨? ??λ‘? κ΅¬ν?κΈ?
mylist = [num for num in range(1,6)]
print(mylist)

# 1λΆ??° 100κΉμ? ?«? μ€? 3? λ°°μλ§? ???₯?? λ¦¬μ€?Έ ??±

mylist = []
for i in range(1,101) :
    if i % 3 == 0 :
        mylist.append(i)
print(mylist)

# μ»΄νλ¦¬ν¨? ??λ‘? κ΅¬ν?κΈ?
mylist = [num for num in range(1,101)\
          if num % 3 == 0]
print(mylist)