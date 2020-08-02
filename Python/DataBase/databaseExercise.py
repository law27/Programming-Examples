import sqlite3

conn = sqlite3.connect('emaildb.sqlite')
cur = conn.cursor()

cur.execute('DROP TABLE IF EXISTS Counts')

cur.execute('CREATE TABLE Counts (org TEXT, count INTEGER)')

file = open('mbox.txt')

for i in file:
    if i.startswith('From: '):
        tempArray = i.split("@")
        organization = tempArray[1]
        cur.execute('SELECT count FROM Counts WHERE org=?', (organization,))
        count = cur.fetchone()
        if count is None:
        	cur.execute('INSERT into Counts values(?,1)', (organization,))
        else:
        	cur.execute('UPDATE Counts SET count = count + 1 WHERE org=?', (organization,))

conn.commit()

sqlstr = 'SELECT org,count FROM Counts ORDER BY count'

for row in cur.execute(sqlstr):
	print(str(row[0]) + " " + str(row[1]))

cur.close()