'''
Created on 2019. 1. 25.

@author: gdj4
xmlex1.py : xml 파일을 읽어서 파싱하기
'''
from bs4 import BeautifulSoup
with open("books.xml","r",encoding="utf-8") as f:
    books_xml = f.read()

soup = BeautifulSoup(books_xml,"html.parser")

for book_info in soup.find_all("author") :
    print(book_info)
    print(book_info.get_text())