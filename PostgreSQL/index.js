require('dotenv').config()
const { Pool } = require('pg')
const formatter = require('pg-format')


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
