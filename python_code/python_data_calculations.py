#Thomas Kyte

#import for plotting
import matplotlib.pyplot as plt


# This function reads in the data from output files, calculates the average time for the function, then graphs all times together
def data_calculations():
    # parse the times from reg data file and calculate the average time
    reg_data = open('end_data\ME_pi400\ME_pi400_RPiOS_lin_times_py.txt', 'r')
    Lines = reg_data.readlines()
    entries = 0
    time = 0
    # Strips the newline character
    for line in Lines:
        entries += 1
        time += float(line.strip())
    reg_avg = round(time/entries, 3)
    reg_data.close()

    # parse the times from thread data file and calculate the average time
    thread_data = open('end_data\ME_pi400\ME_pi400_RPiOS_thread_times_py.txt', 'r')
    Lines = thread_data.readlines()
    entries = 0
    time = 0
    # Strips the newline character
    for line in Lines:
        entries += 1
        time += float(line.strip())
    thread_avg = round(time/entries, 3)
    thread_data.close()       

    # parse the times from multiprocessing data file and calculate the average time
    multi_data = open('end_data\ME_pi400\ME_pi400_RPiOS_Multi_times_py.txt', 'r')
    Lines = multi_data.readlines()
    entries = 0
    time = 0
    # Strips the newline character
    for line in Lines:
        entries += 1
        time += float(line.strip())
    multi_avg = round(time/entries, 3)
    multi_data.close()


    # creating the dataset
    run_type = ("linear", "Threaded", "multi-processing")
    times = (reg_avg, thread_avg, multi_avg)
    
    
    # creating the bar plot
    
    plt.bar(run_type, times)

    # add labels to top of each bar in graph
    for i in range(len(run_type)):
        plt.text(i, times[i], times[i], ha = 'center')
    
    plt.xlabel("Process used to generate numbers")
    plt.ylabel("Time in seconds")
    plt.title("Device 5 Python times")
    plt.ylim([0, 60])
    plt.savefig('Final_py_ME_pi400.png')
    #plt.show()

if __name__ == '__main__':
    data_calculations()