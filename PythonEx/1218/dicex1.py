singer = {}
singer['?���?'] = '?��???��?��'
singer['멤버 ?��'] = 9
singer['?���?'] = '?��바이�? ?��?��?��'
singer['???���?'] = 'cheer up'

for i in singer.keys() :
    print("%s => %s" %(i,singer[i]))
    
    
print(type(singer))
print(type(singer.keys()))
print(type(list(singer.keys())))