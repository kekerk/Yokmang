'''
Created on 2018. 12. 24.

dbex2.py : sqlite db ?��?��?���?
@author: gdj4
'''
import sqlite3


con,cur = None,None
data1,data2,data3,data4 = "","","",""
con = sqlite3.connect("iddb") # db?? ?���? 객체
cur = con.cursor()            # db?�� sql구문 ?��?�� 객체    
cur.executescript('''
    create table usertable (id char(4) primary key,
                            username char(15), email char(15), birthyear int)
''')

while True : 
    data1 = input("?��?��?��ID = > ")
    if data1 == "" :
        break
    data2 = input("?��?��?�� ?���? => ")
    data3 = input("?��메일 => ")
    data4 = input("출생?��?�� => ")
    sql = "insert into usertable values ('"+ data1 +"','"+data2+"','" +data3+"','" +data4+"')"
    cur.execute(sql)
    con.commit()
    con.close()


