'''
Created on 2018. 12. 18.
?ŒŒ?´?¬?—?„œ?Š” ?ë£Œí˜•?´ ?‹œ? ?— ?”°?¼ ?†?‰½ê²? ë°”ë??
@author: gdj-4
'''
import operator

a = 10
print(type(a))
a= 1.5
print(type(a))

transDic, transList = {} , []
transDic ={"Thomas":"?† ë§ˆìŠ¤","Edward":"?—?“œ?›Œ?“œ","Henry":"?—¨ë¦?","Gothen":"ê³ ë“ ","James":"? œ?„?Š¤"}
transList = sorted(transDic.items(), key=operator.itemgetter(1))
#key=operator.itemgetter(1) : ? •? ¬?˜ ê¸°ì? ?„¤? •, 0:?˜?–´ ê¸°ì? , 1: ?•œêµ??–´ ê¸°ì?
print(type(transList))
print(transList)

transList = transDic.items()
print(type(transList))
print(transList)