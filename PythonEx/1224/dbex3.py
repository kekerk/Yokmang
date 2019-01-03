'''
Created on 2018. 12. 24.

GUI ?��경으�? 만들�?
@author: gdj4
'''
import sqlite3
from tkinter import *
from tkinter import messagebox


def insertData():
    con,cur = None,None
    data1,data2,data3,data4 = "","","",""
    sql = ""
     
    con = sqlite3.connect("iddb")
    cur = con.cursor()
     
    data1 = edit1.get() # ?��?��?�� 값을 리턴
    data2 = edit2.get()
    data3 = edit3.get()
    data4 = edit4.get()
    try :
        sql = "insert into usertable values ('"+ data1 +"','"+data2+"','" +data3+"','" +data4+"')"
        cur.execute(sql) # DB ?�� ?���?
    except :
        messagebox.showerror("?���?", "?��?��?�� ?��?��?�� ?���? 발생")
    else : # ?��?�� ?���?
        messagebox.showinfo("?���?", "?��?��?�� ?��?�� ?���?")
    finally :
        con.commit()
        con.close()
    
def selectData():
    strData1,strData2,strData3,strData4 = [],[],[],[]
    con = sqlite3.connect("iddb")
    cur = con.cursor()
    cur.execute("select * from usertable")
    strData1.append("?��?��?��ID")
    strData2.append("?��?��?�� ?���?")
    strData3.append("?��메일")
    strData4.append("출생?��?��")
    strData1.append("---------------");
    strData2.append("---------------");
    strData3.append("---------------");
    strData4.append("---------------");
    
    while True :
        row = cur.fetchone()
        if row == None :
            break;
        strData1.append(row[0]);
        strData2.append(row[1]);
        strData3.append(row[2]);
        strData4.append(row[3]);
        
    listData1.delete(0,listData1.size() -1)
    listData2.delete(0,listData2.size() -1)
    listData3.delete(0,listData3.size() -1)
    listData4.delete(0,listData4.size() -1)
# zip(strData1,strData2,strData3,strData4)
# => ?��?��?�� ?��기의 리스?���? ?��결하�?
# (strData1[0],strData2[0],strData3[0],strData4[0])
# (strData1[1],strData2[1],strData3[1],strData4[1] )
    for item1,item2,item3,item4 in zip(strData1,strData2,strData3,strData4) :
        listData1.insert(END,item1)
        listData2.insert(END,item2)
        listData3.insert(END,item3)
        listData4.insert(END,item4)
    con.close()
    
window = Tk() # GUI ?��경설?��
window.geometry("600x300")
window.title("GUI ?��?��?�� ?��?��")

editFrame = Frame(window)
editFrame.pack()
listFrame = Frame(window)
listFrame.pack(side=BOTTOM,fill=BOTH,expand=1)

edit1 = Entry(editFrame,width=10) #edit 박스
edit1.pack(side=LEFT,padx=10,pady=10)
edit2 = Entry(editFrame,width=10)
edit2.pack(side=LEFT,padx=10,pady=10)
edit3 = Entry(editFrame,width=10)
edit3.pack(side=LEFT,padx=10,pady=10)
edit4 = Entry(editFrame,width=10)
edit4.pack(side=LEFT,padx=10,pady=10)

# command=insertData : ?���??�� 경우 insertData ?��?�� ?���?, ?��?��?�� ?��?��.
btnInsert = Button(editFrame,text="?��?��",command=insertData)
btnInsert.pack(side=LEFT,padx=10,pady=10)
btnSelect = Button(editFrame,text="조회",command=selectData)
btnSelect.pack(side=LEFT,padx=10,pady=10)

listData1 = Listbox(listFrame,bg="yellow")
listData1.pack(side=LEFT,fill=BOTH,expand=1)
listData2 = Listbox(listFrame,bg="yellow")
listData2.pack(side=LEFT,fill=BOTH,expand=1)
listData3 = Listbox(listFrame,bg="yellow")
listData3.pack(side=LEFT,fill=BOTH,expand=1)
listData4 = Listbox(listFrame,bg="yellow")
listData4.pack(side=LEFT,fill=BOTH,expand=1)
window.mainloop() # GUI ?���? 출력