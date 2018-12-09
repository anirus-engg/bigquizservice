from pymongo import MongoClient
from pprint import pprint
import csv
import os


client = MongoClient("mongodb+srv://bigquiz_dbo:bigquiz123@cluster0-rfvr0.mongodb.net/test?retryWrites=true")
db=client.admin

serverStatusResult=db.command("serverStatus")
# pprint(serverStatusResult)

db=client.bigquiz

# pprint(os.getcwd())
with open('script/bigquiz.csv') as csvfile:
        readCsv = csv.reader(csvfile, delimiter=",")
        
        for row in readCsv:
                if row[0] == 'Y':
                        question = { }
                        question["questionId"] = int(row[1])
                        question["subject"] = row[2]
                        question["question"] = row[3]
                        question["difficulty"] = row[11]
                        question["percentage"] = float(row[12])
                        answers = [row[4]]
                        if row[5] != "":
                                answers.append(row[5])
                        if row[6] != "":
                                answers.append(row[6])
                        if row[7] != "":
                                answers.append(row[7])
                        question["answers"] = answers
                        incorrect = [row[8], row[9], row[10]]
                        question["incorrect"] = incorrect
                        rv = db.question.insert_one(question).inserted_id
                        pprint(rv)
