'''
Created on 2018. 12. 28.

@author: gdj4
'''
from xlrd import open_workbook
from xlwt import Workbook
from openpyxl import worksheet

input_file = "ssec1804.xls"
output_file = "ssec1804_out.xls"

output_workbook = Workbook() # 출력된 excel 파일 
# add_sheet("전체증감") : sheet를 추가. 이름 설정ㅇ
output_sheet = output_workbook.add_sheet("전체증감")
# workbook : 입력된 excel 파일
with open_workbook(input_file) as workbook :
    # workbook excel 파일에서 sheet 이름이 "1.전체증감" 인 sheet를 읽기 
    worksheet = workbook.sheet_by_name("1.전체증감")
    for row_index in range(worksheet.nrows) : # 해당 sheet의 행의 수
        for column_index in range(worksheet.ncols) : #해당 sheet의 열의 수
            output_sheet.write(row_index,column_index, worksheet.cell_value(row_index,column_index)) # 저장할 행과열의 인덱스
            print(worksheet.cell_value(row_index,column_index)) # 저장할 행과열의 값
output_workbook.save(output_file)