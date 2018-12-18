'''
Created on 2018. 12. 18.

@author: gdj4
'''

import shutil
import os
import os.path
from macpath import dirname

print(dir(shutil))
print(dir(os))
print(dir(os.path))

# shutil.copy("c:/windows/notepad.exe", "c:/temp/note.exe")
# print("파일 복사 완료")
# shutil.copytree("c:/temp","c:/temp3")


''' c:/mydir 폴더 생성하기 '''
os.mkdir("c:/mydir")
# c:/mydir 폴더 지우기
# shutil.rmtree("c:/mydir/")
# print("폴더 삭제 완료")

print("파일의 목록 보기 : os.walk 함수 사용")
for dirName,subDirList,fnames in os.walk("c:\\windows\\debug") :
    for fname in fnames : 
        print(os.path.join(dirName,fname))