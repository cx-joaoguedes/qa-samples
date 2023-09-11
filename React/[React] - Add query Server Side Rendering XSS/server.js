const express = require('express');
const ReactDOM = require('react-dom');
const app = express();
const React = require('react')
const ReactDOMServer = require('react-dom/server')



//=======================
//      Sanitizers
//=======================
const createDOMPurify = require('dompurify');
const { JSDOM } = require('jsdom');

const window = new JSDOM('').window;
const DOMPurify = createDOMPurify(window);

//   END OF Sanitizers
//=======================




let body = React.createFactory("body");
let script = React.createFactory("script");

app.get('/', async function(req, res) {

  //=========================================================================================
  //---------------------------------- I M P O R T A N T ------------------------------------
  //=========================================================================================
  //If userInput is not in legitimate JSON format, lines 67, 69, 70 and 87 will cause some errors
  //so I put those lines in comment to eliminates the errors.
  //A valid JSON payload is available at line 44 when needed.
  //=========================================================================================

  let userInput = req.query.param;
  
  

    //---------------------------------------------------
  //POPULATING dangerouslySetInnerHTML with user input
  //---------------------------------------------------
  //sample payload: <script>alert('vulnerable!');</script>
  let vuln_div_element = React.createElement('div', { dangerouslySetInnerHTML : { __html : userInput }})
  //let error_div_element = React.createElement('div', { dangerouslySetInnerHTML : { __html : userInput }}, "This content eliminates XSS because error is thrown")
  /* MITIGATION: */ //let div_element = React.createElement('div', { dangerouslySetInnerHTML : { __html : DOMPurify.sanitize(userInput) }})
  

  //---------------------
  //JS LINKS & IFRAMES
  //---------------------
  //possible payloed: userInput = 'javascript:alert("vulnerable!");'
  let a_href_element = React.createElement('a', { href: userInput }, 'click here')
  let iframe_element = React.createElement('iframe', {src: userInput})

  //script element src attribute can be controlled.
  //sample payload: userInput = https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js
  //NOTE: the script element is not vulnerable through the third parameter  
  let script_element = React.createElement('script', { src : userInput}, 'alert("this param is encoded");');

  //--------------------------
  //Takeover props object - UNCOMMENT LINES 47,48, and 63!
  //--------------------------
  //potential payload:
  //{"id":"content","dangerouslySetInnerHTML":{"__html":"<script>alert('vulnerable!');</script>"}}
  //let parsedUserInput = JSON.parse(userInput);
  /* MITIGATION: */ //let parsedUserInput =  JSON.parse(DOMPurify.sanitize(userInput));
  //let takeoverProps = React.createElement("div", parsedUserInput);
  //let error_takeoverProps = React.createElement("div", parsedUserInput, "some content");

  //Done initiating all vulnerable elements;
  //----------------------------------------



  //-----------------------------------------------
  //Render the vulnerable elements through server:
  let html = ReactDOMServer.renderToStaticMarkup(body(null,

    vuln_div_element,
    //error_div_element,
    //The safe sample will throw an exception.

    a_href_element,
    iframe_element,
    script_element,
    //takeoverProps,
    //error_takeoverProps,

    script({src: 'https://cdn.jsdelivr.net/npm/react@16.13.1/umd/react.production.min.js'}),
    script({src: 'https://cdn.jsdelivr.net/npm/react-dom@16.13.1/umd/react-dom.production.min.js'}),
    script({src: 'https://cdn.jsdelivr.net/npm/create-react-class@15.6.3/create-react-class.min.js'}),
  ))

  res.end(html)
});


let server = app.listen(3000, function() {
    console.log('Server is listening on port 3000')
});

function deserialize(serializedJavascript){
  serializedJavascript = serialize(serializedJavascript, {isJSON: true});
  return eval('(' + serializedJavascript + ')');
}