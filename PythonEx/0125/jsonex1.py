'''
Created on 2019. 1. 25.

@author: gdj4

json 파일 읽기
'''

import json

with open("emp.json","r",encoding="utf8") as f:
    contents = f.read()
    json_data = json.loads(contents)
    print(json_data["employees"])
    print(type(json_data))
    
    for emp in json_data["employees"] :
        print(emp["firstName"],emp["lastName"])
