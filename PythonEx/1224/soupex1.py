'''
Created on 2018. 12. 24.
?¬ë¡¤ë§ ?•˜ê¸?
          ?ë°”ì˜ jsoup ?ˆ´ê³? ë¹„ìŠ·?•¨.
@author: gdj4
'''

from bs4 import BeautifulSoup  # pip3 install beautifulsoup4

import urllib.request as req


# CDATA : ?ŒŒ?‹±?•˜ì§? ?•Š?Š” ë¶?ë¶? ?ˆœ?ˆ˜ ë¬¸ì?—´ë¡? ?¸?‹
url ="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
# res : url?˜ ê²°ê³¼ ?°?´?„°ë¥? ???¥
res = req.urlopen(url)
# res : ë¶„ì„?•  ?°?´?„°
# "html.parser : html ?ŒŒ?„œë¥? ?´?š©?•´?„œ ë¶„ì„
soup = BeautifulSoup(res,"html.parser") # BeautifulSoup ê°ì²´ ?ƒ?„±
title = soup.find("title").string # title ?ƒœê·¸ì˜ ?‚´?š©

wf = soup.find("wf").string
print(title)
print(wf)