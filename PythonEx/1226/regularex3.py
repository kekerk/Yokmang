'''
Created on 2018. 12. 26.

@author: gdj4
'''

import re


string = "The quick brown fox jumps over the lazy dog."
string_list = string.split()
# r : row 문자?��
# re.I : ???��문자 구분 ?��?��
pattern = re.compile(r"The",re.I)
count = 0
for word in string_list :
    if pattern.search(word) : # �??��?���? True 리턴
        count += 1
print("output #1 {0:d}".format(count))
# match_word : match_word 그룹 ?���? ?��?��?��
#              ???��문자 구분?��?�� The 문자�? match_word 그룹?���? ?��?��
pattern = re.compile(r"(?P<match_word>The)",re.I)
print("output #2 : ")
for word in string_list : 
    if pattern.search(word) :
        print("{0}".format(pattern.search(word).group("match_word")))
string_to_find = r"The"
pattern = re.compile(string_to_find,re.I)
print("output #3 : {0}".format(pattern.sub("a",string)))