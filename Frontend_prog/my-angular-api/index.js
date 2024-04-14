const express = require('express');
const cors = require('cors');
const fs = require('fs'); 
const app = express();
const PORT = 3001;

app.use(cors());
app.use(express.json());

const Kolcsonzok = require('./kolcsonzok.json');
const Kolcsonzesek = require('./kolcsonzesek.json');

app.get('/api/Kolcsonzesek', (req, res) => {
    res.status(200).json(Kolcsonzesek);
  });
  
  function updateJsonFile() {
    fs.writeFileSync('kolcsonzesek.json', JSON.stringify(Kolcsonzesek, null, 2), 'utf8');
  }
  app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
  });
  