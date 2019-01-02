'''
Created on 2019. 1. 2.

@author: gdj4
모든 sheet들의 열을 선택하기
'''

import pandas as pd

input_file = "sales_2013.xlsx"
output_file="pandas_output6.xls"

data_frame = pd.read_excel(input_file,sheetname=None,index_col=None)

column_output=[]
for worksheet_name, data in data_frame.items() :
    column_output.append(data.loc[:,["Customer Name","Sale Amount"]])
select_cols = pd.concat(column_output,axis=0,ignore_index=True)

writer = pd.ExcelWriter(output_file)
select_cols.to_excel(writer,sheet_name="select_columns_all",index=False)
writer.save()