'''
Created on 2018. 12. 24.
?��롤링 ?���?
          ?��바의 jsoup ?���? 비슷?��.
@author: gdj4
'''

from bs4 import BeautifulSoup  # pip3 install beautifulsoup4

import urllib.request as req


# CDATA : ?��?��?���? ?��?�� �?�? ?��?�� 문자?���? ?��?��
url ="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
# res : url?�� 결과 ?��?��?���? ???��
res = req.urlopen(url)
# res : 분석?�� ?��?��?��
# "html.parser : html ?��?���? ?��?��?��?�� 분석
soup = BeautifulSoup(res,"html.parser") # BeautifulSoup 객체 ?��?��
title = soup.find("title").string # title ?��그의 ?��?��

wf = soup.find("wf").string
print(title)
print(wf)