'''
Created on 2018. 12. 24.
mariadb?? ?��?��?���?
@author: gdj4
'''
import pymysql  # pip3 install mysqlclient ?��?�� ?��?��


conn = pymysql.connect(host="localhost",port=3306,user="scott",passwd="tiger",db="bigdb",charset="utf8")

try :
    cur = conn.cursor()
    cur.execute("select * from item")
    # while?��?�� for�? ?�� �? ?��무거?�� ?��?��?��?�� ?��?��.
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