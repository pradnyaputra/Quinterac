import os
import subprocess
import sys

mergedTsf = open("../../../mergedTransactionSummaryFile.txt", "a+")

def mergedTsfFiles():
    tsfFile = open("../../../transactionSummaryFile.txt", "r")
    contents = tsfFile.read()
    print(contents)
    mergedTsf.write(contents)

def first_day():
    print("--- Day 1 ---")
    subprocess.run("javac FrontEnd.java")

    print("Ran session 1 automatically")
    # subprocess.run("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt",
    #                input="login\nagent\ncreateacct\n9999999\nfoo\nlogout", text=True)
    # mergedTsfFiles()  # call this after every logout

    print("Ran session 2 automatically")
    # subprocess.run("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt",
    #                input="login\nagent\ncreateacct\n7777777\nbar\nlogout", text=True)
    # mergedTsfFiles()  # call this after every logout

    print("Ran session 3 manually")
    subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

    mergedTsfFiles()  # call this after every logout

    print("Ran backend for day")
    subprocess.run("javac BackEnd.java")
    subprocess.run("java BackEnd ../../../oldMasterAccounts.txt ../../../mergedTransactionSummaryFile.txt")


def other_days():
    print("--- Day " + sys.argv[1] + " ---")

    print("Ran session 1 automatically")
    subprocess.run("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt",
                   input="login\nagent\ndeposit\n9999999\n100000\nfoo\nlogout", text=True)
    mergedTsfFiles()  # call this after every logout

    print("Ran session 2 automatically")
    subprocess.run("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt",
                   input="login\nagent\ndeposit\n7777777\n87654321\nbar\nlogout", text=True)

    mergedTsfFiles()  # call this after every logout

    print("Ran session 3 manually")
    subprocess.check_call("java FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

    mergedTsfFiles()  # call this after every logout

    print("Ran backend for day")
    subprocess.run("javac BackEnd.java")
    subprocess.run("java BackEnd ../../../oldMasterAccounts.txt ../../../mergedTransactionSummaryFile.txt")


# Monday (first day)
if len(sys.argv) >= 2:
    if sys.argv[1] == "1":
        # it is the first day
        first_day();
    # else:
        # other_days();
else:
    print("Script malfunction, specify day")
