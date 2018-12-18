'''
Created on 2018. 12. 18.
파이썬에서는 자료형이 시점에 따라 손쉽게 바뀜
@author: gdj-4
'''
import operator
a = 10
print(type(a))
a= 1.5
print(type(a))

transDic, transList = {} , []
transDic ={"Thomas":"토마스","Edward":"에드워드","Henry":"헨리","Gothen":"고든","James":"제임스"}
transList = sorted(transDic.items(), key=operator.itemgetter(1))
#key=operator.itemgetter(1) : 정렬의 기준 설정, 0:영어 기준 , 1: 한국어 기준
print(type(transList))
print(transList)

transList = transDic.items()
print(type(transList))
print(transList)