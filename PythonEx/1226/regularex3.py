'''
Created on 2018. 12. 26.

@author: gdj4
'''

import re


string = "The quick brown fox jumps over the lazy dog."
string_list = string.split()
# r : row λ¬Έμ?
# re.I : ???λ¬Έμ κ΅¬λΆ ??΄
pattern = re.compile(r"The",re.I)
count = 0
for word in string_list :
    if pattern.search(word) : # κ²???λ©? True λ¦¬ν΄
        count += 1
print("output #1 {0:d}".format(count))
# match_word : match_word κ·Έλ£Ή ?΄λ¦? ??€? 
#              ???λ¬Έμ κ΅¬λΆ??΄ The λ¬Έμλ₯? match_word κ·Έλ£Ή?Όλ‘? ?€? 
pattern = re.compile(r"(?P<match_word>The)",re.I)
print("output #2 : ")
for word in string_list : 
    if pattern.search(word) :
        print("{0}".format(pattern.search(word).group("match_word")))
string_to_find = r"The"
pattern = re.compile(string_to_find,re.I)
print("output #3 : {0}".format(pattern.sub("a",string)))