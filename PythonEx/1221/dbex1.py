'''
Created on 2018. 12. 21.

@author: gdj4
dbex1.py : sqlite3 db?? ?—°ê²°í•˜ê¸?
'''
import sqlite3


dbpath = "test.sqlite" # db ???¥?ŒŒ?¼ ?´ë¦?
conn = sqlite3.connect(dbpath)
cur = conn.cursor() # ëª…ë ¹ ? „?‹¬ ê°ì²´ ?ƒ?„±
# executescript : ?—¬?Ÿ¬ê°œì˜ sql êµ¬ë¬¸?„ ?‹¤?–‰
cur.executescript('''
  drop table if exists items;
  create table items (item_id integer primary key,
      name text unique,
      price integer);
  insert into items (name, price) values ('Apple',800);
  insert into items (name, price) values ('Orange',500);
  insert into items (name, price) values ('Banana',300);
''')
# ?Š¸?œ? ?…˜ ì¢…ë£Œ. ?‹¤? œë¡? insert êµ¬ë¬¸?´ ?‹¤?–‰
conn.commit()
cur = conn.cursor()
cur.execute("select item_id, name,price from items")
# cur.fetchall() : cur?— ???¥?œ db read ? •ë³´ë?? ? „ë¶? ì¡°íšŒ
item_list = cur.fetchall()
for it in item_list :
    print(it)
