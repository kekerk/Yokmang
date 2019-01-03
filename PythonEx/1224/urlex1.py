'''

'''

import urllib.request


url = "http://api.aoikujira.com/ip/ini"
res= urllib.request.urlopen(url) # url ?—°ê²°í•˜?—¬ ?‘?‹µ
data = res.read()
text = data.decode("utf-8")  # ë¬¸ì?—´ë¡? ë³??™˜?•˜ê¸?
print(text)