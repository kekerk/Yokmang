'''
Created on 2018. 12. 21.

@author: gdj4
dbex1.py : sqlite3 db?? ?��결하�?
'''
import sqlite3


dbpath = "test.sqlite" # db ???��?��?�� ?���?
conn = sqlite3.connect(dbpath)
cur = conn.cursor() # 명령 ?��?�� 객체 ?��?��
# executescript : ?��?��개의 sql 구문?�� ?��?��
cur.executescript('''
  drop table if exists items;
  create table items (item_id integer primary key,
      name text unique,
      price integer);
  insert into items (name, price) values ('Apple',800);
  insert into items (name, price) values ('Orange',500);
  insert into items (name, price) values ('Banana',300);
''')
# ?��?��?��?�� 종료. ?��?���? insert 구문?�� ?��?��
conn.commit()
cur = conn.cursor()
cur.execute("select item_id, name,price from items")
# cur.fetchall() : cur?�� ???��?�� db read ?��보�?? ?���? 조회
item_list = cur.fetchall()
for it in item_list :
    print(it)
