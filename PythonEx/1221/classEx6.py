'''
Created on 2018. 12. 21.

@author: gdj4
classEx6.py : ì¶”ìƒë©”ì„œ?“œ
            ë¶?ëª¨í´?˜?Š¤?˜ ë©”ì„œ?“œ ì¤? ?„ ?–¸ë¶?ë§? ?ˆê³? êµ¬í˜„ë¶??Š” passë¡? ì±„ì?
'''

class SuperClass :
    def method(self):
        raise NotImplemented # ?•˜?œ„ ?´?˜?Š¤?—?„œ ë°˜ë“œ?‹œ ?˜¤ë²„ë¼?´?”© ?•„?š”
    
class SubClass1(SuperClass):
    def method(self):
        print("SubClass1?—?„œ method()ë¥? ?˜¤ë²„ë¼?´?”©?•¨")

class SubClass2(SuperClass):
    def method(self):
        print("SubClass2?—?„œ method()ë¥? ?˜¤ë²„ë¼?´?”©?•¨")

sub1 = SubClass1()
sub2 = SubClass2()

sub1.method()
sub2.method()