'''
Created on 2018. 12. 26.

@author: gdj4
'''
import codecs  # λ¬Έμ? ???©? ?°?΄?°λ₯? ?½κΈ? ?? λͺ¨λ, ?€?Έλ¦¬λ°? ?? λͺ¨λ


filename= "jeju1.csv"
# euc-kr μ½λλ‘? ?Έ??΄? read()
csv = codecs.open(filename,"r","euc-kr").read()
data=[]
rows = csv.split("\r\n")
for row in rows : 
    if row == "" : continue
    cells = row.split(",")
    data.append(cells)
    for c in data :
        print(c[0],c[1],c[2])