const vuln1 = () => {
    const formData = new FormData();

    formData.append('username', 'abc123');
    fetch('http://example.com/profile/', {
        method: 'PUT',
        body: formData
    }).then((response) => response.json()).then((result) => {
        console.log('Success:', result);
    }).catch((error) => {
        console.error('Error:', error);
    });
}

const not_vuln1 = () => {
    const formData = new FormData();

    formData.append('username', 'abc123');
    fetch('https://example.com/profile/', {
        method: 'PUT',
        body: formData
    }).then((response) => response.json()).then((result) => {
        console.log('Success:', result);
    }).catch((error) => {
        console.error('Error:', error);
    });
}