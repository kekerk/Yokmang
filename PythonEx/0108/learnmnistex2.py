'''
Created on 2019. 1. 8.

@author: gdj4
mnist에 복사된 파일을 csv 파일로 저장하기
'''

'''
     > : big-endian 자료형
     < : little-endian 자료형
     
     i : 정수형(signed int)
     I : 정수형(unsigned int)
     b : 문자형
     B : 문자형(unsigned char)
'''
import struct

def to_csv(name,maxdata): # name = "train" , maxdata = 1000
    lbl_f = open("./mnist/"+name+"-labels-idx1-ubyte","rb") # 학습 데이터
    img_f = open("./mnist/"+name+"-images-idx3-ubyte","rb") # 결과(정답) 데이터
    csv_f = open("./mnist/"+name+".csv","w",encoding="utf-8") # 출력(csv형태) 파일
    mag,lbl_count = struct.unpack(">II", lbl_f.read(8)) # 8byte 읽기
    mag,img_count = struct.unpack(">II", img_f.read(8))
    rows,cols = struct.unpack(">II",img_f.read(8))
    pixels = rows*cols # 파일의 크기
    
    
    # 이미지 팡리을 csv 파일로 변경하기
    res = []
    for idx in range(lbl_count) : # 6만건의 학습 데이터가 저장됨
        if idx > maxdata : break # 1000건만 학습 데이터로 사용함
        label = struct.unpack("B",lbl_f.read(1))[0]
        bdata = img_f.read(pixels)
        sdata = list(map(lambda n : str(n),bdata))
        csv_f.write(str(label)+",")
        csv_f.write(",".join(sdata)+"\r\n")
        
        # csv 파일을 pgm 파일로 변경하기. 10개 데이터만
        if idx < 10 :
            s = "P2 28 28 255\n"
            s += " ".join(sdata)
            iname = "./mnist/{0}-{1}-{2}.pgm".format(name,idx,label)
            with open (iname,"w",encoding = "utf-8") as f :
                f.write(s) # pgm 파일로 복구함
                
    csv_f.close()
    lbl_f.close()
    img_f.close()
# to_csv 함수 끝

# main 시작
to_csv("train",10000) # 학습 데이터
to_csv("t10k",500) # 테스트 데이터
    
        