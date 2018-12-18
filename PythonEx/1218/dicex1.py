singer = {}
singer['이름'] = '트와이스'
singer['멤버 수'] = 9
singer['데뷔'] = '서바이벌 식스틴'
singer['대표곡'] = 'cheer up'

for i in singer.keys() :
    print("%s => %s" %(i,singer[i]))
    
    
print(type(singer))
print(type(singer.keys()))
print(type(list(singer.keys())))