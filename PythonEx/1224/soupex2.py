'''
Created on 2018. 12. 24.

BeautifulSoup 예제
@author: gdj4
'''

from bs4 import BeautifulSoup

html = '''
  <html><body>
   <div id ="potal">
    <h1>포털 목록</h1>
    <ul class="items"><li><a href="http://www.naver.com">Naver</a></li>
        <li><a href="http://www.daum.net">Daum</a></li>
    </ul></div>
  </body></html>
'''
soup = BeautifulSoup(html,"html.parser")
links = soup.find_all("a") # a태그 전체 
for a in links :
    href = a.attrs["href"]
    text=a.string
    print(text,">",href)
h1 = soup.select_one("div#potal > h1").string # select_one 한 개 정보만 조회
print("h1 = ",h1)

li_list = soup.select("div#potal > ul.items > li") # select : 모든 정보 조회
for li in li_list :
    print("li = ",li.string)