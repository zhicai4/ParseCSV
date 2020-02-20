# ParseCSV

ParseCSV parses a CSV file and seperates valid from invalid entries. Invalid entries are written to a seperate CSV file while valid files are written into a database. An invalid entry is an entry with missing columns while a valid entry has no missing columns.

## Getting Started

Download ParseCSV.jar and run java -jar ParseCSV.jar

### Prerequisites

Requires SQLITE-JDBC

####Misc

Currently uses Data.csv as the input file and Data-bad.csv as the output for invalid files.
Valid entries are currently written to Data.db located in C:/sqlite directory.







