// import { add } from "./utils"

// console.log(add(1, 2), add(3, 4))

import { createServer } from "vite"

async function process() {
  const server = await createServer({
    configFile: false,
    root: __dirname,
    server: {
      port: 2200,
    },
  })
}
