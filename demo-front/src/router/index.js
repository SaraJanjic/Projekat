import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import DashboardView from '../views/DashboardView.vue';
import KorisnikForm from '../components/KorisnikForm.vue';
import KnjigaPoNaslovu from '../components/KnjigaPoNaslovu.vue';
import RegistrationForm from '../components/RegistrationForm.vue';
import LoginForm from '../components/LoginForm.vue';
import ZahtevComponent from '/components/ZahtevComponent';
import SearchBar from '/views/SearchBar'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/kreiraj-zahtev',
    name: 'kreirajZahtev',
    component: ZahtevComponent
  },
  {
    path: '/traziKnjiguPoId',
    name: 'traziKnjiguPoId',
    component: SearchBar
  },
  {
    path: '/zahtevi-za-aktivaciju/:zahtevId/prihvati',
    name: 'PrihvatiZahtev',
    component: ZahtevAktivacija
  },
  {
    path: '/zahtevi-za-aktivaciju/:zahtevId/odbij',
    name: 'OdbijZahtev',
    component: ZahtevAktivacija
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: DashboardView
  },
  {
    path: '/korisnici',
    name: 'korisnici',
    component: KorisnikForm
  },
  {
    path:' /traziKnjiguPoNaslovu/:naslov',
    name: 'traziKnjiguPoNaslovu',
    component: KnjigaPoNaslovu
  },
  {
    path: '/register',
    name: 'Registration',
    component: RegistrationForm
  },
  {
    path: '/login',
    name: 'login',
    component: LoginForm
  },
  {
    path: '/profil-admina',
    name: 'ProfilAdmina',
    component: ProfilAdmina
  },
  {
    path: '/profil-autora',
    name: 'ProfilAutora',
    component: ProfilAutora
  },
  {
    path: '/profil-citaoca',
    name: 'ProfilCitaoca',
    component: ProfilCitaoca
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
