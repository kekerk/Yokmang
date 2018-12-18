'''
배열 예제 : list라고 함
@author: gdj-4
'''
aa = [0,0,0,0]
hap = 0

for i in range(0,4) :
    aa[i] = int(input(str(i+1)+"번째 숫자 : "))
    hap += aa[i]
print("합계:",hap)