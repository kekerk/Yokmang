'''
λ°°μ΄ ??  : list?Όκ³? ?¨
@author: gdj-4
'''
aa = [0,0,0,0]
hap = 0

for i in range(0,4) :
    aa[i] = int(input(str(i+1)+"λ²μ§Έ ?«? : "))
    hap += aa[i]
print("?©κ³?:",hap)