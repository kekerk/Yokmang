'''

'''

import urllib.request


url = "http://api.aoikujira.com/ip/ini"
res= urllib.request.urlopen(url) # url ?°κ²°ν?¬ ??΅
data = res.read()
text = data.decode("utf-8")  # λ¬Έμ?΄λ‘? λ³???κΈ?
print(text)