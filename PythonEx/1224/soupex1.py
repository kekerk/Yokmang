'''
Created on 2018. 12. 24.
?¬λ‘€λ§ ?κΈ?
          ?λ°μ jsoup ?΄κ³? λΉμ·?¨.
@author: gdj4
'''

from bs4 import BeautifulSoup  # pip3 install beautifulsoup4

import urllib.request as req


# CDATA : ??±?μ§? ?? λΆ?λΆ? ?? λ¬Έμ?΄λ‘? ?Έ?
url ="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
# res : url? κ²°κ³Ό ?°?΄?°λ₯? ???₯
res = req.urlopen(url)
# res : λΆμ?  ?°?΄?°
# "html.parser : html ??λ₯? ?΄?©?΄? λΆμ
soup = BeautifulSoup(res,"html.parser") # BeautifulSoup κ°μ²΄ ??±
title = soup.find("title").string # title ?κ·Έμ ?΄?©

wf = soup.find("wf").string
print(title)
print(wf)