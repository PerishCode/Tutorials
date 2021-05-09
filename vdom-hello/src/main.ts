import {
  reactive,
  observe,
  unobserve,
  wrapFunctionAsDependency,
} from '@/modules/reactive'

const source = reactive({
  a: 1,
  b: [3, 4, 5],
  c: [1, 2, 3, 4, 5, 6],
})
