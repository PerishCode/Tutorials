import {
  reactive,
  observe,
  WeakMapExtension,
  MapExtension,
} from '@/modules/reactive'

type ElementMap = MapExtension<string, HTMLElement>

const reaction2elementMap = new WeakMapExtension<object, ElementMap>()

const source = reactive({
  a: {
    text: 'abc',
  },
})

const app = document.getElementById('app')!

const key = 'a'

observe((operation: any = {}) => {
  const { type } = operation

  const target = source[key]

  console.log(operation)

  switch (type) {
    case 'set': {
      const elementMap = reaction2elementMap.get(source)!
      const element = elementMap.get(key)!
      element.innerHTML = target.text
    }
    case 'delete': {
      const elementMap = reaction2elementMap.get(source)!
      const element = elementMap.get(key)!
      element.remove()
    }

    case 'add':
    case undefined: {
      if (target === undefined) return

      const elementMap = reaction2elementMap.acquire(source, new MapExtension())
      const element = elementMap.acquire(key, document.createElement('div'))

      element.innerHTML = target.text
      app.appendChild(element)
    }
  }
})

globalThis.source = source
