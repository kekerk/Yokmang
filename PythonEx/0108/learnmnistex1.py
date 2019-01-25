'''
Created on 2019. 1. 8.

@author: gdj4
url에서 파일 다운받기
'''

import urllib.request as req
import gzip,os,os.path

savepath = "./mnist" # 저장할 폴더 위치
baseurl = "http://yann.lecun.com/exdb/mnist/"
files = ["train-images-idx3-ubyte.gz",
         "train-labels-idx1-ubyte.gz",
         "t10k-images-idx3-ubyte.gz",
         "t10k-labels-idx1-ubyte.gz"]
# mkdir : 폴더 생성
if not os.path.exists(savepath) : os.mkdir(savepath)
for f in files :
    url = baseurl + "/" + f
    loc = savepath + "/" + f
    print("download : "+ url)
    if not os.path.exists(loc):
        req.urlretrieve(url,loc)
        
for f in files :
    gz_file = savepath + "/" + f
    raw_file = savepath + "/" + f.replace(".gz","")
    print("gzip : "+ f)
    with gzip.open(gz_file,"rb") as fp :
        body = fp.read()
        with open(raw_file,"wb") as fw :
            fw.write(body)
            
print("프로그램 종료")        