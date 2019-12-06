import os
import subprocess
import sys
import time
import random

mergedTsf = open("mergedTransactionSummaryFile.txt", "a+")

def mergedTsfFiles(final):
    tsfFile = open("transactionSummaryFile.txt", "r")
    contents = tsfFile.read()
    # print(contents)
    mergedTsf.write(contents)
    if final:
        mergedTsf.write("EOS")

def returnRandomCommand():
    commands = [
    "deposit\n1234567\n900000\n",
    "deposit\n7654321\n550000\n",
    "deposit\n1234566\n1000000\n",
    "deposit\n1234567\n10000\n",
    "deposit\n7654321\n9999\n",
    "createacct\n1234566\narmin\n",
    "createacct\n1234567\ngod\n",
    "createacct\n7654321\nblueface\n",
    "transfer\n1234566\n1234567\n33300\n",
    "transfer\n1234567\n7654321\n66600\n",
    "transfer\n1234566\n7654321\n90000\n",
    "transfer\n7654321\n1234567\n4000\n",
    "transfer\n7654321\n1234566\n8800\n",
    "withdraw\n1234567\n100000\n",
    "withdraw\n7654321\n54321\n",
    "transfer\n1234567\n7654321\n696969\n",
    "deposit\n7654321\n99999\n",
    "createacct\n6969696\nnice\n",
    "deleteacct\n6969699\nnice\n",
    "transfer\n1234567\n6969696\n111111\n",
    "deleteacct\n69\ngeazy\n",
    "createacct\n6969696\ngeazy\n",
    "deposit\n1234567\n50000\n",
    "deposit\n6969696\n999999\n",
    "createacct\n6955569\npleaseGiveUsS\n",
    "withdraw\n6969696\n500\n",
    "deposit\n7654321\n1111111\n",
    "withdraw\n7654321\n50000\n",
    "withdraw\n1234567\n50000\n"
    ]

    return random.choice(commands)


def returnRandomSequence(x):
    string = "login\nagent\n"
    for y in range(x):
        string += returnRandomCommand()
    string += "logout"
    return string


def first_day():
    mergedTsf.truncate(0)
    print("--- Day 1 ---")
    #subprocess.run("javac src/main/java/*.java")

    print("Ran session 1 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n1234566\narmin\ncreateacct\n1234567\ngod\nlogout", text=True)
    mergedTsfFiles(False)  # call this after every logout

    print("Ran session 2 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n7654321\nblueface\nlogout", text=True)
    mergedTsfFiles(True)  # call this after every logout
    # subprocess.check_call("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\validAccountList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt")
    # mergedTsfFiles(False)  # call this after every logout


    # print("Ran session 3 manually")
    # subprocess.check_call("java -cp src/main/java FrontEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\validAccountList.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\transactionSummaryFile.txt")
    # mergedTsfFiles(False)  # call this after every logout

    mergedTsf.close()

    print("Ran backend for day")
    # subprocess.run("javac -cp src/main/java BackEnd.java")
    subprocess.check_call("java -cp src/main/java BackEnd oldMasterAccounts.txt mergedTransactionSummaryFile.txt")
    # subprocess.check_call("java -cp src/main/java BackEnd C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\oldMasterAccounts.txt C:\\Users\\Tyler\\Documents\\GitHub\\Quinterac\\mergedTransactionSummaryFile.txt")


def other_days():
    time.sleep(15)
    mergedTsf.truncate(0)
    print("--- Day " + sys.argv[1] + " ---")

    print("Ran session 1 automatically")
    set_of_commands = returnRandomSequence(random.randint(1, 10))
    print(set_of_commands)
    subprocess.run("java -cp src/main/java FrontEnd newValidAccList.txt transactionSummaryFile.txt",
                   input=set_of_commands, text=True)
    mergedTsfFiles(False)  # call this after every logout

    print("Ran session 2 automatically")
    set_of_commands = returnRandomSequence(random.randint(1, 10))
    print(set_of_commands)
    subprocess.run("java -cp src/main/java FrontEnd newValidAccList.txt transactionSummaryFile.txt",
                   input=set_of_commands, text=True)

    # mergedTsfFiles(False)  # call this after every logout

    # print("Ran session 3 manually")
    # subprocess.check_call("java -cp src/java/main FrontEnd ../../../validAccountList.txt ../../../transactionSummaryFile.txt")

    # if sys.argv[1] == "5":
    mergedTsfFiles(True)
    # else:
    #     mergedTsfFiles(False)  # call this after every logout

    mergedTsf.close()

    print("Ran backend for day")
    # subprocess.run("javac BackEnd.java")
    subprocess.check_call("java -cp src/main/java BackEnd NewMasterAccountsFile.txt mergedTransactionSummaryFile.txt")


# Monday (first day)
if len(sys.argv) >= 2:
    if sys.argv[1] == "1":
        # it is the first day
        first_day()
    else:
        other_days()
else:
    print("Script malfunction, specify day")






