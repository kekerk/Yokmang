'''
Created on 2018. 12. 20.

@author: gdj4
'''
# def selfCall():
#     print('?•˜',end='')
#     selfCall()
# selfCall()

def count(num):
    if num>=1:
        print(num,end=' ')
        count(num-1)
    else :
        return
count(10)
print()
count(20)