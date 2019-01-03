'''
Created on 2018. 12. 26.

@author: gdj4
'''

import re


string = "The quick brown fox jumps over the lazy dog."
string_list = string.split()
# r : row ë¬¸ì?˜•
# re.I : ???†Œë¬¸ì êµ¬ë¶„ ?—†?´
pattern = re.compile(r"The",re.I)
count = 0
for word in string_list :
    if pattern.search(word) : # ê²??ƒ‰?˜ë©? True ë¦¬í„´
        count += 1
print("output #1 {0:d}".format(count))
# match_word : match_word ê·¸ë£¹ ?´ë¦? ?…ˆ?„¤? •
#              ???†Œë¬¸ì êµ¬ë¶„?—†?´ The ë¬¸ìë¥? match_word ê·¸ë£¹?œ¼ë¡? ?„¤? •
pattern = re.compile(r"(?P<match_word>The)",re.I)
print("output #2 : ")
for word in string_list : 
    if pattern.search(word) :
        print("{0}".format(pattern.search(word).group("match_word")))
string_to_find = r"The"
pattern = re.compile(string_to_find,re.I)
print("output #3 : {0}".format(pattern.sub("a",string)))