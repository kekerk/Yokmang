'''
Created on 2018. 12. 24.
서버에서 이미지 다운
@author: gdj4
'''

import urllib.request


url = "http://uta.pw/shodou/img/28/214.png"
# 함수를 이용하여 저장하기
savename= "test2.png"
#urllib.request.urlretrieve(url,savename)

# 파일을 이용하여 저장하기
mem = urllib.request.urlopen(url).read()
with open(savename,mode="wb") as f :
    f.write(mem)
print("저장완료")