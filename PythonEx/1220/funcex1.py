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
print("multi 함수의 리턴값 : %d, %d" % (hap,sub))

#자바에서도 매개변수의 갯수가 지정되지 않을 수 있다
'''
  public static void mymethod(Object ... args) {
 }
  Python에서는
  def mymethod(*args)
'''