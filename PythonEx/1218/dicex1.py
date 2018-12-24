singer = {}
singer['?´ë¦?'] = '?Š¸???´?Š¤'
singer['ë©¤ë²„ ?ˆ˜'] = 9
singer['?°ë·?'] = '?„œë°”ì´ë²? ?‹?Š¤?‹´'
singer['???‘œê³?'] = 'cheer up'

for i in singer.keys() :
    print("%s => %s" %(i,singer[i]))
    
    
print(type(singer))
print(type(singer.keys()))
print(type(list(singer.keys())))