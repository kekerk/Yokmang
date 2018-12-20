'''
Created on 2018. 12. 20.

@author: gdj4
'''
ss = "파이썬은완전재미있어요"
sslen = len(ss)
for i in range(0,sslen) :
    if i % 2 == 0 :
        print(ss[i],end='')
    else :
        print('#',end='')


print()
# 모든 공백을 제거하기
ss = "  파   이   썬   "
print(ss.replace(" ","",))

# 특정 문자 제거하기
print("\n 특정 문자 제거하기")
ss1 = "------파-------이--------썬----------"
ss2 = "<<<<<<< 파<<이>>썬 >>>>>>>>>>"
print(ss1.strip("-"))
print(ss2.strip("<>")) # 문자 하나하나를 인식해서 지워지도록 함

