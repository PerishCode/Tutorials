import { h } from 'vue'
import { Input } from '@/components'
import { __render__ } from './symbols'

export default function App(props: any) {
  const { [__render__]: renderList } = props

  return {
    components: {
      // 'x-input': Input,
      'x-input': renderList[0],
    },

    setup() {
      return () => {
        console.log('rendering')

        return h('input', {
          value: '123',
        })
      }
    },
  }
}
