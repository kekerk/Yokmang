'''

'''

import urllib.request


url = "http://api.aoikujira.com/ip/ini"
res= urllib.request.urlopen(url) # url ?��결하?�� ?��?��
data = res.read()
text = data.decode("utf-8")  # 문자?���? �??��?���?
print(text)