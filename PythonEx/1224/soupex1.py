'''
Created on 2018. 12. 24.
크롤링 하기
          자바의 jsoup 툴과 비슷함.
@author: gdj4
'''

from bs4 import BeautifulSoup  # pip3 install beautifulsoup4
import urllib.request as req

# CDATA : 파싱하지 않는 부분 순수 문자열로 인식
url ="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
# res : url의 결과 데이터를 저장
res = req.urlopen(url)
# res : 분석할 데이터
# "html.parser : html 파서를 이용해서 분석
soup = BeautifulSoup(res,"html.parser") # BeautifulSoup 객체 생성
title = soup.find("title").string # title 태그의 내용

wf = soup.find("wf").string
print(title)
print(wf)