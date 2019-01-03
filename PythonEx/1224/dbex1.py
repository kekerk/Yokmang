'''
Created on 2018. 12. 24.

dbex2.py : sqlite db ?‚¬?š©?•˜ê¸?
@author: gdj4
'''
import sqlite3


con,cur = None,None
data1,data2,data3,data4 = "","","",""
con = sqlite3.connect("iddb") # db?? ?—°ê²? ê°ì²´
cur = con.cursor()            # db?— sqlêµ¬ë¬¸ ?‹¤?–‰ ê°ì²´    
cur.executescript('''
    create table usertable (id char(4) primary key,
                            username char(15), email char(15), birthyear int)
''')

while True : 
    data1 = input("?‚¬?š©?žID = > ")
    if data1 == "" :
        break
    data2 = input("?‚¬?š©?ž ?´ë¦? => ")
    data3 = input("?´ë©”ì¼ => ")
    data4 = input("ì¶œìƒ?—°?„ => ")
    sql = "insert into usertable values ('"+ data1 +"','"+data2+"','" +data3+"','" +data4+"')"
    cur.execute(sql)
    con.commit()
    con.close()


