'''
Created on 2018. 12. 21.

@author: gdj4
classEx6.py : 추상메서?��
            �?모클?��?��?�� 메서?�� �? ?��?���?�? ?���? 구현�??�� pass�? 채�?
'''

class SuperClass :
    def method(self):
        raise NotImplemented # ?��?�� ?��?��?��?��?�� 반드?�� ?��버라?��?�� ?��?��
    
class SubClass1(SuperClass):
    def method(self):
        print("SubClass1?��?�� method()�? ?��버라?��?��?��")

class SubClass2(SuperClass):
    def method(self):
        print("SubClass2?��?�� method()�? ?��버라?��?��?��")

sub1 = SubClass1()
sub2 = SubClass2()

sub1.method()
sub2.method()