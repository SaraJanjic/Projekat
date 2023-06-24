<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>

      Pronadjite, citajte i ocenite knjige!<br>
      <button @click="handleButtonClick">Registruj se</button>
      <button @click="handleZahtevButton">Posalji Zahtev</button>
      <button @click="showKnjige = true">Pregled Knjiga</button>
      <button @click="showZanrovi = true">Pregled Zanrova</button>
      <button @click="showRecenzije = true">Pregled Recenzija</button>
      <button @click="showStavke = true">Pregled stavki</button>
      <button @click="showKorisnici = true">Pregled Korisnika</button>
     </p>

     <div v-if="showKnjige">
      <h2>Knjige</h2>
      <ul v-if="knjige.length > 0">
        <li v-for="knjiga in knjige" :key="knjiga.id">
          {{ knjiga.naslov }}
        </li>
      </ul>
      <p v-else>No books found.</p>
    </div>

    <div v-if="showZanrovi">
      <h2>Zanrovi</h2>
      <ul v-if="zanrovi.length > 0">
        <li v-for="zanr in zanrovi" :key="zanr.id">
          {{ zanr.nazivZanra }}
        </li>
      </ul>
      <p v-else>No genres found.</p>
    </div>

    <div v-if="showRecenzije">
          <h2>Recenzije</h2>
          <ul v-if="recenzije.length > 0">
            <li v-for="recenzija in recenzije" :key="recenzija.id">
              {{ recenzija.tekst }}
            </li>
          </ul>
          <p v-else>No reviews found.</p>
        </div>

    <div v-if="showStavke">
      <h2>Stavke</h2>
      <ul v-if="stavke.length > 0">
        <li v-for="stavka in stavke" :key="stavka.id">
          <strong>Knjiga:</strong> {{ stavka.knjiga.naslov }}<br>
          <strong>Recenzija:</strong> {{ stavka.recenzija.ocena }} - {{ stavka.recenzija.tekst }}
        </li>
      </ul>
      <p v-else>No items found.</p>
    </div>

    <div v-if="showKorisnici">
      <h2>Korisnici</h2>
      <ul v-if="korisnici.length > 0">
        <li v-for="korisnik in korisnici" :key="korisnik.id">
          <h3>{{ korisnik.ime }} {{ korisnik.prezime }}</h3>
          <h4>Police:</h4>
          <ul>
            <li v-for="polica in korisnik.korisnickePolice" :key="polica.id">
              {{ polica.naziv }}
                <h5>Stavka:</h5>
                  <ul>
                    <li v-for="stavka in polica.stavke" :key="stavka.id">
                      <strong>Knjiga:</strong> {{ stavka.knjiga.naslov }}<br>
                      <strong>Recenzija:</strong> {{ stavka.recenzija.ocena }} - {{ stavka.recenzija.tekst }}
                    </li>
                  </ul>
            </li>
          </ul>
        </li>
      </ul>
</div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      knjige: [],
      zanrovi: [],
      recenzije : [],
      stavke: [],
      korisnici: [],
      showKnjige: false,
      showZanrovi: false,
      showRecenzije: false,
      showStavke: false,
      showKorisnici: false
    };
  },
  mounted() {
    this.fetchKnjige();
    this.fetchZanrovi();
    this.fetchRecenzije();
    this.fetchStavke();
    this.fetchKorisnici();
  },
  methods: {
    handleButtonClick() {
      
      this.$router.push('/registration');
      console.log('Registration button clicked!');
  
      // Make an HTTP POST request to the registration endpoint
      axios.post('/api/register', 'api/search', {
        
        email: 'example@example.com',
        password: 'password123',
        query: 'query'
      })
      .then(response => {
       
        console.log('Registration successful!', response.data);
        const searchResults = response.data;
        console.log('Search results:', searchResults);
        
      })
      .catch(error => {
       
        console.error('Registration failed!', error);
        console.error('Search failed!', error);      
       });
    },
    handleZahtevButton() {

this.$router.push('/zahtev');

console.log('Zahtev button clicked!');



axios.post('/kreiraj-zahtev', {

email: this.email,

brojTelefona: this.brojTelefona,

dodatnaPoruka: this.dodatnaPoruka

})

.then(response => {

console.log('Uspešno poslat zahtev!', response.data);

this.$router.push('/zahtev');

})

.catch(error => {

console.error('Greška pri obradi zahteva:', error);

});

},

    fetchKnjige() {
      axios.get('http://localhost:8080/api/knjige')
        .then(response => {
          this.knjige = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch books:', error);
        });
    },
    fetchZanrovi() {
      axios.get('http://localhost:8080/api/zanrovi')
        .then(response => {
          this.zanrovi = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch genres:', error);
        });
      },
    fetchRecenzije() {
      axios.get('http://localhost:8080/api/recenzije')
        .then(response => {
          this.recenzije = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch reviews:', error);
        });
    },
    fetchStavke() {
      axios.get('http://localhost:8080/api/stavke')
        .then(response => {
          this.stavke = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch reviews:', error);
        });
    },

    fetchKorisnici(){
      axios.get('http://localhost:8080/api/korisnik')
        .then(response => {
          this.korisnici = response.data;
        })
        .catch(error => {
          console.error('Failed to fetch users:', error);
        });
    }
  }
}
;
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}


.category {
  padding: 10px 20px;
  margin-right: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.category:hover {
  background-color: #379e70;
}


</style>
