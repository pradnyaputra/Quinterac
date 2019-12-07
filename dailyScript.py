import os
import subprocess
import sys
import time
import random

merged_tsf = open("mergedTransactionSummaryFile.txt", "a+")

def merge_tsf_files(final):
    """Combine the transaction summary file generated for the session with all others from the same day

    :param final: True if this is the last session of a day, False otherwise
    :return: None
    """
    tsf_file = open("transactionSummaryFile.txt", "r")
    contents = tsf_file.read()
    merged_tsf.write(contents)
    if final:
        merged_tsf.write("EOS")


def get_random_command():
    """Using a list of commands, return a random item from the list

    :return: A command for the front end
    """
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


def get_random_sequence(length):
    """Generate and format a string of random commands

    :param length: The number of commands that should be generated
    :return: A formatted list with (length) commands
    """
    string = "login\nagent\n"
    for y in range(length):
        string += get_random_command()
    string += "logout"
    return string


def first_day():
    """The first day should only create accounts

    :return: None
    """

    # Clear the merged tsf file from last session
    merged_tsf.truncate(0)
    print("--- Day 1 ---")
    # Compile the java files so they can be run from command line
    subprocess.run("javac src/main/java/*.java")

    print("Ran session 1 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n1234566\narmin\ncreateacct\n1234567\ngod\nlogout", text=True)
    merge_tsf_files(False)

    print("Ran session 2 automatically")
    subprocess.run("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt",
                   input="login\nagent\ncreateacct\n7654321\nblueface\nlogout", text=True)
    merge_tsf_files(False)

    print("Ran session 3 manually")
    subprocess.check_call("java -cp src/main/java FrontEnd validAccountList.txt transactionSummaryFile.txt")
    merge_tsf_files(True)  # call this after every logout

    # Close the file to ensure writer is flushed to disk
    merged_tsf.close()

    print("Ran backend for day")
    subprocess.check_call("java -cp src/main/java BackEnd oldMasterAccounts.txt mergedTransactionSummaryFile.txt")


def other_days():
    """All other days of the week should have random command input to the program

    :return: None
    """
    
    # Clear the merged tsf file from last session
    merged_tsf.truncate(0)
    print("--- Day " + sys.argv[1] + " ---")

    print("Ran session 1 automatically")
    set_of_commands = get_random_sequence(random.randint(1, 10))
    subprocess.run("java -cp src/main/java FrontEnd newValidAccList.txt transactionSummaryFile.txt",
                   input=set_of_commands, text=True)
    merge_tsf_files(False)

    print("Ran session 2 automatically")
    set_of_commands = get_random_sequence(random.randint(1, 10))
    subprocess.run("java -cp src/main/java FrontEnd newValidAccList.txt transactionSummaryFile.txt",
                   input=set_of_commands, text=True)
    merge_tsf_files(False)

    print("Ran session 3 manually")
    subprocess.check_call("java -cp src/main/java FrontEnd newValidAccountList.txt transactionSummaryFile.txt")
    merge_tsf_files(True)

    merged_tsf.close()

    print("Ran backend for day")
    subprocess.check_call("java -cp src/main/java BackEnd NewMasterAccountsFile.txt mergedTransactionSummaryFile.txt")


if len(sys.argv) >= 2:
    if sys.argv[1] == "1":
        # it is the first day
        first_day()
    else:
        other_days()
else:
    print("Script malfunction, specify day")






