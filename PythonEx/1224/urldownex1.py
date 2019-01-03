'''
Created on 2018. 12. 24.
?„œë²„ì—?„œ ?´ë¯¸ì? ?‹¤?š´
@author: gdj4
'''

import urllib.request


url = "http://uta.pw/shodou/img/28/214.png"
# ?•¨?ˆ˜ë¥? ?´?š©?•˜?—¬ ???¥?•˜ê¸?
savename= "test2.png"
#urllib.request.urlretrieve(url,savename)

# ?ŒŒ?¼?„ ?´?š©?•˜?—¬ ???¥?•˜ê¸?
mem = urllib.request.urlopen(url).read()
with open(savename,mode="wb") as f :
    f.write(mem)
print("???¥?™„ë£?")