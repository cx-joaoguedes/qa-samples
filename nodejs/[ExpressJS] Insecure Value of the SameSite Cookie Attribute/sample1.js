const express = require('express');
const app = express();

app.use(express.json());

app.get('/1', (req, res) => {
    res.cookie('user_id', '12345', { sameSite: 'Strict' });
    res.send('Cookie set with SameSite=Strict');
});

app.get('/2', (req, res) => {
    res.cookie('session_id', '67890', { sameSite: 'Lax' });
    res.send('Cookie set with SameSite=Lax');
});

app.get('/3', (req, res) => {
    res.cookie('token', 'abcdef', { sameSite: 'None', secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});

app.get('/4', (req, res) => {
    res.cookie('token', 'abcdef', { sameSite: none, secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});

app.get('/5', (req, res) => {
    const cookie_state = 'None'
    res.cookie('token', 'abcdef', { sameSite: cookie_state, secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});

app.get('/6', (req, res) => {
    const cookie_state = none
    res.cookie('token', 'abcdef', { sameSite: cookie_state, secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});

app.get('/7', (req, res) => {
    const cookie_state = 'none'
    res.cookie('token', 'abcdef', { sameSite: cookie_state, secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});

app.get('/8', (req, res) => {
    res.cookie('token', 'abcdef', { sameSite: 'none', secure: true }); // result
    res.send('Cookie set with SameSite=None and secure flag');
});
app.listen(3000, () => {
    console.log('Server started on port 3000');
});
