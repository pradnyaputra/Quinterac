import os
import subprocess
import sys

mergedTsf = open("mergedTransactionSummaryFile.txt", "w+")

def mergedTsfFiles():
    tsfFile = open("../../../transactionSummaryFile.txt", "r")
    contents = tsfFile.read()
    mergedTsf.write(contents)


# os.system("./main/java/FrontEnd")

# subprocess.check_call("dir")

# print(os.path.realpath("../../../" + __file__))



subprocess.run("javac FrontEnd.java")

# subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")
subprocess.run("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt", input="login\nagent\ncreateacct\n9999999\ncoo\nlogout", text=True)

# sys.stdin.write("login")

# sys.stdin = "login"




print("after run before merge")

mergedTsfFiles() #call this after every logout

print("after merge")

subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

mergedTsfFiles() #call this after every logout

subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

mergedTsfFiles() #call this after every logout

subprocess.run("javac BackEnd.java")
subprocess.run("java BackEnd ../../../oldMasterAccounts.txt ../../../mergedTransactionSummaryFile.txt")