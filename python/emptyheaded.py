import json
import codegenerator.createDB
import codegenerator.env
import codegenerator.fetchRelation

environment = codegenerator.env.Environment()

def createDB(name):
	codegenerator.createDB.fromJSON(name,environment)
	#environment.dump()

def fetchData(relation):
	codegenerator.fetchRelation.fetch(relation,environment)

def saveDB():
	environment.toJSON(environment.config["database"]+"/config.json")

def loadDB(path):
	environment.fromJSON(path)

def main():
	#db_config="/Users/caberger/Documents/Research/data/databases/higgs/config_pruned.json"
	#db_config="/Users/caberger/Documents/Research/data/databases/simple/config.json"
	#createDB(db_config)
	loadDB("/Users/caberger/Documents/Research/data/databases/simple/db/config.json")
	fetchData("R")
	com="""
	compileQuery("query1")
 	q1 = loadQuery("query1")
 	q1_result = q1.run()
 	print q1.num_rows(q1_result)
 	q1.fetch_data(q1_result)
 	"""


if __name__ == "__main__": main()