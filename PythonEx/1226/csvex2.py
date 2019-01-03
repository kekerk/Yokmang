'''
Created on 2018. 12. 26.

@author: gdj4
'''
import codecs  # ë¬¸ì?˜• ???š©?Ÿ‰ ?°?´?„°ë¥? ?½ê¸? ?œ„?•œ ëª¨ë“ˆ, ?Š¤?Š¸ë¦¬ë°?„ ?œ„?•œ ëª¨ë“ˆ


filename= "jeju1.csv"
# euc-kr ì½”ë“œë¡? ?¸?‹?•´?„œ read()
csv = codecs.open(filename,"r","euc-kr").read()
data=[]
rows = csv.split("\r\n")
for row in rows : 
    if row == "" : continue
    cells = row.split(",")
    data.append(cells)
    for c in data :
        print(c[0],c[1],c[2])