'''
Created on 2018. 12. 19.
graph1.py : 그래프 그리기
@author: gdj4
'''

import matplotlib.pyplot as plt # pip3 install ggplot
plt.style.use("ggplot")
customers = ["JAVA","JSP","SPRING","HADOOP","PYTHON"] # 리스트
customers_index = range(len(customers)) # 0 ~ 4 까지의 값
sale_amount = [65,90,85,60,95] # 점수값 리스트로 저장

fig = plt.figure() # 그래프를 생성할 공간
ax1 = fig.add_subplot(1,1,1) # 1행1열 1번째 그래프
# 막대 그래프 그리기
ax1.bar(customers_index,sale_amount,align="center",color="darkblue")
# x축 설정
ax1.xaxis.set_ticks_position("bottom")
# y축 설정
ax1.yaxis.set_ticks_position("left")
# x축 내용
plt.xticks(customers_index, customers,rotation=0,fontsize="small")

plt.xlabel("Subject")
plt.ylabel("Score")
plt.title("Class Score")
# 이미지파일로 저장
plt.savefig("bar_plot.png",dpi=400, bbox_inches="tight")
# 화면에 이미지 출력
plt.show()
