require('dotenv').config()

const { Pool, Client } = require('pg')
const pool = new Pool({
  user: process.env.DBUSER,
  host: process.env.DBHOST,
  database: process.env.DBDATABASE,
  password: process.env.DBPASSWORD,
  port: process.env.DBPORT
})

pool.query("SELECT * FROM users", (err, res) => {
    console.log(res);
})

/*
const client = new Client({
  user: 'postgres',
  host: 'localhost',
  database: 'Project',
  password: 'lawrance',
  port: 5432,
})
client.connect()
client.query('SELECT NOW()', (err, res) => {
  console.log(err, res)
  client.end()
})
*/