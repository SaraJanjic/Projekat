import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import RegistrationComponent from './components/RegistrationComponent.vue';
import LoginComponent from './components/LoginComponent.vue';
import DashboardView from './views/DashboardView.vue';
import TraziKnjiguPoNaslovuView from './views/TraziKnjiguPoNaslovuView.vue';
import ZahtevComponent from './components/ZahtevComponent.vue';
import ProfilAdmina from './views/ProfilAdmina.vue';
import ProfilCitaoca from './views/ProfilCitaoca.vue';
import ProfilAutora from './views/ProfilAutora.vue';
axios.defaults.baseURL = 'http://localhost:8080';


const router = createRouter({
    history: createWebHistory(),
    routes: [
      { path: '/registration', component: RegistrationComponent },
      { path: '/zahtev', component: ZahtevComponent },
      {path: '/login', component: LoginComponent},
      { path: '/dashboard/:korisnikId', component: DashboardView },
      { path: '/search', component: TraziKnjiguPoNaslovuView }, // Dodajte rutu za pretragu knjiga ovde
      { path: '/profil-admina', component:  ProfilAdmina},
      { path: '/profil-citaoca', component: ProfilCitaoca },
      { path: '/profil-autora', component: ProfilAutora },
    ],
  });

const app = createApp(App);
app.config.globalProperties.$axios = axios;

app.use(router);
app.mount('#app');


