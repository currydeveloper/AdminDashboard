import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import 'primevue/resources/primevue.min.css'
import 'primevue/resources/themes/lara-light-indigo/theme.css'
import 'primeicons/primeicons.css'
import Panel from 'primevue/panel'
import Dropdown from 'primevue/dropdown'

const app = createApp(App)
app.use(PrimeVue)
app.component('Panel', Panel)
app.component('Dropdown', Dropdown)
app.mount('#app')
