"use strict";

var rhea = require("rhea");

var conn_url = "test";

var container = rhea.create_container();

var opts = {
    host: conn_url,
    port: conn_url ,
    // To connect with a user and password:
    // username: "<username>",
    // password: "<password>",
};

var conn = container.connect(opts);

conn.open_receiver(address); //result

conn.open_sender(address); //result


