/**
 * 1. 所有对象封装为 Proxy
 * 2. 标签/文本和 key 绑定，value 变化时自动触发相应标签/文本的更新
 */

import { reactive } from './reactive'

function basic(model) {
  const { text } = model
  return {
    sel: 'div',
    text,
  }
}

window.onload = () => {
  const model2element = new WeakMap()

  function patch(model) {
    model2element.get(model)
  }

  const app = document.querySelector('#app')

  //   console.log(app)

  console.log(reactive)
}
