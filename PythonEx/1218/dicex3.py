'''
Created on 2018. 12. 18.
?��?��?��?��?��?�� ?��료형?�� ?��?��?�� ?��?�� ?��?���? 바�??
@author: gdj-4
'''
import operator

a = 10
print(type(a))
a= 1.5
print(type(a))

transDic, transList = {} , []
transDic ={"Thomas":"?��마스","Edward":"?��?��?��?��","Henry":"?���?","Gothen":"고든","James":"?��?��?��"}
transList = sorted(transDic.items(), key=operator.itemgetter(1))
#key=operator.itemgetter(1) : ?��?��?�� 기�? ?��?��, 0:?��?�� 기�? , 1: ?���??�� 기�?
print(type(transList))
print(transList)

transList = transDic.items()
print(type(transList))
print(transList)