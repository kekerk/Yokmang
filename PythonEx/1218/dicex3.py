'''
Created on 2018. 12. 18.
??΄?¬??? ?λ£ν?΄ ?? ? ?°?Ό ??½κ²? λ°λ??
@author: gdj-4
'''
import operator


a = 10
print(type(a))
a= 1.5
print(type(a))

transDic, transList = {} , []
transDic ={"Thomas":"? λ§μ€","Edward":"????","Henry":"?¨λ¦?","Gothen":"κ³ λ ","James":"? ??€"}
transList = sorted(transDic.items(), key=operator.itemgetter(1))
#key=operator.itemgetter(1) : ? ? ¬? κΈ°μ? ?€? , 0:??΄ κΈ°μ? , 1: ?κ΅??΄ κΈ°μ?
print(type(transList))
print(transList)

transList = transDic.items()
print(type(transList))
print(transList)