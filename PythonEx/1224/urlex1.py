'''

'''

import urllib.request


url = "http://api.aoikujira.com/ip/ini"
res= urllib.request.urlopen(url) # url 연결하여 응답
data = res.read()
text = data.decode("utf-8")  # 문자열로 변환하기
print(text)