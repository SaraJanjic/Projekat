<template>
    <div>
      <h2>Recenzije</h2>
      <ul>
        <li v-for="recenzija in recenzije" :key="recenzija.id">
          <h3>{{ recenzija.ocena }}</h3>
          <p>Tekst: {{ recenzija.tekst }}</p>
          <p>Datum: {{ recenzija.datumRecenzije }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        recenzije: []
      };
    },
    mounted() {
      this.fetchRecenzije();
    },
    methods: {
      fetchRecenzije() {
        axios.get('/api/recenzije')
          .then(response => {
            this.recenzije = response.data;
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>
  
  <style>
.recenzije-list {
  list-style: none;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.recenzija {
  width: 250px;
  margin-bottom: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
}

.recenzija-info {
  margin-bottom: 10px;
}

.recenzija-ocena {
  font-size: 18px;
  font-weight: bold;
}

.recenzija-tekst {
  font-size: 14px;
  color: #666;
}

.knjiga-datumRecenzije {
  font-size: 14px;
  color: #666;
}

</style>
  