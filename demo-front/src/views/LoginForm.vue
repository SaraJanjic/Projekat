<template>
    <div>
      <h2>Login</h2>
      <form @submit="submitForm">
        <input type="email" v-model="email" placeholder="Email" required>
        <input type="password" v-model="password" placeholder="Password" required>
        <button type="submit">Login</button>
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
        password: ''
      };
    },
    methods: {
      submitForm(event) {
        event.preventDefault();
  
        axios.post('/api/login', {
          email: this.email,
          password: this.password
        })
        .then(() => {
            this.$router.push('/dashboard/'); //trebalo bi da odvede korisnika na personalizovanu stranicu +korsinikId je pisalo

        })
        .catch(error => {
          console.error(error);
          this.errorMessage = 'Invalid username or password';
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
  
