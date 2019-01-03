'''
Created on 2018. 12. 24.

@author: gdj4
'''
from bs4 import BeautifulSoup

import urllib.request as req


url ="https://finance.naver.com/marketindex/"
res = req.urlopen(url)
soup = BeautifulSoup(res,"html.parser",from_encoding="euc-kr")
hlist = soup.select("div.head_info")
htitle = soup.select("h3.h_lst")
# tag : div.head_info ?ƒœê·? ?•œ ê°?
# title : h3_lst ?ƒœê·? ?•œ ê°?
for tag,title in zip(hlist,htitle) :
    print(title.select_one("span.blind").string,end="\t")
    value = tag.select_one("span.value").string
    print(value,end="?›\t")
    change = tag.select_one("span.change").string
    print(change,end="\t")
    blinds = tag.select("span.blind")
    b = tag.select("span.blind")[len(blinds)-1].string
    print(b,end="********\n")