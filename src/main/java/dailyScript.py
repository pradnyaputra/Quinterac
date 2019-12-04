import os
import subprocess

global mergedTsf
mergedTsf = open("mergedTransactionSummaryFile.txt", "w+")

# os.system("./main/java/FrontEnd")

# subprocess.check_call("dir")

print(os.path.realpath(__file__))

subprocess.check_call("java FrontEnd ../validAccountList.txt ../transactionSummaryFile.txt")

def mergedTsfFiles():
    tsfFile = open("transactionSummaryFile.txt", "r")
    contents = tsfFile.read()
    mergedTsf.write(contents)

mergedTsfFiles() #call this after every logout
