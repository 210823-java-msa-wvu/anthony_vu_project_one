function load() {
    let x = JSON.parse(getCookie("userinfo"));
    let y = JSON.parse(x);
    populateData(y);

    let a = JSON.parse(getCookie("message"));
    let b = JSON.parse(a);
    populateMessage(b)   

    
}
function populateData(res) {
     let dataSection = document.getElementById('data');

     let name = document.createElement('h1');
     name.innerHTML = "Hello" + " " + res.firstname + " " + res.lastname;
     dataSection.appendChild(name);

     let benefit = document.createElement('h3');
     benefit.innerHTML = 'Current Possible Benefits: ' + '$' + res.totBenefits;
     dataSection.appendChild(benefit);
}

function populateMessage(res) {
  let dataSection = document.getElementById('message');
  let name = document.createElement('h1');
  name.innerHTML = 'Messages';
  dataSection.appendChild(name);

  for (let apps in res) {
        console.log(res[apps]);
        let name = document.createElement('p');
        name.innerHTML = "ID: " + res[apps].id + " | Employee ID: " + res[apps].eid + " | Message: " + res[apps].message;
        dataSection.appendChild(name);
                
    }

}

function getMessage() {

  let url = 'http://localhost:8080/anthony_vu_project_one/employeepage';

  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = receiveData;

  function receiveData() {
      console.log(this.readyState);

      if (this.readyState == 4) {
          let r = this.responseText;

          r = JSON.parse(r);

          console.log(r);
      }
  }

  xhttp.open('GET', url, true);


  xhttp.send(); 

}

function cookieMessage() {

  let c = JSON.parse(getCookie("newmessage"));
  let d = JSON.parse(c);

  console.log(d);
  
  let dataSection = document.getElementById('message');
  let name = document.createElement('h1');
  name.innerHTML = 'Messages';
  dataSection.appendChild(name);

  for (let apps in d) {
        console.log(res[apps]);
        let name = document.createElement('p');
        name.innerHTML = "ID: " + d[apps].id + " | Employee ID: " + d[apps].eid + " | Message: " + d[apps].message;
        dataSection.appendChild(name);
                
    }

}

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

async function apply() {
  let x = JSON.parse(getCookie("userinfo"));
  let y = JSON.parse(x);  
  console.log(y.depart);

  let url = "http://localhost:8080/anthony_vu_project_one/employeepage";

  let user = {
      eid: document.getElementById('eid').value,
      todayDate: document.getElementById('date').value,
      location: document.getElementById('states').value,
      description: document.getElementById('eventdescript').value,
      cost: document.getElementById('cost').value,
      grade: document.getElementById('grade').value,
      present: document.getElementById('present').value,
      event: document.getElementById('source').value,
      justify: document.getElementById('reason').value,
      depart: y.depart,
      admin1: false,
      admin2: false,
      admin3: false
  }

  console.log(JSON.stringify(user));

  let res = await fetch(url, {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(user)
  });

  let resJson = await res.json()
  .then(res => {
      console.log(res);

  })
  .catch(error => {
      console.log(error);
  })

}

function logEmployeeOut(){
  deleteAllCookies();
  window.open("http://localhost:8080/anthony_vu_project_one/static/login.html","_self");
}
//Cookie Helper functions
function deleteAllCookies() {
  var cookies = document.cookie.split(";");
  for (var i = 0; i < cookies.length; i++) {
      var cookie = cookies[i];
      var eqPos = cookie.indexOf("=");
      var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
      document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
  }
}


//function getEmployee() {
//
//    let url = 'http://localhost:8080/anthony_vu_project_one/static/login';
//
//    let xhttp = new XMLHttpRequest();
//
//    xhttp.onreadystatechange = receiveData;
//
//    xhttp.open('POST', url, true);
//
//    xhttp.send();
//    console.log('Maybe Got Here');
//
//    function receiveData() {
//        let datasection = document.getElementById('data');
//        datasection.innerHTML = '';
//        console.log('Got Here');
//
//        if (xhttp.readyState == 4 && xhttp.status == 200) {
//            let r = xhttp.responseText;
//            console.log(r);
//
//            r = JSON.parse(r);
//            console.log(r);
//
//            populateData(r)
//        }
//    }
//}
//
