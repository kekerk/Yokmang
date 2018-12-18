'''
문제 : 컴퓨터가 1부터 100사이의 임의의 정수를 저장하고
새로운 수를 입력받아 저장된 수를 맞추기
저장된 수가 입력된 수보다 
                    작으면 작은 수 입니다.
                   크면 큰수입니다.
                   일치하면 정답입니다.
'''
import random

cnt,com,my = 0,0,0
com = random.randrange(1,101)
print("임의의 숫자 :",com)
while(True):
    print("수를 입력하세요")
    my = int(input())
    cnt = cnt +1
    if(my > com) :
        print("저장된 수보다 큽니다")
    elif(my < com) :
        print("저장된 수보다 작습니다")
    else :
        print("정답입니다.")
        break
print("도전횟수 : ",cnt)