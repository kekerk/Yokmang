'''
Created on 2018. 12. 21.

@author: gdj4
dbex1.py : sqlite3 db?? ?°κ²°νκΈ?
'''
import sqlite3


dbpath = "test.sqlite" # db ???₯??Ό ?΄λ¦?
conn = sqlite3.connect(dbpath)
cur = conn.cursor() # λͺλ Ή ? ?¬ κ°μ²΄ ??±
# executescript : ?¬?¬κ°μ sql κ΅¬λ¬Έ? ?€?
cur.executescript('''
  drop table if exists items;
  create table items (item_id integer primary key,
      name text unique,
      price integer);
  insert into items (name, price) values ('Apple',800);
  insert into items (name, price) values ('Orange',500);
  insert into items (name, price) values ('Banana',300);
''')
# ?Έ?? ? μ’λ£. ?€? λ‘? insert κ΅¬λ¬Έ?΄ ?€?
conn.commit()
cur = conn.cursor()
cur.execute("select item_id, name,price from items")
# cur.fetchall() : cur? ???₯? db read ? λ³΄λ?? ? λΆ? μ‘°ν
item_list = cur.fetchall()
for it in item_list :
    print(it)
