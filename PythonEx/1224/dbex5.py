'''
Created on 2018. 12. 24.

mariadb와 연동하기
@author: gdj4
'''
import pymysql

conn = pymysql.connect(host="localhost",port=3306,user="scott",passwd="tiger",db="bigdb",charset="utf8")

cur = conn.cursor()
#cur.execute("drop table items")
cur.execute(''' create table items (
         item_id integer primary key auto_increment,
         name varchar(300),
         price integer) ''')

data = [("바나나",3000),("망고",30000),("키위",100000)]
for i in data :
    cur.execute("insert into items (name,price) values (%s,%s)",i)
conn.commit()
cur.execute("select * from items")
for row in cur.fetchall() :
    #print(row)
    print(row[0],row[1])