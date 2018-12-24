'''
Created on 2018. 12. 19.

@author: gdj4
'''

import matplotlib.pyplot as plt  # pip3 install ggplot
import numpy as np  # pip3 install numpy 3.7ë²„ì „?—?„œ ?„¤ì¹? ?•ˆ?•¨.


plt.style.use("ggplot")
N = 500
# ? •ê·œí™”?— ë§ë„ë¡? ?‚œ?ˆ˜ ë°œìƒ
normal = np.random.normal(loc=0.0, scale=1.0, size=N)
lognormal = np.random.lognormal(mean=0.0,sigma=1.0,size=N)
index_value = np.random.random_integers(low=0,high=N-1,size=N)
normal_sample = normal[index_value]
lognormal_sample = lognormal[index_value]
bax_plot_data = [normal,normal_sample,lognormal,lognormal_sample]

fig = plt.figure()
ax1 = fig.add_subplot(1,1,1)
# boxplot : ìµœë?ê°?, ìµœì†Œê°?, ?¸ì°? ?“±?„ ê·¸ë˜?”„ë¡? ?‘œ?‹œ
box_labels =['normal','normal_sample','lognormal','lognormal_sample']
ax1.boxplot(bax_plot_data,notch=False,sym='.',vert=True,whis=1.5,showmeans=True,labels=box_labels)

ax1.xaxis.set_ticks_position("bottom")
ax1.yaxis.set_ticks_position("left")
ax1.set_title("Box Plot")
ax1.set_xlabel("Distribution")
ax1.set_ylabel("Value")

plt.savefig("box_plot.png",dpi=400,bbox_inches="tight")
plt.show()