'''
Created on 2018. 12. 24.

@author: gdj4
'''
from bs4 import BeautifulSoup
import urllib.request as req

url ="https://finance.naver.com/marketindex/"
res = req.urlopen(url)

print(res)
soup = BeautifulSoup(res,"html.parser",from_encoding="euc-kr")

price = soup.select_one("div.head_info > span.value").string
print("usd/krw =",price,end="")

krw = soup.select_one("div.head_info > span.txt_krw > span.blind").string
print(krw)

price2 = soup.select_one("div.head_info > span.blind").string
print("변동 =",price2,end="")
