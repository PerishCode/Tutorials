import { createApp } from 'vue'
import App from '@/App'
import { __render__ } from '@/symbols'
import { Input } from '@/components'

createApp(
  App({
    [__render__]: [Input],
  })
).mount('#app')
