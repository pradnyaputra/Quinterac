import os
import subprocess

# os.system("./main/java/FrontEnd")

# subprocess.check_call("dir")

# print(os.path.realpath("../../../" + __file__))

subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")
