'''
Created on 2018. 12. 24.

GUI ?™˜ê²½ìœ¼ë¡? ë§Œë“¤ê¸?
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
     
    data1 = edit1.get() # ?…? ¥?œ ê°’ì„ ë¦¬í„´
    data2 = edit2.get()
    data3 = edit3.get()
    data4 = edit4.get()
    try :
        sql = "insert into usertable values ('"+ data1 +"','"+data2+"','" +data3+"','" +data4+"')"
        cur.execute(sql) # DB ?— ?“±ë¡?
    except :
        messagebox.showerror("?˜¤ë¥?", "?°?´?„° ?…? ¥?‹œ ?˜¤ë¥? ë°œìƒ")
    else : # ?…? ¥ ?„±ê³?
        messagebox.showinfo("?„±ê³?", "?°?´?„° ?…? ¥ ?„±ê³?")
    finally :
        con.commit()
        con.close()
    
def selectData():
    strData1,strData2,strData3,strData4 = [],[],[],[]
    con = sqlite3.connect("iddb")
    cur = con.cursor()
    cur.execute("select * from usertable")
    strData1.append("?‚¬?š©?ID")
    strData2.append("?‚¬?š©? ?´ë¦?")
    strData3.append("?´ë©”ì¼")
    strData4.append("ì¶œìƒ?—°?„")
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
# => ?™?¼?•œ ?¬ê¸°ì˜ ë¦¬ìŠ¤?Š¸ë¥? ?—°ê²°í•˜ê¸?
# (strData1[0],strData2[0],strData3[0],strData4[0])
# (strData1[1],strData2[1],strData3[1],strData4[1] )
    for item1,item2,item3,item4 in zip(strData1,strData2,strData3,strData4) :
        listData1.insert(END,item1)
        listData2.insert(END,item2)
        listData3.insert(END,item3)
        listData4.insert(END,item4)
    con.close()
    
window = Tk() # GUI ?™˜ê²½ì„¤? •
window.geometry("600x300")
window.title("GUI ?°?´?„° ?…? ¥")

editFrame = Frame(window)
editFrame.pack()
listFrame = Frame(window)
listFrame.pack(side=BOTTOM,fill=BOTH,expand=1)

edit1 = Entry(editFrame,width=10) #edit ë°•ìŠ¤
edit1.pack(side=LEFT,padx=10,pady=10)
edit2 = Entry(editFrame,width=10)
edit2.pack(side=LEFT,padx=10,pady=10)
edit3 = Entry(editFrame,width=10)
edit3.pack(side=LEFT,padx=10,pady=10)
edit4 = Entry(editFrame,width=10)
edit4.pack(side=LEFT,padx=10,pady=10)

# command=insertData : ?´ë¦??œ ê²½ìš° insertData ?•¨?ˆ˜ ?˜¸ì¶?, ?•¸?“¤?Ÿ¬ ?„¤? •.
btnInsert = Button(editFrame,text="?…? ¥",command=insertData)
btnInsert.pack(side=LEFT,padx=10,pady=10)
btnSelect = Button(editFrame,text="ì¡°íšŒ",command=selectData)
btnSelect.pack(side=LEFT,padx=10,pady=10)

listData1 = Listbox(listFrame,bg="yellow")
listData1.pack(side=LEFT,fill=BOTH,expand=1)
listData2 = Listbox(listFrame,bg="yellow")
listData2.pack(side=LEFT,fill=BOTH,expand=1)
listData3 = Listbox(listFrame,bg="yellow")
listData3.pack(side=LEFT,fill=BOTH,expand=1)
listData4 = Listbox(listFrame,bg="yellow")
listData4.pack(side=LEFT,fill=BOTH,expand=1)
window.mainloop() # GUI ?™”ë©? ì¶œë ¥