'''
Created on 2018. 12. 19.

@author: gdj4

toupleex1.py : ?��?�� ?��?��

리스?�� : ?��?��?���?, 배열  => [ ]
?��?��?���? : (key, value) ?��?���? ???��?�� 객체 = > { }
?��?�� : ?��?��?���? , ?��?�� 불�? 리스?�� => ( )
'''

def getMean(numbericValue): # ?��?�� ?��?��?�� �?
    return sum(numbericValue)/len(numbericValue)\
        if len(numbericValue) > 0\
        else float("NaN")

my_touple = ("x","y","z")
one,two,three = my_touple
print("output : {0}, {1}, {2}".format(one,two,three))

my_touple2 = (10,20,30,40)
print(my_touple2[0],my_touple2[1],my_touple2[2])
print(my_touple2[1:3])
print(my_touple2[:3])
print(my_touple2[3:])
print(my_touple2[:])

print("output #1(mean) : {!s}".format(getMean(my_touple2)))