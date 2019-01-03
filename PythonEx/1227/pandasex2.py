'''
pandas 모듈?�� ?��?��?��?�� csv ?��?�� ?��?��?���?
'''

import sys

import pandas as pd


input_file = sys.argv[1] # supplier_data.csv
output_file = sys.argv[2] #pandas_out2.csv

data_frame = pd.read_csv(input_file)
'''
   row �??��
   loc : ?��?��?�� ?��?��?���? ?��?��
   iloc : ?��?��?�� ?��?��?���? ?��?��
   ix   : ?��?��?��?�� ?��?���? ?��?��?��?�� ?��?��?��?�� ?��
'''
data_frame_in_set = \
   data_frame.loc[data_frame["Invoice Number"].str.startswith("001-"),:]
data_frame_in_set.to_csv(output_file,index=False)
