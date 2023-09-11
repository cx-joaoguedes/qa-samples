const vuln = async () => {
    const data = {username:'username', password: 'abc123'}
    const rawResponse = await fetch('http://anything.com', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const content = await rawResponse.json();

    console.log(content);
}

const not_vuln = async () => {
    const data = {username:'username', password: 'abc123'}
    const rawResponse = await fetch('https://anything.com', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const content = await rawResponse.json();

    console.log(content);
}