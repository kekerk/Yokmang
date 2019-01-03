'''
Created on 2018. 12. 19.
graph1.py : ê·¸ë˜?”„ ê·¸ë¦¬ê¸?
@author: gdj4
'''

import matplotlib.pyplot as plt  # pip3 install ggplot


plt.style.use("ggplot")
customers = ["JAVA","JSP","SPRING","HADOOP","PYTHON"] # ë¦¬ìŠ¤?Š¸
customers_index = range(len(customers)) # 0 ~ 4 ê¹Œì??˜ ê°?
sale_amount = [65,90,85,60,95] # ? ?ˆ˜ê°? ë¦¬ìŠ¤?Š¸ë¡? ???¥

fig = plt.figure() # ê·¸ë˜?”„ë¥? ?ƒ?„±?•  ê³µê°„
ax1 = fig.add_subplot(1,1,1) # 1?–‰1?—´ 1ë²ˆì§¸ ê·¸ë˜?”„
# ë§‰ë? ê·¸ë˜?”„ ê·¸ë¦¬ê¸?
ax1.bar(customers_index,sale_amount,align="center",color="darkblue")
# xì¶? ?„¤? •
ax1.xaxis.set_ticks_position("bottom")
# yì¶? ?„¤? •
ax1.yaxis.set_ticks_position("left")
# xì¶? ?‚´?š©
plt.xticks(customers_index, customers,rotation=0,fontsize="small")

plt.xlabel("Subject")
plt.ylabel("Score")
plt.title("Class Score")
# ?´ë¯¸ì??ŒŒ?¼ë¡? ???¥
plt.savefig("bar_plot.png",dpi=400, bbox_inches="tight")
# ?™”ë©´ì— ?´ë¯¸ì? ì¶œë ¥
plt.show()
