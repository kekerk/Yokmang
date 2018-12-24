'''
Created on 2018. 12. 24.
mariadb와 연동하기
@author: gdj4
'''
import pymysql # pip3 install mysqlclient 설정 필요

conn = pymysql.connect(host="localhost",port=3306,user="scott",passwd="tiger",db="bigdb",charset="utf8")

try :
    cur = conn.cursor()
    cur.execute("select * from item")
    # while이나 for문 둘 중 아무거나 사용해도 된다.
#     while True :
#         row = cur.fetchone()
#         if row == None :
#             break
#         print(row)
    for row in cur.fetchall() :
        print(row)
finally:
    cur.close()
    conn.close()