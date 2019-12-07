import subprocess
import time

# Monday
subprocess.run("python dailyScript.py 1")

time.sleep(30)
# Tuesday
subprocess.run("python dailyScript.py 2")
time.sleep(30)
# Wednesday
subprocess.run("python dailyScript.py 3")
time.sleep(30)
# Thursday
subprocess.run("python dailyScript.py 4")
time.sleep(30)
# Friday
subprocess.run("python dailyScript.py 5")

