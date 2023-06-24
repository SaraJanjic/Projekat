<template>
  <div>
    <h2>Zahtev</h2>
    <form @submit="submitForm">

      <input type="email" v-model="email" placeholder="Email" required>

      <input type="tel" v-model="brojTelefona" placeholder="Broj telefona" required>

      <input type="text" v-model="dodatnaPoruka" placeholder="Dodatna poruka" required>

      <input type="text" v-model="ime" placeholder="Ime" required>

      <input type="text" v-model="prezime" placeholder="Prezime" required>

      <button type="submit">Posalji zahtev</button>

    </form>

    <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>

  </div>

</template>

 

<script>

import axios from 'axios';

 

export default {

  data() {

    return {

      email: '',

      brojTelefona: '',

      dodatnaPoruka: '',

      ime: '',

      prezime: ''

    };

  },

  methods: {

    submitForm(event) {

      event.preventDefault();
      
      axios.post('/kreiraj-zahtev', {

        email: this.email,

        brojTelefona:this.brojTelefona,

        dodatnaPoruka:this.dodatnaPoruka,

        ime:this.ime,

        prezime:this.prezime

      })

       

      .then(response => {

          console.log('Zahtev uspesan!', response.data);
          
          })

      .catch(error => {

        console.error(error);

        this.errorMessage = 'Nisu dobri podaci za zahtev';

      });

    }

  }

};

</script>

 

<style>

.login-container {

max-width: 400px;

margin: 0 auto;

padding: 20px;

border: 1px solid #ccc;

border-radius: 4px;

}

 

.login-form {

display: flex;

flex-direction: column;

margin-bottom: 20px;

}

 

.login-form input {

padding: 10px;

margin-bottom: 10px;

}

 

.login-form button {

padding: 10px 20px;

background-color: #337ab7;

color: #fff;

border: none;

cursor: pointer;

}

 

.error-message {

color: red;

}

</style>