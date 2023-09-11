const fetch = require('node-fetch')

const main = async() => {
    const res = await fetch('https://google.com')
    console.log(res)
}

main()