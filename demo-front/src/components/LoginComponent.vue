<template>
    <div>
      <h2>Login</h2>
      <form @submit.prevent="login">
        <label for="email">Email:</label>
        <input type="text" id="email" v-model="email">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password">
        <br>
        <button type="submit">Login</button>
    </form>
  </div>
</template>
    
 
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        email: '',
        password: '',
      };
    },
    methods: {
      login() {
      const loginData = {
        email: this.email,
        password: this.password,
      };
      axios.post('http://localhost:8080/api/login', loginData)
        .then(response => {
          // Handle successful login
          const user = response.data;
          localStorage.setItem('user', JSON.stringify(user));
          this.$emit('loginPrijava');
        })
        .catch(error => {
          console.error('Error:', error);
          alert("greska");
          // Handle login error
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
  