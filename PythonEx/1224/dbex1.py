'''
Created on 2018. 12. 24.

dbex2.py : sqlite db ?¬?©?κΈ?
@author: gdj4
'''
import sqlite3


con,cur = None,None
data1,data2,data3,data4 = "","","",""
con = sqlite3.connect("iddb") # db?? ?°κ²? κ°μ²΄
cur = con.cursor()            # db? sqlκ΅¬λ¬Έ ?€? κ°μ²΄    
cur.executescript('''
    create table usertable (id char(4) primary key,
                            username char(15), email char(15), birthyear int)
''')

while True : 
    data1 = input("?¬?©?ID = > ")
    if data1 == "" :
        break
    data2 = input("?¬?©? ?΄λ¦? => ")
    data3 = input("?΄λ©μΌ => ")
    data4 = input("μΆμ?°? => ")
    sql = "insert into usertable values ('"+ data1 +"','"+data2+"','" +data3+"','" +data4+"')"
    cur.execute(sql)
    con.commit()
    con.close()


