'''
Created on 2018. 12. 19.
graph1.py : 그래?�� 그리�?
@author: gdj4
'''

import matplotlib.pyplot as plt  # pip3 install ggplot


plt.style.use("ggplot")
customers = ["JAVA","JSP","SPRING","HADOOP","PYTHON"] # 리스?��
customers_index = range(len(customers)) # 0 ~ 4 까�??�� �?
sale_amount = [65,90,85,60,95] # ?��?���? 리스?���? ???��

fig = plt.figure() # 그래?���? ?��?��?�� 공간
ax1 = fig.add_subplot(1,1,1) # 1?��1?�� 1번째 그래?��
# 막�? 그래?�� 그리�?
ax1.bar(customers_index,sale_amount,align="center",color="darkblue")
# x�? ?��?��
ax1.xaxis.set_ticks_position("bottom")
# y�? ?��?��
ax1.yaxis.set_ticks_position("left")
# x�? ?��?��
plt.xticks(customers_index, customers,rotation=0,fontsize="small")

plt.xlabel("Subject")
plt.ylabel("Score")
plt.title("Class Score")
# ?��미�??��?���? ???��
plt.savefig("bar_plot.png",dpi=400, bbox_inches="tight")
# ?��면에 ?��미�? 출력
plt.show()
