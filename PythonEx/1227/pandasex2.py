'''
pandas 모듈을 이용하여 csv 파일 생성하기
'''

import pandas as pd
import sys

input_file = sys.argv[1] # supplier_data.csv
output_file = sys.argv[2] #pandas_out2.csv

data_frame = pd.read_csv(input_file)
'''
   row 검색
   loc : 정수형 인덱스로 설정
   iloc : 정수형 인덱스로 설정
   ix   : 인덱스의 형태가 정수형이 아니어도 됨
'''
data_frame_in_set = \
   data_frame.loc[data_frame["Invoice Number"].str.startswith("001-"),:]
data_frame_in_set.to_csv(output_file,index=False)
