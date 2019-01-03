'''
Created on 2018. 12. 24.
mariadb?? ?ó∞?èô?ïòÍ∏?
@author: gdj4
'''
import pymysql  # pip3 install mysqlclient ?Ñ§?†ï ?ïÑ?öî


conn = pymysql.connect(host="localhost",port=3306,user="scott",passwd="tiger",db="bigdb",charset="utf8")

try :
    cur = conn.cursor()
    cur.execute("select * from item")
    # while?ù¥?Çò forÎ¨? ?ëò Ï§? ?ïÑÎ¨¥Í±∞?Çò ?Ç¨?ö©?ï¥?èÑ ?êú?ã§.
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