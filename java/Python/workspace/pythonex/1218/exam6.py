'''
Created on 2018. 12. 18.
나라별 수도 정보를 dict 형태로 저장하고, 나라 이름을 받아 수도를 출력하기.
없는 나라인 경우 dict에 등록할지 여부 확인 후 등록
나라 이름에 "끝" 문자가 입력되면 현재 등록된 내용을 출력하고 종료하기
@author: gdj-4
'''
countrys = {"대한민국":"서울","일본":"도쿄","프랑스":"파리","네덜란드":"암스테르담"}
while(True) :
    select = input(str(list(countrys.keys()))+"중 나라를 선택하세요")
    if (select in countrys):
        print("<%s> 의 수도는 <%s> 입니다." % (select, countrys.get(select)))
    elif (select == "끝") :
        for i in countrys.keys() :
            print("%s : %s" %(i, countrys.get(i)))
        break
    else :
        print("등록되지 않은 나라입니다.")
        yn = input("나라를 등록하시겠습니까?(y/n):")
        if (yn == "y") :
            capital = input(select+"의 수도는 어디입니까?")
            countrys[select] = capital
            print("등록완료")
        else :
            break