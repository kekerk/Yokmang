'''
Created on 2018. 12. 26.

@author: gdj4
'''
import codecs  # 문자?�� ???��?�� ?��?��?���? ?���? ?��?�� 모듈, ?��?��리밍?�� ?��?�� 모듈


filename= "jeju1.csv"
# euc-kr 코드�? ?��?��?��?�� read()
csv = codecs.open(filename,"r","euc-kr").read()
data=[]
rows = csv.split("\r\n")
for row in rows : 
    if row == "" : continue
    cells = row.split(",")
    data.append(cells)
    for c in data :
        print(c[0],c[1],c[2])