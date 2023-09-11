async function postData(url = '') {
    await fetch(url, {
        method: 'POST',
        body: JSON.stringify(REQUEST.query.data)  // OUTPUT
    });
}

async function postMoreData(url = '') {
    const formData = new FormData();
    formData.append('username', 'abc123');  // OUTPUT
    await fetch(url, {
        method: 'POST',
        body: formData
    });
}

async function postEvenMoreData(url = '') {
    const myRequest = new Request(url, {
        method: 'PUT',
        body: JSON.stringify(REQUEST.query.data)  // OUTPUT
    });
    await fetch(myRequest);
}


const postDataSO = async () => {
    const rawResponse = await fetch('http://anything.com', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ a: 1, b: 'some content' })
    });
    const content = await rawResponse.json();

    console.log(content);
}