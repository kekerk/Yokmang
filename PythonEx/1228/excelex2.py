'''
Created on 2018. 12. 28.

@author: gdj4
'''
from xlrd import open_workbook
from openpyxl import worksheet

input_file = "ssec1804.xls"
workbook = open_workbook(input_file)

print("worksheets의 갯수 : ", workbook.nsheets)
for worksheet in workbook.sheets() :
    print("worksheet 이름 : ",worksheet.name,"\n행수 : ",worksheet.nrows
          ,"\n컬럼수 : ",worksheet.ncols)
