import emptyheaded 

class ResultError(Exception):
    pass

def main():
  db_config="$EMPTYHEADED_HOME/examples/graph/data/facebook/config_pruned.json"
  emptyheaded.createDB(db_config)

if __name__ == "__main__": main()