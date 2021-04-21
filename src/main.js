import { createApp } from 'vue'
import App from './App.vue'
import 'primeflex/primeflex.css' 
import 'primevue/resources/themes/saga-blue/theme.css'      //theme
import 'primevue/resources/primevue.min.css'                 //core css
import 'primeicons/primeicons.css'                           //icons
import PrimeVue from 'primevue/config';
import Button from 'primevue/button';
import VueClipboard from 'vue3-clipboard'

const app = createApp(App);
app.use(PrimeVue);
app.use(VueClipboard, {
    autoSetContainer: true,
    appendToBody: true,
})
app.component('Button', Button);

app.mount('#app')
