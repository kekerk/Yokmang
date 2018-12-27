'''
Created on 2018. 12. 27.

pandas를 이용하여 csv 파일 읽고, 저장하기

@author: gdj4
'''
import pandas as pd
import sys

input_file = sys.argv[1]
output_file = sys.argv[2]

data_frame = pd.read_csv(input_file)

importand_dates = ["1/20/14","1/30/14"]
data_frame_in_set = \
   data_frame.loc[data_frame["Purchase Data"].isin(importand_dates),:]
data_frame_in_set.to_csv(output_file,index=False)
