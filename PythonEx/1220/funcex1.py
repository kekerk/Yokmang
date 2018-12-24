'''
Created on 2018. 12. 20.

@author: gdj4
'''

def multi(v1,v2):
    retList = []
    res1 = v1 + v2
    res2 = v1 - v2
    retList.append(res1)
    retList.append(res2)
    return retList

myList = []
hap,sub = 0,0

myList = multi(100,200)
hap = myList[0]
sub = myList[1]
print("multi ?•¨?ˆ˜?˜ ë¦¬í„´ê°? : %d, %d" % (hap,sub))

#?ë°”ì—?„œ?„ ë§¤ê°œë³??ˆ˜?˜ ê°??ˆ˜ê°? ì§?? •?˜ì§? ?•Š?„ ?ˆ˜ ?ˆ?‹¤
'''
  public static void mymethod(Object ... args) {
 }
  Python?—?„œ?Š”
  def mymethod(*args)
'''