async function login() {

    let url = "http://localhost:8080/anthony_vu_project_one/login";

    let user = {
        username: document.getElementById('lastname').value,
        password: document.getElementById('eid').value
    }

    console.log(user);

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
        console.log('error');
    })

}