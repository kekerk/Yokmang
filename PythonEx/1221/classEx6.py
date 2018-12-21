'''
Created on 2018. 12. 21.

@author: gdj4
classEx6.py : 추상메서드
            부모클래스의 메서드 중 선언부만 있고 구현부는 pass로 채움
'''

class SuperClass :
    def method(self):
        raise NotImplemented # 하위 클래스에서 반드시 오버라이딩 필요
    
class SubClass1(SuperClass):
    def method(self):
        print("SubClass1에서 method()를 오버라이딩함")

class SubClass2(SuperClass):
    def method(self):
        print("SubClass2에서 method()를 오버라이딩함")

sub1 = SubClass1()
sub2 = SubClass2()

sub1.method()
sub2.method()