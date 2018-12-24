'''
Created on 2018. 12. 18.

@author: gdj4
'''

from macpath import dirname
import os
import os.path
import shutil


print(dir(shutil))
print(dir(os))
print(dir(os.path))

# shutil.copy("c:/windows/notepad.exe", "c:/temp/note.exe")
# print("?åå?ùº Î≥µÏÇ¨ ?ôÑÎ£?")
# shutil.copytree("c:/temp","c:/temp3")


''' c:/mydir ?è¥?çî ?Éù?Ñ±?ïòÍ∏? '''
os.mkdir("c:/mydir")
# c:/mydir ?è¥?çî Ïß??ö∞Í∏?
# shutil.rmtree("c:/mydir/")
# print("?è¥?çî ?Ç≠?†ú ?ôÑÎ£?")

print("?åå?ùº?ùò Î™©Î°ù Î≥¥Í∏∞ : os.walk ?ï®?àò ?Ç¨?ö©")
for dirName,subDirList,fnames in os.walk("c:\\windows\\debug") :
    for fname in fnames : 
        print(os.path.join(dirName,fname))