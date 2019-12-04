import os
import subprocess
import sys
import time

mergedTsf = open("C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\mergedTransactionSummaryFile.txt", "a+")

def mergedTsfFiles(final):
    tsfFile = open("C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt", "r")
    contents = tsfFile.read()
    # print(contents)
    mergedTsf.write(contents)
    if final:
        mergedTsf.write("EOS")

def first_day():
    mergedTsf.truncate(0)
    print("--- Day 1 ---")
    # subprocess.run("javac -cp src/main/java FrontEnd.java")

    print("Ran session 1 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n9999999\nfoo\nlogout", text=True)
    mergedTsfFiles(False)  # call this after every logout

    print("Ran session 2 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n7777777\nbar\nlogout", text=True)
    mergedTsfFiles(False)  # call this after every logout
    # subprocess.check_call("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\validAccountList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt")
    # mergedTsfFiles(False)  # call this after every logout


    # print("Ran session 3 manually")
    # subprocess.check_call("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\validAccountList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt")
    # mergedTsfFiles(False)  # call this after every logout

    mergedTsf.close()

    print("Ran backend for day")
    # subprocess.run("javac -cp src/main/java BackEnd.java")
    subprocess.check_call("java -cp src/main/java BackEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\oldMasterAccounts.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\mergedTransactionSummaryFile.txt")
    # subprocess.check_call("java -cp src/main/java BackEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\oldMasterAccounts.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\mergedTransactionSummaryFile.txt")


def other_days():
    mergedTsf.truncate(0)
    print("--- Day " + sys.argv[1] + " ---")

    print("Ran session 1 automatically")
    subprocess.run("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\newValidAccList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt",
                   input="login\nagent\ndeposit\n9999999\n450\nfoo\nlogout", text=True)
    mergedTsfFiles(False)  # call this after every logout

    print("Ran session 2 automatically")
    subprocess.run("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\newValidAccList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt",
                   input="login\nagent\ndeposit\n7777777\n230\nbar\nlogout", text=True)

    mergedTsfFiles(False)  # call this after every logout

    # print("Ran session 3 manually")
    # subprocess.check_call("java -cp src/java/main FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

    if sys.argv[1] == "5":
        mergedTsfFiles(True)
    else:
        mergedTsfFiles(False)  # call this after every logout

    print("Ran backend for day")
    # subprocess.run("javac BackEnd.java")
    subprocess.run("java -cp src/main/java BackEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\newMasterAccountsFile.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\mergedTransactionSummaryFile.txt")


# Monday (first day)
if len(sys.argv) >= 2:
    if sys.argv[1] == "1":
        # it is the first day
        first_day();
    else:
        other_days();
else:
    print("Script malfunction, specify day")
