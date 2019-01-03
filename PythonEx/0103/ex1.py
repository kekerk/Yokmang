'''
Created on 2019. 1. 3.

@author: gdj4
'''
import yaml  # pip3 instal pyYAML


yaml_str = """
    Date : 2019-01-03
    PriceList: 
         -
            item_id: 1000
            name: banana
            color: yellow
            price: 800
         -
            item_id: 1001
            name: orange
            color: orange
            price: 1400
         -
            item_id: 1002
            name: Apple
            color: red
            price: 2400
"""
# yaml 문서를 파이썬 자료형 (DICTIONARY)로 변경
data = yaml.load(yaml_str)
print(data["Date"],"과일 가격")
for item in data["PriceList"] :
    print(item["name"],item["price"])
    
# 파이썬 데이터를 yaml 문서로 변경하기

customer = [
    {"name": "Inseong","age": "24", "gender": "man"},
    {"name": "Kildong","age": "22", "gender": "man"},
    {"name": "ChunHang","age": "20", "gender": "woman"},
    {"name": "HangDan","age": "25", "gender": "woman"},
]
yaml_str=yaml.dump(customer)
print(type(yaml_str))
print(yaml_str)

# yaml 문서를 파이썬 자료형(List)로 변경

data = yaml.load(yaml_str)
for d in data :
    print(d["name"],d["age"],d["gender"])
