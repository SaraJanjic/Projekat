import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import RegistrationForm from './views/RegistrationForm.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
      { path: '/registration', component: RegistrationForm },
      // Add more routes as needed
    ],
  });

const app = createApp(App);
app.config.globalProperties.$axios = axios;
// Use the router instance in your app
app.use(router);
app.mount('#app');


