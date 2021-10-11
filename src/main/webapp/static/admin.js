function load() {
    let x = JSON.parse(getCookie("userinfo"));
    let y = JSON.parse(x);
    console.log(y);
    populateData(y);

    let h = JSON.parse(getCookie("department"));
    let i = JSON.parse(h);
    populateApp(i);

    let o = JSON.parse(getCookie("adminmessenger"));
    let p = JSON.parse(o);
    console.log(p);
    populateMessage(p);


}
function populateData(res) {
     let dataSection = document.getElementById('data');

     let name = document.createElement('h1');
     name.innerHTML = "Hello" + " " + res.firstname + " " + res.lastname;
     dataSection.appendChild(name);

}

function populateMessage(res) {
  let dataSection = document.getElementById('message');

  let name = document.createElement('h1');
  name.innerHTML = 'Messages';
  dataSection.appendChild(name);

  for (let apps in res) {
        console.log(res[apps]);
        let name = document.createElement('p');
        name.innerHTML = "ID: " + res[apps].id + " | Director: " + res[apps].lastname + " | Message: " + res[apps].message;
        dataSection.appendChild(name);
                
    }

}

function getApplications() {

  let url = 'http://localhost:8080/anthony_vu_project_one/adminpage';

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

function populateApp(res){
    let dataSection = document.getElementById('application');
    
    for (let apps in res) {
        console.log(res[apps]);
        let name = document.createElement('p');
        name.innerHTML = "ID: " + res[apps].id + " | Employee ID: " + res[apps].eid + 
                          " | Type of Event: " + res[apps].event + " | Event Grade: " + res[apps].grade + " | Cost of Event: " + res[apps].cost + 
                          " | Department: Department " + res[apps].depart + " | Level 1 Approval: " + res[apps].admin1 + " | Level 2 Approval: " + res[apps].admin2 + 
                          " | Level 3 Approval: " + res[apps].admin3;
        dataSection.appendChild(name); 
    }

}

// document.getElementById("apps").addEventListener('click', approval);
function approve() {

    let x = JSON.parse(getCookie("userinfo"));
    let y = JSON.parse(x);

    let url = "http://localhost:8080/anthony_vu_project_one/adminpage";

    let id = document.getElementById('id').value;
    let eid = document.getElementById('eid').value;
    let last = document.getElementById('last').value;

    let choice = document.getElementById('approval').value;
    let reason = document.getElementById('why').value;
    let message = document.getElementById('talk').value;
    
    let user = {
      id: id,
      eid: eid,
      choice: choice,
      reason: reason,
      last: last,
      lastname: y.lastname,
      message: message,
      adminlevel: y.adminlevel,
      depart: y.depart
    }

    console.log(user);
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;

            console.log(r);
            console.log("Here");
        }
    }
    xhttp.open('POST', 'http://localhost:8080/anthony_vu_project_one/adminpage', true);

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(user));

    let dataSection = document.getElementById('validate');

    let name = document.createElement('p');
    name.innerHTML = "You have Submitted Your Request.";
    dataSection.appendChild(name); 

}

function messenger() {

  let x = JSON.parse(getCookie("userinfo"));
  let y = JSON.parse(x);

  let url = "http://localhost:8080/anthony_vu_project_one/adminpage";

  let message = document.getElementById('talk').value;
  
  let user = {
    message: message,
    lastname: y.lastname
  }

  console.log(user);
  let xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function () {

      if (this.readyState == 4 && this.status == 200) {
          let r = this.responseText;

          console.log(r);
          console.log("Here");
      }
  }
  xhttp.open('GET', 'http://localhost:8080/anthony_vu_project_one/adminpage', true);

  xhttp.setRequestHeader('Content-Type', 'application/json');

  xhttp.send(JSON.stringify(user));

  let dataSection = document.getElementById('validate');

  let name = document.createElement('p');
  name.innerHTML = "You have Submitted Your Request.";
  dataSection.appendChild(name); 

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
