<template>
  <div>
    <h2>Pretraga knjige po naslovu</h2>
    <div>
      <label for="uNaslova" class="label">Unesite naslov knjige</label>
      <input type="text" id="uNaslova" v-model="uNaslova" required>
      <button @click="pretrazi">Pretrazi</button>
    </div>
    <div v-if="pretragaIzvrsena">
      <h4>Rezultati pretrage</h4>
      <table>
        <thead>
          <tr>
            <th>ISBN</th>
            <th>Naslov</th>
            <th>Broj strana</th>
            <th>Opis</th>
            <th>Ocena</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="knjiga in knjige" :key="knjiga.isbn">
            <td>{{ knjiga.isbn }}</td>
            <td>{{ knjiga.naslov }}</td>
            <td>{{ knjiga.brojStrana }}</td>
            <td>{{ knjiga.opis }}</td>
            <td>{{ knjiga.ocena }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'KnjigaPoNaslovuView', 
  data() {
    return {
      uNaslova: '',
      knjige: [],
      pretragaIzvrsena: false
    };
  },
  methods: {
    pretrazi() {
      const naslov = encodeURIComponent(this.uNaslova);
      const url = `/traziKnjiguPoNaslovu/${naslov}`;

      fetch(url)
        .then(response => {
          if (!response.ok) {
            console.error("Greska u pretrazi knjiga", response.status, response);
            throw new Error("Greska u pretrazi knjiga");
          }
          return response.json();
        })
        .then(data => {
          if (Array.isArray(data)) {
            this.knjige = data;
          } else {
            this.knjige = [data];
          }
          this.pretragaIzvrsena = true;
        })
        .catch(error => {
          console.error("Error", error);
          this.pretragaIzvrsena = true;
        });
    }
  }
};
</script>
  
  
  <style>
.knjiga-list {
  list-style: none;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.knjiga {
  width: 250px;
  margin-bottom: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f7f7f7;
}

.knjiga-info {
  margin-bottom: 10px;
}

.knjiga-naslov {
  font-size: 18px;
  font-weight: bold;
}

.knjiga-autor {
  font-size: 14px;
  color: #666;
}

.knjiga-zanr {
  font-size: 14px;
  color: #666;
}

.knjiga-opis {
  font-size: 14px;
  color: #666;
}

.knjiga-datumObjavljivanja {
  font-size: 14px;
  color: #666;
}

.knjiga-brStrana {
  font-size: 14px;
  color: #666;
}

.book-naslovnaSlika {
  width: 100%;
  height: auto;
  margin-top: 10px;
}
</style>
  