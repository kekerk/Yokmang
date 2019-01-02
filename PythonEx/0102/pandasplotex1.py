'''
Created on 2019. 1. 2.

@author: gdj4
pandas 데이터를 그래프로 그리기
'''

import pandas as pd             # 표 정보 모듈
import numpy as np              # python의 수치계산 모듈
import matplotlib.pyplot as plt # 그래프를 위한 모듈

plt.style.use("ggplot")

# ax1 : 첫번째 그림
# ax2 : 두번째 그림
fig,axes = plt.subplots(nrows=1,ncols=2) # 1행 2열
ax1,ax2 = axes.ravel()

# 5행 3열로 난수 생성
data_frame = pd.DataFrame(np.random.rand(5,3),\
index=["Customer 1","Customer 2","Customer 3","Customer 4","Customer 5"],\
columns=pd.Index(["Matric 1","Matric 2","Matric 3"], name="Metrics"))
data_frame.plot(kind="bar",ax=ax1, alpha=0.75,title="Bar plot")
plt.setp(ax1.get_xticklabels(),rotation=45,fontsize=10)
plt.setp(ax1.get_yticklabels(),rotation=0,fontsize=10)
ax1.set_xlabel("Customer")
ax1.set_ylabel("Value")
ax1.xaxis.set_ticks_position("bottom")
ax1.yaxis.set_ticks_position("left")

colors = dict(boxes="DarkBlue",\
              whiskers="Gray",medians="Red",caps="Black")
data_frame.plot(kind="box",color=colors,sym="r.",ax=ax2,title="Box Plot")
plt.setp(ax2.get_xticklabels(),rotation=45,fontsize=10)
plt.setp(ax2.get_yticklabels(),rotation=0,fontsize=10)
ax2.set_xlabel("Metric")
ax2.set_ylabel("Value")
ax2.xaxis.set_ticks_position("bottom")
ax2.yaxis.set_ticks_position("left")

plt.savefig("pandas_plot.png",dpi=400,bbox_inches="tight") # 이미지파일로 저장
plt.show() # 화면에 출력

