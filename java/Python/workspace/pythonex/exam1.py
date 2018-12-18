'''
Created on 2018. 12. 17.

@author: gdj-4
'''
#문제 1 : 금액을 화면에서 입력받아필요한 동전의 갯수를 출력하기
print("금액을 입력하세요")
money = int(input())
print("500원 :", money//500,"개")
chg = money%500 
print("100원 :", chg//100,"개")
chg = ((money%500)%100)
print("50원 :", chg//50,"개")
chg = (((money%500)%100)%50)
print("10원 :", chg//10,"개")
chg = (((money%500)%100)%50)%10
print("1원 :", chg,"개")
