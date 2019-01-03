'''
Created on 2018. 12. 26.

@author: gdj4
python csvex1.py : input output
sys.argv[0] : csvex1.py, ?”„ë¡œê·¸?¨ ?´ë¦?
sys.argv[1] : input
sys.argv[2] : output
'''
import csv
import sys  # command ?¼?¸?—?„œ ?…? ¥ê°? ë°›ê¸°


input_file = sys.argv[1] # jeju1.csv
output_file = sys.argv[2] # jeju1_bak.csv
# filereader = open(input_file,'r'newline="")
with open(input_file,'r',newline="") as filereader : 
    with open(output_file,'w',newline="") as filewriter :
        header = filereader.readline()
        header = header.strip() # str ???…?œ¼ë¡? ë³??™˜ strip?„ ?•ˆ ?“°ë©? ?Š¹?ˆ˜ë¬¸ìê°? ? „ë¶? ?‚˜?˜¤ê¸? ?•Œë¬¸ì— ë¬¸ì?˜•?œ¼ë¡? ë°”ê¾¸?–´ì¤˜ì„œ ?Š¹?ˆ˜ë¬¸ìë¥? ?‚ ? ¤ë²„ë¦°?‹¤.
        header_list = header.split(",")
        print(header_list)
        filewriter.write(",".join(map(str,header_list))+ "\r\n")
        for row_list in filereader :
            filewriter.write("".join(map(str,row_list)))