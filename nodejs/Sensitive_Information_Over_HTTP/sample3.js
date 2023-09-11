const axios = require('axios')

const vuln1 = () => {
    data = { username: "username", password: "abc123" }
    axios.post("http://jsonplaceholder.typicode.com/users", data).then((response) => displayOutput(response)).catch((err) => console.log(err));
}

const not_vuln1 = () => {
    data = { username: "username", password: "abc123" }
    axios.post("https://jsonplaceholder.typicode.com/users", data).then((response) => displayOutput(response)).catch((err) => console.log(err));
}