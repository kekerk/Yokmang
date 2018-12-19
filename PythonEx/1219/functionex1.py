'''
Created on 2018. 12. 19.

@author: gdj4
'''

def myFunc() :
    print("myFunc() 함수 호출함")

# 전역변수
gvar = 100

if __name__ =='__main__' : # 프로그램의 시작점
    print("메인 함수 부분입니다. 여기서부터 실행 됩니다")
    myFunc()
    print("전역변수 gvar 값",gvar)