'''
배열 ?��?�� : list?���? ?��
@author: gdj-4
'''
aa = [0,0,0,0]
hap = 0

for i in range(0,4) :
    aa[i] = int(input(str(i+1)+"번째 ?��?�� : "))
    hap += aa[i]
print("?���?:",hap)