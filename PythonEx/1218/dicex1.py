singer = {}
singer['?´ëŚ?'] = '?¸???´?¤'
singer['ëŠ¤ë˛ ?'] = 9
singer['?°ëˇ?'] = '?ë°ě´ë˛? ??¤?´'
singer['???ęł?'] = 'cheer up'

for i in singer.keys() :
    print("%s => %s" %(i,singer[i]))
    
    
print(type(singer))
print(type(singer.keys()))
print(type(list(singer.keys())))