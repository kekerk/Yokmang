'''
Created on 2019. 1. 25.

@author: gdj4
  jsonex2.py : 딕셔너리를 json 형태 파일로 생성하기
'''
import json
dic_data = {"Name":"hong","Age":"20","class":"Spring BigData"}

with open("data.json","w") as f:
    json.dump(dic_data,f)
