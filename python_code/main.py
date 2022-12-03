# Thomas Kyte
# senior seminar

"""
main file is used to call linear and threaded data generators

TO ADD:
MEMORY USAGE FUNCTIONS
DATA FORMATTING CODE TO SUMMARIZE RESULTS FROM DATA GENERATION METHODS
"""

# import functions from helper files
from lin_data import lin_data
from thread_data import thread_data
from multi_data import multi_data
# for wait statement
import time


if __name__ == '__main__':
    # active seed for testing
    # IMPORTANT RUN WITH AT LEAST 2 SEEDS AS THAT IMPACTS PERFORMANCE
    seed = 59617645
    # how many random numbers to generate each time
    size = 10000000
    # range of random numbers to generate is 0 to (prng_r-1)
    prng_r = 501
    # number of times to run PRNG
    loop = 50
    # strings to hold times
    lin_times = ''
    thread_times = ''
    multi_times = ''

  
#######################################################################################################################
    # generate times for a set number of runs of each method
    for x in range (loop):
        print(f'running loop: {x+1}')
        # call non-threaded function get the time to generate 1000000 numbers in 4 different methods
        time_process = lin_data(seed, size, prng_r)
        lin_times = lin_times + time_process + "\n"

        # call threaded function get the time to generate 1000000 numbers in 4 different methods
        time_process = thread_data(seed, size, prng_r)
        thread_times = thread_times + time_process + "\n"

        # call the multi-processing function to get the time it takes to run
        time_process = multi_data(seed, size, prng_r)
        multi_times = multi_times + time_process + "\n"

    output = open('TK_laptop_lin_times_py.txt', 'a')
    output.write(lin_times)
    output.close()

    output = open('TK_laptop_thread_times_py.txt', 'a')
    output.write(thread_times)
    output.close()

    output = open('TK_laptop_multi_times_py.txt', 'a')
    output.write(multi_times)
    output.close()
