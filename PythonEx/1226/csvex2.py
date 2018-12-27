'''
Created on 2018. 12. 26.

@author: gdj4
'''
import codecs # 문자형 대용량 데이터를 읽기 위한 모듈, 스트리밍을 위한 모듈

filename= "jeju1.csv"
# euc-kr 코드로 인식해서 read()
csv = codecs.open(filename,"r","euc-kr").read()
data=[]
rows = csv.split("\r\n")
for row in rows : 
    if row == "" : continue
    cells = row.split(",")
    data.append(cells)
    for c in data :
        print(c[0],c[1],c[2])