require('dotenv').config()
const { Pool } = require('pg')
const formatter = require('pg-format')

/*
    %% outputs a literal % character.
    %I outputs an escaped SQL identifier.
    %L outputs an escaped SQL literal.
    %s outputs a simple string.
*/

const string = formatter('select * from %I', 'users');
console.log(string);


const pool = new Pool({
  user: process.env.DBUSER,
  host: process.env.DBHOST,
  database: process.env.DBDATABASE,
  password: process.env.DBPASSWORD,
  port: process.env.DBPORT
})
pool.end();
