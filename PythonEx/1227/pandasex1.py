'''
Created on 2018. 12. 27.

pandasλ₯? ?΄?©??¬ csv ??Ό ?½κ³?, ???₯?κΈ?

@author: gdj4
'''
import sys

import pandas as pd


input_file = sys.argv[1] # supplier_data.csv
output_file = sys.argv[2] #pandas_out.csv

data_frame = pd.read_csv(input_file)

importand_dates = ["1/20/14","1/30/14"]
# loc : ?μΉ? μ§?? ?κΈ?
# isin : ?¬?¨??κ°??
data_frame_in_set = \
   data_frame.loc[data_frame["Purchase Date"].isin(importand_dates),:]
# data_frame_in_set λ³??κ°? ???₯? ?΄?©? csv ??Όλ‘? ??±?κΈ?
data_frame_in_set.to_csv(output_file,index=False)
