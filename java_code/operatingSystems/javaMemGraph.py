import matplotlib.pyplot as plt
import numpy as np
# takes usages from the java programs and visualizes the data in MiB/0.1sec

linear_filepath = "TK_pi_lin_usages_java.txt"  # change based on filepath
threaded_filepath = "TK_pi_thread_usages_java.txt"  # change based on filepath

# makes the y axis for linear memory usage
y = [0]     # linear memory usage datapoints
with open(linear_filepath, 'r') as f:
    lines = f.readlines()
for j in lines:
    y.append(int(j) / 1048576)

# makes the y axis for threaded memory usage
y2 = [0]    # threaded memory usage datapoints
with open(threaded_filepath, 'r') as f:
    lines = f.readlines()
for k in lines:
    y2.append(int(k) / 1048576)

# makes the x axis (based on how long the linear data is)
x = [0]     # 0.1 second intervals
l = 0.1
for i in range(len(y)-1):
    x.append(round(l, 1))
    l += 0.1
print(x)

# makes the x axis (based on how long the threaded data is)
x2 = [0]     # 0.1 second intervals
m = 0.1
for i in range(len(y2)-1):
    x2.append(round(m, 1))
    m += 0.1
print(x2)

# formats and displays the graph
plt.style.use('seaborn-whitegrid')
plt.plot(x, y, label="Linear memory usage")
plt.plot(x2, y2, label="Threaded memory usage")
plt.xticks(np.arange(0, x[-1]+1, step=1)) # find out how to do one-second intervals

plt.title("memory usage for all methods")
plt.xlabel("time (in seconds)")
plt.ylabel("memory used (in MiB)")
plt.legend()
plt.savefig('java_mem_TK_laptop.png')
#plt.show()