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
# print("??Ό λ³΅μ¬ ?λ£?")
# shutil.copytree("c:/temp","c:/temp3")


''' c:/mydir ?΄? ??±?κΈ? '''
os.mkdir("c:/mydir")
# c:/mydir ?΄? μ§??°κΈ?
# shutil.rmtree("c:/mydir/")
# print("?΄? ?­?  ?λ£?")

print("??Ό? λͺ©λ‘ λ³΄κΈ° : os.walk ?¨? ?¬?©")
for dirName,subDirList,fnames in os.walk("c:\\windows\\debug") :
    for fname in fnames : 
        print(os.path.join(dirName,fname))