'''
Created on 2018. 12. 24.
?λ²μ? ?΄λ―Έμ? ?€?΄
@author: gdj4
'''

import urllib.request


url = "http://uta.pw/shodou/img/28/214.png"
# ?¨?λ₯? ?΄?©??¬ ???₯?κΈ?
savename= "test2.png"
#urllib.request.urlretrieve(url,savename)

# ??Ό? ?΄?©??¬ ???₯?κΈ?
mem = urllib.request.urlopen(url).read()
with open(savename,mode="wb") as f :
    f.write(mem)
print("???₯?λ£?")