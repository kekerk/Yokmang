a = ord('A') #아스키코드값 리턴
print(a)
mask = 0x0F #16진수 F, 10진수 15
'''
    'A' 41 : 0100 0001 : 65
  mask  0F : 0000 1111 : 15
  =========================
     &     : 0000 0001 : 1
     |     : 0100 1111 : 4F
     ^     : 0100 1110 : 4E
'''
print("%X & %X = %X" % (a,mask, a&mask))
print("%X | %X = %X" % (a,mask, a|mask))
print("%X ^ %X = %X" % (a,mask, a^mask))

a = 100
result = 0

for i in range(1,5) :
    result = a << i # x 2
    print("%d << %d = %d" % (a, i, result))

for i in range(1,5) :
    result = a >> i # / 2
    print("%d >> %d = %d" % (a, i, result))