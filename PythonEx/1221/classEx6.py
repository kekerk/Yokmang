'''
Created on 2018. 12. 21.

@author: gdj4
classEx6.py : μΆμλ©μ?
            λΆ?λͺ¨ν΄??€? λ©μ? μ€? ? ?ΈλΆ?λ§? ?κ³? κ΅¬νλΆ?? passλ‘? μ±μ?
'''

class SuperClass :
    def method(self):
        raise NotImplemented # ?? ?΄??€?? λ°λ? ?€λ²λΌ?΄?© ??
    
class SubClass1(SuperClass):
    def method(self):
        print("SubClass1?? method()λ₯? ?€λ²λΌ?΄?©?¨")

class SubClass2(SuperClass):
    def method(self):
        print("SubClass2?? method()λ₯? ?€λ²λΌ?΄?©?¨")

sub1 = SubClass1()
sub2 = SubClass2()

sub1.method()
sub2.method()