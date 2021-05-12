import { defineConfig } from 'vite'
import { resolve } from 'path'
import jsx from '@vitejs/plugin-vue-jsx'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [jsx()],
  resolve: {
    alias: {
      '@': resolve('src'),
    },
  },
})
